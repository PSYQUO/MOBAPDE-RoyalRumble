package mobapde.royalrumble;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));

//        TextView iv = (TextView) findViewById(R.id.touch_start);
//        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
//                iv,
//                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
//                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
//        scaleDown.setDuration(310);
//        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
//        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
//        scaleDown.start();

//        PixelGridView pixelGrid = new PixelGridView(this);
//        pixelGrid.setNumColumns(10);
//        pixelGrid.setNumRows(10);
//        setContentView(pixelGrid);
    }
}
