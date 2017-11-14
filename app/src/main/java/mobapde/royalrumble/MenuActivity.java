package mobapde.royalrumble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mobapde.royalrumble.R;

public class MenuActivity extends AppCompatActivity {

    Button play, options, credits, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        play = (Button) findViewById(R.id.btn_play);
        options = (Button) findViewById(R.id.btn_option);
        credits = (Button) findViewById(R.id.btn_credits);
        quit = (Button) findViewById(R.id.btn_quit);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, GameMenuActivity.class);
                MenuActivity.this.startActivity(i);
            }
        });

    }
}
