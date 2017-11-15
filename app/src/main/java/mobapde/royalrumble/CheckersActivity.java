package mobapde.royalrumble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import mobapde.royalrumble.game.PixelGridView;

public class CheckersActivity extends AppCompatActivity
{
    LinearLayout gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkers);

        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setType("checkers");
        pixelGrid.setNumColumns(8);
        pixelGrid.setNumRows(8);

        gridView = (LinearLayout) findViewById(R.id.grid);
        gridView.addView(pixelGrid);
    }
}
