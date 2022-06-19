package com.example.covid19cv;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Report extends AppCompatActivity {
    TextInputEditText municipality, startDate, symptoms;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*String[] reportData = new String[]{"firstItem"
        };
        Intent receivedIntent = getIntent();
        String muniName = receivedIntent.getStringExtra("muniName");*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        DBHelper db = new DBHelper(Report.this);

        Button submitReport = findViewById(R.id.submit);
        submitReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println("Clicked");
                CharSequence text = "Report Submitted, feel better!";
                int duration = Toast.LENGTH_SHORT;
                boolean Dbok = db.insertCase(municipality.getText().toString(),symptoms.getText().toString(),startDate.getText().toString());
                if (Dbok) {

                    Toast toast = Toast.makeText(Report.this, text, duration);
                    toast.show();
                    showdata();
                }
                else{
                    Toast toast = Toast.makeText(Report.this, "Error", duration);
                    toast.show();
                }
            }
        });
    }


private void showdata() {
    municipality.setText("");
    symptoms.setText("");
    startDate.setText("");
}
}


