package com.example.vaibhavchellani.my_timetable;
import  android.app.AlarmManager;
import android.app.PendingIntent; import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by vaibhavchellani on 2/4/17.
 */

public class makenotif extends AppCompatActivity {

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);*/

        public void createNotif()
        {
        AlarmManager alarmMgr0 = (AlarmManager) getSystemService(ALARM_SERVICE);

        //Create pending intent & register it to your alarm notifier class
        Intent intent0 = new Intent(this, Notification_reciever.class);

        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(this, 0, intent0, 0);

        //set timer you want alarm to work (here I have set it to 8.30)
        Calendar timeOff9 = Calendar.getInstance();

        timeOff9.set(Calendar.HOUR_OF_DAY, 13);
        timeOff9.set(Calendar.MINUTE, 5);
        timeOff9.set(Calendar.SECOND, 0);

        //set that timer as a RTC Wakeup to alarm manager object
        alarmMgr0.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent0);

    }
}
