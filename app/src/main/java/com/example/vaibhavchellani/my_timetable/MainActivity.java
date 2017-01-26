package com.example.vaibhavchellani.my_timetable;

import android.database.sqlite.SQLiteDatabase;
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

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_year,spinner_branch,spinner_shift;

    private TextView textview;

    private static final int uniqueID = 45612;

    private TextView textView_year,textView_branch,textView_shift;
    AttedanceDB db;


    private static final String[] year = {"None Selected", "I Year", "II Year", "III Year ", "IV year", "Extra year ;)"};
    private static final String[] branch = {"None Selected", "IT", "CSE", "ECE", "ICE"};
    private static final String[] shift = {"None Selected", "Evening Shift","Morning Shift"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trial);

        db = new AttedanceDB(this);
        db.addrow_check_class();
        db.make_attendance_table();



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

    public void startnotif() {

    }



}






