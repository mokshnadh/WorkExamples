/**
 *
 */
package androidproject.nicedays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button12;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button12 = (Button) findViewById(R.id.Closebutton);

        imageView = (ImageView) findViewById(R.id.imageView2);

        button12.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == button12) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
}
