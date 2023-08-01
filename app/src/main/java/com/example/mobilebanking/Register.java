package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.databinding.ActivityRegisterBinding;
import com.example.mobilebanking.db.DatabaseHelper;

public class Register extends AppCompatActivity {

    EditText phoneNumber, password, fullName;
    Button signUp;
    TextView signIn;
    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.phoneNumber.getText().toString();
                String profileName = binding.profileName.getText().toString();
                String profileBirthday = binding.profileBirthday.getText().toString();
                String password = binding.password.getText().toString();
                String confirmPassword = binding.confirmPassword.getText().toString();

                if(profileName.equals("") || profileBirthday.equals("") || number.equals("")||password.equals("")||confirmPassword.equals(""))
                    Toast.makeText(Register.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confirmPassword)){
                        Boolean checkUserNumber = databaseHelper.checkNumber(number);

                        if(checkUserNumber == false){
                            Boolean insert = databaseHelper.insertData(number,profileName, profileBirthday, password);

                            if(insert == true){
                                Toast.makeText(Register.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Register.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, SignIn.class);
                startActivity(intent);
            }
        });

    }
    public void LogIn(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    }
