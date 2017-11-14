package mobapde.royalrumble;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
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
