package mobapde.royalrumble;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

import mobapde.royalrumble.game.TicTacToe;
import mobapde.royalrumble.service.ImageSaver;

import static java.lang.System.out;

public class OptionsActivity extends AppCompatActivity
{
    ImageView back_btn_options;
    EditText et_username;
    Button btn_picture;
    SeekBar fx_volume, bg_volume;
    ImageView player1_pic, player2_pic;
    View view;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        back_btn_options = (ImageView) findViewById(R.id.back_btn_options);
        et_username = (EditText) findViewById(R.id.et_username);
        et_username.setText(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("name", "none"));
        btn_picture = (Button) findViewById(R.id.btn_picture);
        fx_volume = (SeekBar) findViewById(R.id.fx_volume);
        bg_volume = (SeekBar) findViewById(R.id.bg_volume);

        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });


        back_btn_options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                sp.edit().putString("name", et_username.getText().toString()).apply();
                finish();
            }
        });
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            new ImageSaver(getBaseContext()).
                    setFileName("player_pic.png").
                    setDirectoryName("images").
                    save(imageBitmap);
        }
    }
}
