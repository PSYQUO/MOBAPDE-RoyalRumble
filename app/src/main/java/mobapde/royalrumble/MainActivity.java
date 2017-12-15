package mobapde.royalrumble;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mobapde.royalrumble.service.BackgroundSoundService;

public class MainActivity extends AppCompatActivity
{
    RelativeLayout screen;
    final int MAIN_TOUCH = 0;
    Intent bgmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);

        TextView iv = (TextView) findViewById(R.id.touch_start);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                iv,
                PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(250);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();

        screen = (RelativeLayout) findViewById(R.id.title);

         bgmusic = new Intent(this, BackgroundSoundService.class);
        startService(bgmusic);


        screen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }

    public void onPause(){
        stopService(bgmusic);
        super.onPause();

    }

}
