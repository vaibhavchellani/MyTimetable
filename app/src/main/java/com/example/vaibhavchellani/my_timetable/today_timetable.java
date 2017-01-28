package com.example.vaibhavchellani.my_timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by vaibhavchellani on 1/28/17.
 */
//activity to just display the string given by intent
public class today_timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todaytimetable);

        TextView showtimetable= (TextView) findViewById(R.id.textview_today_timetable);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("toprint");
            showtimetable.setText(value);
            //The key argument here must match that used in the other activity
        }


    }
}
