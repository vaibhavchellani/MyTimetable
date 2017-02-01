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
                intent.putExtra("subject","AM");
                startActivity(intent);
                break;
            }

            case R.id.CS_button: {
                intent.putExtra("subject","CS");
                startActivity(intent);
                break;
            }

            case R.id.TOC_button: {
                intent.putExtra("subject","TOC");
                startActivity(intent);
                break;
            }
            case R.id.OOPS_button: {
                intent.putExtra("subject","OOPS");
                startActivity(intent);
                break;
            }
            case R.id.COA_button: {
                intent.putExtra("subject","COA");
                startActivity(intent);
                break;
            }
            case R.id.DBMS_button: {
                intent.putExtra("subject","DBMS");
                startActivity(intent);
                break;
            }


            //.... etc


        }
    }


}

