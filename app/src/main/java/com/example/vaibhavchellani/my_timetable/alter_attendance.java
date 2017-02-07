package com.example.vaibhavchellani.my_timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

import org.w3c.dom.Text;

/**
 * Created by vaibhavchellani on 1/29/17.
 */

public class alter_attendance extends AppCompatActivity  {
    AttedanceDB db;
    TextView below_percentage,present_view,absent_view,percentage_view,no_of_classes;

    int present,absent,present1,absent1,no;
    float percentage;

    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter_activity);
        db=new AttedanceDB(this);
        //extras has the subject chosen make query accordingly
        extras = getIntent().getExtras();
        no_of_classes=(TextView)findViewById(R.id.no_of_classes_view);
        percentage_view=(TextView)findViewById(R.id.percentage_textview);
        present_view=(TextView)findViewById(R.id.view_present_counter);
        present_view.setText(db.view_attendance(db.COLUMN_PRESENT_COUNTER,extras.getString("subject")));


        below_percentage=(TextView)findViewById(R.id.below_percentage_textview);

        absent_view=(TextView)findViewById(R.id.view_absent_counter);
        absent_view.setText(db.view_attendance(db.COLUMN_ABSENT_COUNTER,extras.getString("subject")));
        alter();
        update_noOfClasses();

        findViewById(R.id.add_present_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int present_counter=db.add_attendance(extras.getString("subject"),db.COLUMN_PRESENT_COUNTER);
                present_view.setText(Integer.toString(present_counter));
                alter();
                update_noOfClasses();
            }
        });
        findViewById(R.id.subtract_present_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 1/29/17 send query ,get what is stored ,decrement it and display
                int present_counter=db.subtract_attendance(extras.getString("subject"),db.COLUMN_PRESENT_COUNTER);

                if(present_counter!=-1)
                    present_view.setText(Integer.toString(present_counter));
                else
                    Toast.makeText(alter_attendance.this, "cannot go in negative !", Toast.LENGTH_SHORT).show();
                alter();
                update_noOfClasses();
            }
        });
        findViewById(R.id.add_absent_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int absent_counter=db.add_attendance(extras.getString("subject"),db.COLUMN_ABSENT_COUNTER);
                absent_view.setText(Integer.toString(absent_counter));
                alter();
                update_noOfClasses();

            }
        });
        findViewById(R.id.subtract_absent_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int present_counter=db.subtract_attendance(extras.getString("subject"),db.COLUMN_ABSENT_COUNTER);

                if(present_counter!=-1)
                    absent_view.setText(Integer.toString(present_counter));
                else
                    Toast.makeText(alter_attendance.this, "cannot go in negative !", Toast.LENGTH_SHORT).show();
                alter();
                update_noOfClasses();
            }
        });

    }

    public void alter(){
    present=db.getAttendanceInInt(db.COLUMN_PRESENT_COUNTER,extras.getString("subject"));
    absent =db.getAttendanceInInt(db.COLUMN_ABSENT_COUNTER,extras.getString("subject"));

    if(present!=0 || absent !=0) {
        Toast.makeText(this, "inside if ", Toast.LENGTH_SHORT).show();
        int total=present+absent;
        percentage = (present*100)/total;

        percentage_view.setText(Float.toString(percentage)+"%");

        if (percentage < 30)
            below_percentage.setText("Oh No Dear!, koi nhi external faad dena !");
        if (percentage < 50 && percentage>30) {
            below_percentage.setText("good going ,target for 70 then youre set !");
        }
        if (percentage < 70 && percentage>50)
            below_percentage.setText("wohoo you rock dude ,relax at home and please mass bunk now");
        if (percentage <= 100 && percentage > 70)
            below_percentage.setText("BAS KAR BHAI AB ");

    }
        else
        Toast.makeText(this, "Welcome , start by giving input to present and absent attendance counters", Toast.LENGTH_SHORT).show();

    }
    public void update_noOfClasses(){
        present1=db.getAttendanceInInt(db.COLUMN_PRESENT_COUNTER,extras.getString("subject"));
        absent1 =db.getAttendanceInInt(db.COLUMN_ABSENT_COUNTER,extras.getString("subject"));

        no=(7*absent1)/3;
        int finalno=no-present1;
        no_of_classes.setText(Integer.toString(finalno));

    }
}
