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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);

        TextView iv = (TextView) findViewById(R.id.touch_start);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                iv,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(310);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();

        screen = (RelativeLayout) findViewById(R.id.title);

        Intent bgmusic = new Intent(this, BackgroundSoundService.class);
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

        /**
         * Use this for checkers
         */
//        LinearLayout gridView;
//
//        PixelGridView pixelGrid = new PixelGridView(this);
//        pixelGrid.setType("checkers");
//        pixelGrid.setNumColumns(8);
//        pixelGrid.setNumRows(8);
//        gridView = (LinearLayout) findViewById(R.id.grid);
//        gridView.addView(pixelGrid);
    }
}
