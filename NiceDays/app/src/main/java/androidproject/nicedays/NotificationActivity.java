package androidproject.nicedays;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.GregorianCalendar;


public class NotificationActivity extends AppCompatActivity  {

    private Button button2, button3;
    Button showNotificationBut, alertButton, Button3, Button4, Button5, Button6;
    private ImageView imageView;

    NotificationManager notificationManager;

    // Used to track notifications
    int notifID = 33;

    // Used to track if notification is active in the task bar
    boolean isNotificActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        imageView = (ImageView) findViewById(R.id.imageButton5);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        showNotificationBut = (Button) findViewById(R.id.showNotificationBut);
        alertButton = (Button) findViewById(R.id.alertButton);
        Button3 = (Button) findViewById(R.id.button);
        Button6 = (Button) findViewById(R.id.button10);
        Button5 = (Button) findViewById(R.id.button11);
        Button3 = (Button) findViewById(R.id.button12);
        Button4 = (Button) findViewById(R.id.button16);

    }

    public void showNotification(View view) {

        NotificationCompat.Builder notificBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Message")
                .setContentText("New Message")
                .setTicker("Alert New Message")
                .setSmallIcon(R.drawable.ntt_logo_24_24);

        Intent moreInfoIntent = new Intent(this, MoreNotification.class);

        TaskStackBuilder tStackBuilder = TaskStackBuilder.create(this);

        tStackBuilder.addParentStack(MoreNotification.class);

        tStackBuilder.addNextIntent(moreInfoIntent);

        PendingIntent pendingIntent = tStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        notificBuilder.setContentIntent(pendingIntent);

        notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifID, notificBuilder.build());

        isNotificActive = true;


    }

    public void setAlarm(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 5 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public void OneHourClick(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 3600 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Notification Time One Hour Selected...", Toast.LENGTH_LONG).show();
    }

    public void TwoHourClick(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 7200 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Notification Time Two Hour Selected...", Toast.LENGTH_LONG).show();
    }

    public void ThreeHourClick(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 10800 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Notification Time Three Hour Selected...", Toast.LENGTH_LONG).show();
    }

    public void FourHourClick(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 14400 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Notification Time Four Hour Selected...", Toast.LENGTH_LONG).show();
    }

    public void FiveHourClick(View view) {

        Long alertTime = new GregorianCalendar().getTimeInMillis() + 18000 * 1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Notification Time Five Hour Selected...", Toast.LENGTH_LONG).show();
    }
    public void buttonBack(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void buttonNext(View view) {
        startActivity(new Intent(this, QuotesActivity.class));
    }
}
