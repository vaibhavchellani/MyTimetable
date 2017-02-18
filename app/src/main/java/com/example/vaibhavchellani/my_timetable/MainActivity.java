package com.example.vaibhavchellani.my_timetable;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class MainActivity extends AppCompatActivity {
    private Spinner spinner_year,spinner_branch,spinner_shift;

    private TextView textview;

    AttedanceDB db;

    private Button button_contact,start_notif_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingpage);
        db = new AttedanceDB(this);
        db.addrow_check_class();
        db.make_attendance_table();


        findViewById(R.id.startnotifs_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarms();
                Toast.makeText(MainActivity.this, " Notification Service Activated For Today", Toast.LENGTH_SHORT).show();
            }
        });



        findViewById(R.id.button_view_timetable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent opentimetable=new Intent(MainActivity.this,showtimetable.class);
                startActivity(opentimetable);
            }
        });

        findViewById(R.id.button_view_attendance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent opentimetable=new Intent(MainActivity.this,showattendance.class);
                startActivity(opentimetable);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.landingpge_menu, menu);
        return true;
    }
    
    public void deleteDatabase(View view) {
        Toast.makeText(this, "we are inside delete", Toast.LENGTH_SHORT).show();

        db.deleteTable(AttedanceDB.TABLE_CHECK_CLASS);
        String dbstring = db.getTableAsString(AttedanceDB.TABLE_CHECK_CLASS);
        textview = (TextView) findViewById(R.id.newText);
        textview.setText(dbstring);
    }

    public void viewDatabase(View view) {
        Toast.makeText(this, "we are inside view", Toast.LENGTH_SHORT).show();
        textview=(TextView)findViewById(R.id.newText);

        String dbstring = db.getTableAsString(AttedanceDB.TABLE_ATTENDANCE);
        textview.setText(dbstring);
        Toast.makeText(this, "no of coumns are " + db.numberOfColumns(AttedanceDB.TABLE_CHECK_CLASS), Toast.LENGTH_LONG).show();

    }
    public void composeEmail( String subject) {
        String[] addresses={"vaibhavchellani223@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.contactus:
                composeEmail("Timetable app feedback");
                return true;
            case R.id.resetDatabse:
                db.deleteTable(db.TABLE_ATTENDANCE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createAlarms(){

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        AlarmManager alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //lecture 1 alarm
        Calendar timeOff1 = Calendar.getInstance();
        Intent intent1 = new Intent(this, Notification_reciever.class);
        intent1.setAction("lecture 1");
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this,0,intent1,0);
        timeOff1.set(Calendar.HOUR_OF_DAY,10);
        timeOff1.set(Calendar.MINUTE, 5);
        timeOff1.set(Calendar.SECOND, 0);
        if(timeOff1.before(calendar))
            timeOff1.add(Calendar.DAY_OF_MONTH,1);
        //todo to test this on xiomi
        if (Build.VERSION.SDK_INT >= 23) {
        // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff1.getTimeInMillis(), pendingIntent1);
        } else if (Build.VERSION.SDK_INT >= 19) {
        // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff1.getTimeInMillis(), pendingIntent1);
        } else {
        // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff1.getTimeInMillis(), pendingIntent1);
        }
        //alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff1.getTimeInMillis(), pendingIntent1);


        //second intent for second lecture
        Intent intent2 = new Intent(this, Notification_reciever.class);
        intent2.setAction("lecture 2");
        Calendar timeOff2 = Calendar.getInstance();
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2 , 0);
        timeOff2.set(Calendar.HOUR_OF_DAY,11);
        timeOff2.set(Calendar.MINUTE,5);
        timeOff2.set(Calendar.SECOND, 0);
        //todo edit the time here
        if(timeOff2.before(calendar))
            timeOff2.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff2.getTimeInMillis(), pendingIntent2);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff2.getTimeInMillis(), pendingIntent2);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff2.getTimeInMillis(), pendingIntent2);
        }


        //third intent for 3 lecture
        Intent intent3 = new Intent(this, Notification_reciever.class);
        intent3.setAction("lecture 3");
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(this, 0, intent3, 0);
        Calendar timeOff3 = Calendar.getInstance();
        timeOff3.set(Calendar.HOUR_OF_DAY,12);
        timeOff3.set(Calendar.MINUTE, 0);
        timeOff3.set(Calendar.SECOND, 0);
        if(timeOff3.before(calendar))
            timeOff3.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff3.getTimeInMillis(), pendingIntent3);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff3.getTimeInMillis(), pendingIntent3);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff3.getTimeInMillis(), pendingIntent3);
        }

        //FOURTH INTENT
        Intent intent4 = new Intent(this, Notification_reciever.class);
        intent4.setAction("lecture 4");
        PendingIntent pendingIntent4 = PendingIntent.getBroadcast(this, 0, intent4, 0);
        Calendar timeOff4 = Calendar.getInstance();
        timeOff4.set(Calendar.HOUR_OF_DAY,12);
        timeOff4.set(Calendar.MINUTE, 30);
        timeOff4.set(Calendar.SECOND, 0);
        if(timeOff4.before(calendar))
            timeOff4.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff4.getTimeInMillis(), pendingIntent4);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff4.getTimeInMillis(), pendingIntent1);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff4.getTimeInMillis(), pendingIntent4);
        }

        //FIFTH INTENT
        Intent intent5 = new Intent(this, Notification_reciever.class);
        intent5.setAction("lecture 5");
        PendingIntent pendingIntent5 = PendingIntent.getBroadcast(this, 0, intent5, 0);
        Calendar timeOff5 = Calendar.getInstance();
        timeOff5.set(Calendar.HOUR_OF_DAY,13);
        timeOff5.set(Calendar.MINUTE,25);
        timeOff5.set(Calendar.SECOND, 0);
        if(timeOff5.before(calendar))
            timeOff5.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff5.getTimeInMillis(), pendingIntent5);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff5.getTimeInMillis(), pendingIntent5);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff5.getTimeInMillis(), pendingIntent5);
        }
        /*alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff5.getTimeInMillis(), pendingIntent5);*/

        //SIXTH INTENT
        Intent intent6 = new Intent(this, Notification_reciever.class);
        intent6.setAction("lecture 6");
        PendingIntent pendingIntent6 = PendingIntent.getBroadcast(this, 0, intent6, 0);
        Calendar timeOff6 = Calendar.getInstance();
        timeOff6.set(Calendar.HOUR_OF_DAY,14);
        timeOff6.set(Calendar.MINUTE,25);
        timeOff6.set(Calendar.SECOND,0);
        if(timeOff6.before(calendar))
            timeOff6.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff6.getTimeInMillis(), pendingIntent6);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff6.getTimeInMillis(), pendingIntent6);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff6.getTimeInMillis(), pendingIntent6);
        }
        /*

        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff6.getTimeInMillis(), pendingIntent6);
*/

        //SEVENTH INTENT
        Intent intent7 = new Intent(this, Notification_reciever.class);
        intent7.setAction("lecture 7");
        PendingIntent pendingIntent7 = PendingIntent.getBroadcast(this, 0, intent7, 0);
        Calendar timeOff7 = Calendar.getInstance();
        timeOff7.set(Calendar.HOUR_OF_DAY,15);
        timeOff7.set(Calendar.MINUTE,5);
        timeOff7.set(Calendar.SECOND, 0);
        if(timeOff7.before(calendar))
            timeOff7.add(Calendar.DAY_OF_MONTH,1);
        //todo set
        // repeating
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff7.getTimeInMillis(), pendingIntent7);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff7.getTimeInMillis(), pendingIntent7);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff7.getTimeInMillis(), pendingIntent7);
        }
