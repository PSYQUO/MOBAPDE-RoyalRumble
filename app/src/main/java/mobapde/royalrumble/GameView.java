package mobapde.royalrumble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Patrick Sy on 11/13/2017.
 */

public class GameView extends View
{
    Paint paint;

    public GameView(Context context)
    {
        super(context);

        paint = new Paint();
        paint.setARGB(225, 128, 128, 128);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(150, 150, 55, paint);
    }
}
