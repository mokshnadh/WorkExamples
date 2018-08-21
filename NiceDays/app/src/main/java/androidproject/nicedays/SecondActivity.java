package androidproject.nicedays;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {
    private Button button11;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button11 = (Button) findViewById(R.id.buttonClose);

        videoView = (VideoView) findViewById(R.id.videoView2);
    }

    public void buttonPlay(View view) {

        String uriPath2 = "android.resource://androidproject.anothernotification/" + R.raw.trail;
        Uri uri = Uri.parse(uriPath2);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    public void buttonClose(View view) {
        if (view == button11) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
}





