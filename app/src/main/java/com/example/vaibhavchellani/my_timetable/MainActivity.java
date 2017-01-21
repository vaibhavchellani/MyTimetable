package com.example.vaibhavchellani.my_timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.database.AttedanceDB;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView;
    AttedanceDB db;


    private static final String[] year = {"None Selected","I Year", "II Year", "III Year ", "IV year", "Extra year ;)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trial);

        db = new AttedanceDB(this);
        db.addrow_check_class();
        String dbstring = db.databaseToString();
        textView = (TextView) findViewById(R.id.newText);
        textView.setText(dbstring);

}
    public void deleteDatabase() {
        db.deleteTable(AttedanceDB.TABLE_CHECK_CLASS);
    }
}
        /*textView=(TextView)findViewById(R.id.select_year_textview);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,year);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //do nothing
                }
                else {
                    String item = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, "hi the item is " + item, Toast.LENGTH_SHORT).show();
                    //load up timetable for respective year
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });*/






