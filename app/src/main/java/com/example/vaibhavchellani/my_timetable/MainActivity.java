package com.example.vaibhavchellani.my_timetable;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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

import static com.example.vaibhavchellani.my_timetable.R.id.button_contact;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_year,spinner_branch,spinner_shift;

    private TextView textview;

    private static final int uniqueID = 45612;

    private TextView textView_year,textView_branch,textView_shift;
    AttedanceDB db;
    Notification_reciever hey;
    private Button button_contact;


    private static final String[] year = {"None Selected", "I Year", "II Year", "III Year ", "IV year", "Extra year ;)"};
    private static final String[] branch = {"None Selected", "IT", "CSE", "ECE", "ICE"};
    private static final String[] shift = {"None Selected", "Evening Shift","Morning Shift"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingpage);
        //hey= new Notification_reciever();
        db = new AttedanceDB(this);
        db.addrow_check_class();
        db.make_attendance_table();

        button_contact=(Button)findViewById(R.id.button_contact);
        button_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo to put email option
                composeEmail("TIMETABLE APP FEEDBACK");
            }
        });

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar timeOff9 = Calendar.getInstance();
        AlarmManager alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //first intent for first lecture
        Intent intent1 = new Intent(this, Notification_reciever.class);
        intent1.setAction("lecture 1");
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 10);
        timeOff9.set(Calendar.MINUTE, 10);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent1);


        //second intent for second lecture
        Intent intent2 = new Intent(this, Notification_reciever.class);
        intent2.setAction("lecture 2");
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2 , 0);
        timeOff9.set(Calendar.HOUR_OF_DAY, 11);
        timeOff9.set(Calendar.MINUTE,5);
        timeOff9.set(Calendar.SECOND, 30);
        //todo edit the time here
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent2);


        //third intent for 3 lecture
        Intent intent3 = new Intent(this, Notification_reciever.class);
        intent3.setAction("lecture 3");
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(this, 0, intent3, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 12);
        timeOff9.set(Calendar.MINUTE, 16);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent3);

        //FOURTH INTENT
        Intent intent4 = new Intent(this, Notification_reciever.class);
        intent4.setAction("lecture 4");
        PendingIntent pendingIntent4 = PendingIntent.getBroadcast(this, 0, intent4, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 12);
        timeOff9.set(Calendar.MINUTE, 30);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent4);

        //FIFTH INTENT
        Intent intent5 = new Intent(this, Notification_reciever.class);
        intent5.setAction("lecture 5");
        PendingIntent pendingIntent5 = PendingIntent.getBroadcast(this, 0, intent5, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 13);
        timeOff9.set(Calendar.MINUTE, 25);
        timeOff9.set(Calendar.SECOND, 30);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent5);

        //SIXTH INTENT
        Intent intent6 = new Intent(this, Notification_reciever.class);
        intent6.setAction("lecture 6");
        PendingIntent pendingIntent6 = PendingIntent.getBroadcast(this, 0, intent6, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 14);
        timeOff9.set(Calendar.MINUTE, 20);
        timeOff9.set(Calendar.SECOND, 30);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent6);

        //SEVENTH INTENT
        Intent intent7 = new Intent(this, Notification_reciever.class);
        intent7.setAction("lecture 7");
        PendingIntent pendingIntent7 = PendingIntent.getBroadcast(this, 0, intent7, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 15);
        timeOff9.set(Calendar.MINUTE, 15);
        timeOff9.set(Calendar.SECOND, 30);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        //todo set repeating
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent7);


        //EIGHTH INTENT
        Intent intent8 = new Intent(this, Notification_reciever.class);
        intent8.setAction("lecture 8");
        PendingIntent pendingIntent8 = PendingIntent.getBroadcast(this, 0, intent8, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 16);
        timeOff9.set(Calendar.MINUTE, 15);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent8);

        //NINTH INTENT
        Intent intent9 = new Intent(this, Notification_reciever.class);
        intent3.setAction("lecture 9");
        PendingIntent pendingIntent9 = PendingIntent.getBroadcast(this, 0, intent9, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 16);
        timeOff9.set(Calendar.MINUTE, 35);
        timeOff9.set(Calendar.SECOND, 30);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent9);


        //TENTH INTENT
        Intent intent10 = new Intent(this, Notification_reciever.class);
        intent3.setAction("lecture 10");
        PendingIntent pendingIntent10 = PendingIntent.getBroadcast(this, 0, intent10, 0);

        timeOff9.set(Calendar.HOUR_OF_DAY, 17);
        timeOff9.set(Calendar.MINUTE, 15);
        timeOff9.set(Calendar.SECOND, 0);
        if(timeOff9.before(calendar))
            timeOff9.add(Calendar.DAY_OF_MONTH,1);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, timeOff9.getTimeInMillis(), pendingIntent10);


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

        findViewById(R.id.delete_databse_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteTable(db.TABLE_ATTENDANCE);

            }
        });



        /*textView_year=(TextView)findViewById(R.id.select_year_textview);
        textView_branch=(TextView)findViewById(R.id.select_branch_textview);
        textView_shift=(TextView)findViewById(R.id.select_shift_textview);

        spinner_year=(Spinner)findViewById(R.id.spinner_year);
        spinner_branch=(Spinner)findViewById(R.id.spinner_branch);
        spinner_shift=(Spinner)findViewById(R.id.spinner_shift);


        ArrayAdapter<String> adapter_year=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,year);
        ArrayAdapter<String> adapter_branch=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,branch);
        ArrayAdapter<String> adapter_shift=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,shift);


        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(adapter_year);
        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //do nothing
                }
                else {
                    String item_year = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, "hi the item is " + item_year, Toast.LENGTH_SHORT).show();
                    //load up timetable for respective year
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });

        adapter_branch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_branch.setAdapter(adapter_branch);
        spinner_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //do nothing
                }
                else {
                    String item_branch = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, "hi the item is " + item_branch, Toast.LENGTH_SHORT).show();
                    //load up timetable for respective year
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });


        adapter_shift.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_shift.setAdapter(adapter_shift);
        spinner_shift.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //do nothing
                }
                else {
                    String item_shift = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, "hi the item is " + item_shift, Toast.LENGTH_SHORT).show();
                    //load up timetable for respective year
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });*/
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




}






