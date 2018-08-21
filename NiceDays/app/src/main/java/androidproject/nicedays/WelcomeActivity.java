package androidproject.nicedays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button9,button10;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView = (ImageView)findViewById(R.id.imageView4);
          button9 = (Button)findViewById(R.id.Thanksbutton);
          button10 = (Button)findViewById(R.id.NoThanksbutton);

        button9.setOnClickListener(this);
        button10.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view == button9){
            startActivity(new Intent(this, FirstActivity.class));
            finish();
        }
        if (view == button10){
            startActivity(new Intent(this, SecondActivity.class));
            finish();
        }
    }
}


