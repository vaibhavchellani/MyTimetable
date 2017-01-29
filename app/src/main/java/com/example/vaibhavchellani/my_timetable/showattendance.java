package com.example.vaibhavchellani.my_timetable;

import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

/**
 * Created by vaibhavchellani on 1/29/17.
 */

public class showattendance extends AppCompatActivity implements View.OnClickListener {
    AttedanceDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_list);

        db = new AttedanceDB(this);
        findViewById(R.id.AM_button).setOnClickListener(this);
        findViewById(R.id.TOC_button).setOnClickListener(this);
        findViewById(R.id.DBMS_button).setOnClickListener(this);
        findViewById(R.id.CS_button).setOnClickListener(this);
        findViewById(R.id.OOPS_button).setOnClickListener(this);
        findViewById(R.id.COA_button).setOnClickListener(this);


    }

    public void onClick(View v){
        Intent intent=new Intent(this,alter_attendance.class);
        switch (v.getId()) {
            case R.id.AM_button: {
                // do something for button 1 click/*
                /*String  send_to_intent = db.getTableAsString(AttedanceDB.TABLE_CHECK_CLASS);
                Toast.makeText(this, "so its monday after all"+send_to_intent, Toast.LENGTH_SHORT).show();*/
                intent.putExtra("subject","AM");
                startActivity(intent);
                break;
            }

            /*case R.id.day_tuesday: {
                // do something for button 2 click
                String dbstring = db.databaseToString(db.TABLE_CHECK_CLASS,"TUESDAY");
                startnext.putExtra("toprint", dbstring);
                startActivity(startnext);
                break;
            }

            case R.id.day_wednesday: {
                // do something for button 2 click
                String dbstring = db.databaseToString(db.TABLE_CHECK_CLASS,"WEDNESDAY");
                startnext.putExtra("toprint", dbstring);
                startActivity(startnext);
                break;
            }

            case R.id.day_thursday: {
                // do something for button 2 click
                String dbstring = db.databaseToString(db.TABLE_CHECK_CLASS,"THURSDAY");
                startnext.putExtra("toprint", dbstring);
                startActivity(startnext);
                break;
            }
            case R.id.day_friday: {
                // do something for button 2 click
                String dbstring = db.databaseToString(db.TABLE_CHECK_CLASS,"FRIDAY");
                startnext.putExtra("toprint", dbstring);
                startActivity(startnext);
                break;
            }

            //.... etc
            */


        }
    }


}

