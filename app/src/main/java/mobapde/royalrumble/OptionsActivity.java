package mobapde.royalrumble;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

public class OptionsActivity extends AppCompatActivity
{
    ImageView back_btn_options;
    EditText et_username;
    Button btn_picture;
    SeekBar fx_volume, bg_volume;
    ImageView player1_pic, player2_pic;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        back_btn_options = (ImageView) findViewById(R.id.back_btn_options);
        et_username = (EditText) findViewById(R.id.et_username);
        btn_picture = (Button) findViewById(R.id.btn_picture);
        fx_volume = (SeekBar) findViewById(R.id.fx_volume);
        bg_volume = (SeekBar) findViewById(R.id.bg_volume);
        player1_pic = (ImageView) findViewById(R.id.player1_pic);
        player2_pic = (ImageView) findViewById(R.id.player2_pic);

        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // dispatchTakePictureIntent();
            }
        });

        back_btn_options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            player1_pic.setImageBitmap(imageBitmap);
        }
    }
}
