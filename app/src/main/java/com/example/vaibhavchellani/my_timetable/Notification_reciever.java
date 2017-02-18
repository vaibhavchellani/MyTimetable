package com.example.vaibhavchellani.my_timetable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentSender;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vaibhavchellani on 2/4/17.
 */
public class Notification_reciever extends BroadcastReceiver{
    AttedanceDB db;
    @Override
    public void onReceive(Context context, Intent intent) {
        db=new AttedanceDB(context);
        String send_to_notif="";

        NotificationManager notificationmanager= (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);


        Intent repeating_intent= new Intent(context,showattendance.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);


        if(intent.getAction().equalsIgnoreCase("lecture 1")){

            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE1,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 2")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE2,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 3")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE3,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 4")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE4,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 5")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE5,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 6")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE6,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 7")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE7,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 8")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE8,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 9")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE9,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 10")){
            send_to_notif=(db.getNextClass(db.COLUMN_LECTURE10,getCurrentDay()));
        }
        else {
            send_to_notif=("no lecture ");
        }

        final Notification.Builder builder = new Notification.Builder(context);
        builder.setStyle(new Notification.BigTextStyle(builder)
                .bigText(send_to_notif)
                .setBigContentTitle("EXPAND TO SEE MORE")
                .setSummaryText("Pretty good, right ;)"))
                .setContentTitle("Greetings")
                .setContentText("Your next class is ")
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon);
        //for having unique notification id
        long time = new Date().getTime();
        String tmpStr = String.valueOf(time);
        String last4Str = tmpStr.substring(tmpStr.length() - 5);
        int notificationid = Integer.valueOf(last4Str);

        notificationmanager.notify(notificationid,builder.build());

    }
    public String getCurrentDay(){

        String daysArray[] = {"SUNDAY","MONDAY","TUESDAY", "WEDNESDAY","THURSDAY","FRIDAY", "SATURDAY"};

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //todo change to day-1
        return daysArray[day-1];

    }
}
