package mobapde.royalrumble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameMenuActivity extends AppCompatActivity {

    Button checkers, tictactoe, rps;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        checkers = (Button) findViewById(R.id.btn_checkers);
        tictactoe = (Button) findViewById(R.id.btn_tictactoe);
        rps = (Button) findViewById(R.id.btn_rps);
        back_btn = (ImageView) findViewById(R.id.back_btn_play);
        back_btn.setClickable(true);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameMenuActivity.this, RPSActivity.class);
                GameMenuActivity.this.startActivity(i);
            }
        });

        checkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameMenuActivity.this, CheckersActivity.class);
                GameMenuActivity.this.startActivity(i);
            }
        });

        tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameMenuActivity.this, TicTacToeActivity.class);
                GameMenuActivity.this.startActivity(i);
            }
        });

    }
}
