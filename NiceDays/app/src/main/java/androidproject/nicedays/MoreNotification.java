package androidproject.nicedays;

/**
 * Created by USER on 4/23/2017.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Called when the notification is clicked on in the task bar
public class MoreNotification extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        startActivity(new Intent(this,WelcomeActivity.class));
    }
}
