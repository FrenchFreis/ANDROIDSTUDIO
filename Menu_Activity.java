package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");
        setContentView(R.layout.activity_menu);
    }

    public void gotoInfo(View v){
        Intent i = new Intent(this, inputinfo.class);
        startActivity(i);
    }

    public void gotoGrades(View v){
        Intent i = new Intent(this, grade_encode.class);
        startActivity(i);
    }

    public  void logout(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}