/*
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff7.getTimeInMillis(), pendingIntent7);
*/


        //EIGHTH INTENT
        Intent intent8 = new Intent(this, Notification_reciever.class);
        intent8.setAction("lecture 8");
        PendingIntent pendingIntent8 = PendingIntent.getBroadcast(this, 0, intent8, 0);
        Calendar timeOff8 = Calendar.getInstance();
        timeOff8.set(Calendar.HOUR_OF_DAY,16);
        timeOff8.set(Calendar.MINUTE, 0);
        timeOff8.set(Calendar.SECOND, 0);
        if(timeOff8.before(calendar))
            timeOff8.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff8.getTimeInMillis(), pendingIntent8);

        //NINTH INTENT
        Intent intent9 = new Intent(this, Notification_reciever.class);
        intent9.setAction("lecture 9");
        PendingIntent pendingIntent9 = PendingIntent.getBroadcast(this, 0, intent9, 0);
        Calendar timeOff9 = Calendar.getInstance();
        timeOff9.set(Calendar.HOUR_OF_DAY,16);
        timeOff9.set(Calendar.MINUTE,35);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent9);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent9);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent9);
        }

        //TENTH INTENT
        Intent intent10 = new Intent(this, Notification_reciever.class);
        intent10.setAction("lecture 10");
        PendingIntent pendingIntent10 = PendingIntent.getBroadcast(this, 0, intent10, 0);
        Calendar timeOff10 = Calendar.getInstance();
        timeOff10.set(Calendar.HOUR_OF_DAY,17);
        timeOff10.set(Calendar.MINUTE,0);
        timeOff10.set(Calendar.SECOND, 0);
        if(timeOff10.before(calendar))
            timeOff10.add(Calendar.DAY_OF_MONTH,1);
        if (Build.VERSION.SDK_INT >= 23) {
            // Wakes up the device in Doze Mode
            alarm_manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeOff10.getTimeInMillis(), pendingIntent10);
        } else if (Build.VERSION.SDK_INT >= 19) {
            // Wakes up the device in Idle Mode
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, timeOff10.getTimeInMillis(), pendingIntent10);
        } else {
            // Old APIs
            alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff10.getTimeInMillis(), pendingIntent10);
        }
    }




}






