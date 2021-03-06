package mobapde.royalrumble;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity
{
    Button play, options, credits, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        play = (Button) findViewById(R.id.btn_play);
        options = (Button) findViewById(R.id.btn_option);
        credits = (Button) findViewById(R.id.btn_credits);
        quit = (Button) findViewById(R.id.btn_quit);

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MenuActivity.this, GameMenuActivity.class);
                MenuActivity.this.startActivity(i);
            }
        });

        options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MenuActivity.this, OptionsActivity.class);
                MenuActivity.this.startActivity(i);
            }
        });

        credits.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MenuActivity.this, CreditsActivity.class);
                MenuActivity.this.startActivity(i);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
