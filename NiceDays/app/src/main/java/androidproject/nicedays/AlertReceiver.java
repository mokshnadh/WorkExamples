package androidproject.nicedays; //It is a namespace that organizes a setof related classes and interfaces

/**
 * Created by USER on 4/23/2017.
 */

import android.app.Notification; //It is used to make classes and interfaces avaliable and accessible to the current source code. 
import android.app.NotificationManager;  
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import java.util.*;

public class AlertReceiver extends BroadcastReceiver{ //Public means that the subject may be accessed by any class
                                                      //Extends means that you are creating a subclass of the class you are extending 

    // Called when a broadcast is made targeting this class
    @Override
    public void onReceive(Context context, Intent intent) {  //The keyword void simply tells the compiler that main() does not return a value

        createNotification(context, "Times Up", "Time Has Passed", "Alert");

    }

    public void createNotification(Context context, String msg, String msgText, String msgAlert){

        // Define an Intent and an action to perform with it by another application
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, WelcomeActivity.class), 0);

        // Builds a notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ntt_logo_24_24)
                        .setContentTitle(msg)
                        .setTicker(msgAlert)
                        .setContentText(msgText);

        // Defines the Intent to fire when the notification is clicked
        mBuilder.setContentIntent(notificIntent);

        // Set the default notification option
        // DEFAULT_SOUND : Make sound
        // DEFAULT_VIBRATE : Vibrate
        // DEFAULT_LIGHTS : Use the default light notification
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);

        // Auto cancels the notification when clicked on in the task bar
        mBuilder.setAutoCancel(true);

        // Gets a NotificationManager which is used to notify the user of the background event
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Post the notification
        mNotificationManager.notify(1, mBuilder.build());

    }
}



