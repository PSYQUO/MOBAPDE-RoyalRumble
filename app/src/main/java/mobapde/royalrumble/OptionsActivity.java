package mobapde.royalrumble;

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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        back_btn_options = (ImageView) findViewById(R.id.back_btn_options);
        et_username = (EditText) findViewById(R.id.et_username);
        btn_picture = (Button) findViewById(R.id.btn_picture);
        fx_volume = (SeekBar) findViewById(R.id.fx_volume);
        bg_volume = (SeekBar) findViewById(R.id.bg_volume);

        back_btn_options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
