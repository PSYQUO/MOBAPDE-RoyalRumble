package mobapde.royalrumble;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import mobapde.royalrumble.game.Board;
import mobapde.royalrumble.game.PixelGridView;
import mobapde.royalrumble.game.Player;
import mobapde.royalrumble.game.TTTGridView;
import mobapde.royalrumble.game.TicTacToe;

public class TicTacToeActivity extends AppCompatActivity
{
    LinearLayout gridView;
    ImageView pause_btn;
    Button resume_btn, restart_btn, quit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        TTTGridView pixelGrid = new TTTGridView(this);
        pixelGrid.setNumColumns(3);
        pixelGrid.setNumRows(3);


        gridView = (LinearLayout) findViewById(R.id.grid);
        gridView.addView(pixelGrid);
        pause_btn = (ImageView) findViewById(R.id.pause_btn);
        pause_btn.setClickable(true);


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pause);
        final Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        resume_btn = (Button) dialog.findViewById(R.id.resume_btn);
        restart_btn = (Button) dialog.findViewById(R.id.restart_btn);
        quit_btn = (Button) dialog.findViewById(R.id.quit_btn);

        resume_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        restart_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        quit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(CheckersActivity.this, GameMenuActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);*/
                finish();
            }
        });


        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {

                dialog.show();

            }
        });
    }
}
