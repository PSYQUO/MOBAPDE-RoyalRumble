package mobapde.royalrumble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameMenuActivity extends AppCompatActivity {

    Button join, local, host;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        join = (Button) findViewById(R.id.btn_join);
        local = (Button) findViewById(R.id.btn_local);
        host = (Button) findViewById(R.id.btn_host);
        back_btn = (ImageView) findViewById(R.id.back_btn_play);
        back_btn.setClickable(true);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        host.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(GameMenuActivity.this, RPSActivity.class);
//                GameMenuActivity.this.startActivity(i);
//            }
//        });

//        join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(GameMenuActivity.this, CheckersActivity.class);
//                GameMenuActivity.this.startActivity(i);
//            }
//        });

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameMenuActivity.this, TicTacToeLocalActivity.class);
                GameMenuActivity.this.startActivity(i);
            }
        });

    }
}
