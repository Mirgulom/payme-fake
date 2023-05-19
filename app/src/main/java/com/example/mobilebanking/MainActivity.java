package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void SignUp(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }
    public void SignIn(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);

    }
}