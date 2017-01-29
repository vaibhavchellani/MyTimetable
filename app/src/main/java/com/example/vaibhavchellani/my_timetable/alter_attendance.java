package com.example.vaibhavchellani.my_timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

import org.w3c.dom.Text;

/**
 * Created by vaibhavchellani on 1/29/17.
 */

public class alter_attendance extends AppCompatActivity  {
    AttedanceDB db;
    TextView present_view,absent_view;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter_activity);
        db=new AttedanceDB(this);
        //extras has the subject chosen make query accordingly
        extras = getIntent().getExtras();
        present_view=(TextView)findViewById(R.id.view_present_counter);
        present_view.setText(db.view_attendance(db.COLUMN_PRESENT_COUNTER,extras.getString("subject")));


        absent_view=(TextView)findViewById(R.id.view_absent_counter);
        absent_view.setText(" ");
        absent_view.setText(db.view_attendance(db.COLUMN_ABSENT_COUNTER,extras.getString("subject")));

        findViewById(R.id.add_present_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.subtract_present_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.add_absent_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.subtract_absent_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

}
