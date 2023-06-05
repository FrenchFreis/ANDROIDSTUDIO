package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class grade_view extends AppCompatActivity {
TextView grade_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_view);
        setTitle("Grades");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
try {
    Intent i = getIntent();

    String first = i.getStringExtra("first");
    String last = i.getStringExtra("last");
    int attendance = i.getIntExtra("attendance", 0);
    int q1 = i.getIntExtra("q1", 0);
    int q2 = i.getIntExtra("q2", 0);
    int q3 = i.getIntExtra("q3", 0);
    int q4 = i.getIntExtra("q4", 0);
    int score = i.getIntExtra("score",0 );

    int summary = ((q1 + q2 + q3 + q4) / 4);

    double ave = (attendance * .2) + (summary * .3) + (score * .5);

    int average = (int) Math.round(ave);

    String grade;

    if (average >= 96 && average <= 100) {
        grade = "4.00";
    } else if (average >= 90 && average <= 95) {
        grade = "3.50";
    } else if (average >= 84 && average <= 89) {
        grade = "3.00";
    } else if (average >= 78 && average <= 83) {
        grade = "2.50";
    } else if (average >= 72 && average <= 77) {
        grade = "2.00";
    } else if (average >= 66 && average <= 71) {
        grade = "1.50";
    } else if (average >= 60 && average <= 65) {
        grade = "1.00";
    } else {
        grade = "INC";
    }

    String status;

    if (grade.equals("INC")){
        status = "Unfortunately, You have failed.";
    } else{
        status = "Congratulations! You passed!";
    }
    grade_screen = findViewById(R.id.grade_screen);
    grade_screen.setText(first + " " + last + "\nAttendance: " + attendance + " Days\n\nQuiz 1: " + q1 + "\nQuiz 2: " + q2 + "\nQuiz 3: " + q3 + "\nQuiz 4: " + q4 + "\n\nExam Score: " + score + "\n\nGrade: " + average + " = " + grade + "\n\n" + status);
}catch (Exception e){
    Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
}
}
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}