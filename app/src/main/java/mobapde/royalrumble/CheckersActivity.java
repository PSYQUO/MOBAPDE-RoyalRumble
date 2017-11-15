package mobapde.royalrumble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import mobapde.royalrumble.game.Board;
import mobapde.royalrumble.game.Piece;
import mobapde.royalrumble.game.PixelGridView;
import mobapde.royalrumble.game.Player;
import static java.lang.Math.abs;

public class CheckersActivity extends AppCompatActivity {
    LinearLayout gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
