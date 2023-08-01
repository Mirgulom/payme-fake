package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobilebanking.Fragments.ProfileFragment;

public class EditActivity extends AppCompatActivity {

    EditText editName, editBirthday;
    Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName = findViewById(R.id.editName);
        editBirthday = findViewById(R.id.editBirthday);
        save_button = findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("SignLog.db", MODE_PRIVATE, null);
                String name = editName.getText().toString();
                String birthday = editBirthday.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("profileName", name);
                contentValues.put("profileBirthday", birthday);
                Intent intent = getIntent();
                String id = intent.getStringExtra("id");

                db.update("users", contentValues,"phoneNumber = ?", new String[]{id});

                db.close();
                EditActivity.super.onBackPressed();

            }
        });
    }
}