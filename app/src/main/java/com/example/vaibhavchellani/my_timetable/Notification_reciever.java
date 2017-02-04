package com.example.vaibhavchellani.my_timetable;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

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


        NotificationManager notificationmanager= (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);


        Intent repeating_intent= new Intent(context,showattendance.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder= new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Your Next Class IS");
        if(intent.getAction().equalsIgnoreCase("lecture 1")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE1,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 2")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE2,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 3")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE3,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 4")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE4,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 5")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE5,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 6")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE6,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 7")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE7,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 8")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE8,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 9")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE9,getCurrentDay()));
        }
        else if (intent.getAction().equalsIgnoreCase("lecture 10")){
            builder.setContentText(db.getNextClass(db.COLUMN_LECTURE10,getCurrentDay()));
        }
        else {
            builder.setContentText("no lecture ");
        }


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

        return daysArray[day+3];

    }
}
