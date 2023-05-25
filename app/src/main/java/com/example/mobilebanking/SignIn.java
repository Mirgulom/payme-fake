package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.databinding.ActivitySignInBinding;
import com.example.mobilebanking.db.DatabaseHelper;

public class SignIn extends AppCompatActivity {

    EditText phoneNumber, password;
    Button signIn;
    TextView signUp;
    ActivitySignInBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.phoneNumber.getText().toString();
                String password = binding.password.getText().toString();
                if(email.equals("")||password.equals(""))
                    Toast.makeText(SignIn.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkNumberPassword(email, password);
                    if(checkCredentials == true){
                        Toast.makeText(SignIn.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainInterface2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
    public void toMainInterface(View view) {
        Intent intent = new Intent(this, MainInterface.class);
        startActivity(intent);
    }
    public void SignUp(View view) {

    }
}