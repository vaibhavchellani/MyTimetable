package com.example.vaibhavchellani.my_timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;


/**
 * Created by vaibhavchellani on 1/28/17.
 */

public class showtimetable extends AppCompatActivity implements View.OnClickListener {
    AttedanceDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_day);
        db = new AttedanceDB(this);

        Button button=(Button) findViewById(R.id.day_monday);
        button.setOnClickListener(this);
        findViewById(R.id.day_tuesday).setOnClickListener(this);
        findViewById(R.id.day_wednesday).setOnClickListener(this);
        findViewById(R.id.day_thursday).setOnClickListener(this);
        findViewById(R.id.day_friday).setOnClickListener(this);

    }
    //this fucking thing is not being executed
    public void onClick(View v) {

        Intent startnext= new Intent(this,today_timetable.class);


        switch (v.getId()) {
            case R.id.day_monday: {
                // do something for button 1 click/*
                /*String  send_to_intent = db.getTableAsString(AttedanceDB.TABLE_CHECK_CLASS);
                Toast.makeText(this, "so its monday after all"+send_to_intent, Toast.LENGTH_SHORT).show();*/
                String dbstring = db.databaseToString(db.TABLE_CHECK_CLASS,"MONDAY");
                startnext.putExtra("toprint", dbstring);
                startActivity(startnext);
                break;
            }

            case R.id.day_tuesday: {
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


        }
    }
}