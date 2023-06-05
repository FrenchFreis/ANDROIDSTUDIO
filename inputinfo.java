package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class inputinfo extends AppCompatActivity {

    EditText lname, fname, course, year, email, date, numberphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputinfo);
        setTitle("Input Information");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fname = findViewById(R.id.editTextfirst);
        lname = findViewById(R.id.editTextlast);
        course = findViewById(R.id.editTextcourse);
        year = findViewById(R.id.editTextyear);
        email = findViewById(R.id.editTextemail);
        date = findViewById(R.id.editTextdate);
        numberphone = findViewById(R.id.inputnumber);


        Button enter = findViewById(R.id.button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fnam = fname.getText().toString();
                String lnam = lname.getText().toString();
                String phon = numberphone.getText().toString();
                String birt = date.getText().toString();
                String cours = course.getText().toString();
                String yea = year.getText().toString();
                String emai = email.getText().toString();

                Intent i = new Intent(inputinfo.this, View_Information.class);

                i.putExtra("msg1", fnam);
                i.putExtra("msg2", lnam);
                i.putExtra("msg3", phon);
                i.putExtra("msg4", birt);
                i.putExtra("msg5", cours);
                i.putExtra("msg6", yea);
                i.putExtra("msg7", emai);

                startActivity(i);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}