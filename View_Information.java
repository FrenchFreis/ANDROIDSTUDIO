package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class View_Information extends AppCompatActivity {
public TextView txtbanner, txtinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_information);
        setTitle("Information");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        String view_last = intent.getStringExtra("msg2");
        String view_first = intent.getStringExtra("msg1");
        String view_year = intent.getStringExtra("msg6");
        String view_email = intent.getStringExtra("msg7");
        String view_phone = intent.getStringExtra("msg3");
        String view_date = intent.getStringExtra("msg4");
        String view_course = intent.getStringExtra("msg5");

        int age = (2023-Integer.valueOf(view_date));

        txtbanner = findViewById(R.id.txtheader);
        txtbanner.setText(view_last.toUpperCase() + " Info: ");

        txtinfo = findViewById(R.id.txtinfo);
        txtinfo.setText(" Last name: " + view_last + "\n First name: " + view_first + "\n Course: " +view_course+"\n Year Level: " + view_year + "\n Email: "+ view_email +"\n Phone Number:\n " + view_phone + "\n Birth Year: " + view_date + "\n Age: " + age);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}