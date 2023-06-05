package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class grade_encode extends AppCompatActivity {
    EditText first_grade, last_grade, attend, quiz1, quiz2, quiz3, quiz4, exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Encoding Grades");
        setContentView(R.layout.activity_grade_encode);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        first_grade = findViewById(R.id.grade_firstname);
        last_grade = findViewById(R.id.grade_lastname);
        attend = findViewById(R.id.input_attendance);
        quiz1 = findViewById(R.id.quiz1);
        quiz2 = findViewById(R.id.quiz2);
        quiz3 = findViewById(R.id.quiz3);
        quiz4 = findViewById(R.id.quiz4);
        exam = findViewById(R.id.exam);

        Button encode_grade = findViewById(R.id.encode_grade);
        encode_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    String first = first_grade.getText().toString();
                    String last = last_grade.getText().toString();
                    int attendance = Integer.parseInt(attend.getText().toString());
                    int q1 = Integer.parseInt(quiz1.getText().toString());
                    int q2 = Integer.parseInt(quiz2.getText().toString());
                    int q3 = Integer.parseInt(quiz3.getText().toString());
                    int q4 = Integer.parseInt(quiz4.getText().toString());
                    int score = Integer.parseInt(exam.getText().toString());

                    if (attendance < 1 || attendance > 100 || q1 < 1 || q1 > 100 || q2 < 1 || q2 > 100
                            || q3 < 1 || q3 > 100 || q4 < 1 || q4 > 100 || score < 1 || score > 100) {
                        Toast.makeText(grade_encode.this, "Error: Please enter values between 1 and 100.", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(grade_encode.this, grade_view.class);
                        intent.putExtra("first", first);
                        intent.putExtra("last", last);
                        intent.putExtra("attendance", attendance);
                        intent.putExtra("q1", q1);
                        intent.putExtra("q2", q2);
                        intent.putExtra("q3", q3);
                        intent.putExtra("q4", q4);
                        intent.putExtra("score", score);

                        startActivity(intent);
                    }
                }catch (Exception e){
                    Toast.makeText(grade_encode.this, "error" + e, Toast.LENGTH_SHORT).show();
                }
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