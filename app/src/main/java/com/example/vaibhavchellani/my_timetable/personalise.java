package com.example.vaibhavchellani.my_timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vaibhavchellani on 3/5/17.
 */

public class personalise extends AppCompatActivity {

    private Button saveButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalise);
        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username",null);
       final EditText usernameEditText =(EditText)findViewById(R.id.username_edittext);
            usernameEditText.setText(username);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("username",usernameEditText.getText().toString());
                editor.commit();
                finish();
            }
        });

    }


}
