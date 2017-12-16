package mobapde.royalrumble;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import mobapde.royalrumble.firebase.FirebaseConnection;
import mobapde.royalrumble.game.Player;
import mobapde.royalrumble.game.TTTGridView;
import mobapde.royalrumble.game.TicTacToe;
import mobapde.royalrumble.service.ImageSaver;

public class TicTacToeHostActivity extends AppCompatActivity
{
    LinearLayout gridView;
    ImageView pause_btn, player1_pic, player2_pic;
    Button resume_btn, restart_btn, quit_btn;
    TextView player1_name, player2_name;
    DatabaseReference dr;
    String state;
    String yourname;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        player1_pic = (ImageView) findViewById(R.id.player1_pic);
        player2_pic = (ImageView) findViewById(R.id.player2_pic);
        player1_name = (TextView) findViewById(R.id.player1_name);
        player2_name = (TextView) findViewById(R.id.player2_name);
        yourname = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("name1", "no name");
        player1_name.setText(yourname);


        try
        {
            player1_pic.setImageBitmap(new ImageSaver(getBaseContext()).
                    setFileName("player_pic.png").
                    setDirectoryName("images").
                    load());
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            player2_pic.setImageBitmap(new ImageSaver(getBaseContext()).
                    setFileName("player2_pic.png").
                    setDirectoryName("images").
                    load());
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pause);

        final Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        resume_btn = dialog.findViewById(R.id.resume_btn);
        restart_btn = dialog.findViewById(R.id.restart_btn);
        quit_btn = dialog.findViewById(R.id.quit_btn);
        pause_btn = (ImageView) findViewById(R.id.pause_btn);
        pause_btn.setClickable(true);

        dr = FirebaseConnection.getInstance().getReference();
        dr.child("tictactoe").child("info").child("state").setValue("waiting");
        dr.child("tictactoe").child("info").child("playerhost").setValue(yourname);

        dr.child("tictactoe").child("info").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                state = dataSnapshot.child("state").getValue(String.class);

                if(state != null && state.equals("ready"))
                {
                    player2_name.setText(dataSnapshot.child("playerjoined").getValue(String.class));
                    playGame();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.i("APP", "The read failed: " + databaseError.getCode());
            }
        });

        resume_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        restart_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
                startActivity(getIntent());
            }
        });

        quit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        pause_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.show();

            }
        });
    }

    private void playGame()
    {
        dr.child("tictactoe").child("info").child("state").setValue("game");
        System.out.println("_________________________________WE IN BOI_____________________________");
//        Player p1 = new Player(1, player1_name.getText().toString());
//        Player p2 = new Player(2, player2_name.getText().toString());
//        TicTacToe tictactoe = new TicTacToe(p1, p2);
//
//        TTTGridView pixelGrid = new TTTGridView(this, tictactoe);
//        pixelGrid.setNumColumns(3);
//        pixelGrid.setNumRows(3);
//
//        gridView = (LinearLayout) findViewById(R.id.grid);
//        gridView.addView(pixelGrid);
    }

    private String saveToInternalStorage(Bitmap bitmapImage)
    {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "profile.jpg");

        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

}
