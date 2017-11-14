package mobapde.royalrumble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class TicTacToe extends AppCompatActivity {

    LinearLayout gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setType("tictactoe");
        pixelGrid.setNumColumns(3);
        pixelGrid.setNumRows(3);


        gridView = (LinearLayout) findViewById(R.id.grid);

        gridView.addView(pixelGrid);

    }
}
