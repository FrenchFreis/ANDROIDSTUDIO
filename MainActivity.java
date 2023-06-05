package com.example.studentgradingsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Student Grading System");
        setContentView(R.layout.activity_main);
    }
    public void login(View v){
    EditText usernameinput = findViewById(R.id.usernameinput);
    EditText passwordinput = findViewById(R.id.passwordinput);

    String correctname = "Student";
    String corretpass = "password";

    String nametext = usernameinput.getText().toString();
    String passtext = passwordinput.getText().toString();
try {
        if(correctname.equals(nametext) && corretpass.equals(passtext)){
            Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Menu_Activity.class);
            startActivity(i);
        } else if (nametext.isEmpty() && passtext.isEmpty()) {
            Toast.makeText(this,"Empty Username \n Empty Password",Toast.LENGTH_SHORT).show();
        }   else if(nametext.isEmpty()){
            Toast.makeText(this,"Empty Username",Toast.LENGTH_SHORT).show();
        } else if (passtext.isEmpty()) {
            Toast.makeText(this,"Empty Password",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You may have entered the incorrect Username or Password or Both", Toast.LENGTH_SHORT).show();
        }
    } catch (Exception e){
        Toast.makeText(this, e + "something went wrong...", Toast.LENGTH_SHORT).show();

    }
}
}