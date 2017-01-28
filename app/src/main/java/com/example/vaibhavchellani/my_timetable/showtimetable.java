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
        Button button=(Button) findViewById(R.id.day_monday);
        button.setOnClickListener(this);
        findViewById(R.id.day_tuesday).setOnClickListener(this);
    }
    //this fucking thing is not being executed
    public void onClick(View v) {
        Toast.makeText(this, "inside dpo stuff ", Toast.LENGTH_SHORT).show();
        Intent startnext= new Intent(this,today_timetable.class);
        String send_to_intent;
        switch (v.getId()) {
            case R.id.day_monday: {
                Toast.makeText(this, "so its monday after all", Toast.LENGTH_SHORT).show();
                // do something for button 1 click
                send_to_intent = db.databaseToString("attendance", "MONDAY");
                startnext.putExtra("toprint", send_to_intent);
                startActivity(startnext);
                break;
            }

            case R.id.day_tuesday: {
                // do something for button 2 click
                break;
            }

            case R.id.day_wednesday: {
                // do something for button 2 click
                break;
            }

            //.... etc


        }
    }
}