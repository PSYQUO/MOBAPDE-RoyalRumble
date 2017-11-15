package mobapde.royalrumble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CreditsActivity extends AppCompatActivity
{
    ImageView back_btn_credits;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        back_btn_credits = (ImageView) findViewById(R.id.back_btn_credits);

        back_btn_credits.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}
