package com.example.mobilebanking.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobilebanking.EditActivity;
import com.example.mobilebanking.R;


public class ProfileFragment extends Fragment {

    Button edit_button;
    TextView nameText, birthdayText, profile_number;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        edit_button = view.findViewById(R.id.edit_button);
        nameText = view.findViewById(R.id.nameText);
        birthdayText = view.findViewById(R.id.birthdayText);
        profile_number = view.findViewById(R.id.profile_number);


        SQLiteDatabase db = getContext().openOrCreateDatabase("SignLog.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        nameText.setText("");
        birthdayText.setText("");
        profile_number.setText("");

        while(query.moveToNext()){
            String phone = query.getString(0);
            String name = query.getString(1);
            String birthday = query.getString(2);

            nameText.append(name);
            birthdayText.append(birthday);
            profile_number.append(phone);
        }
        query.close();
        db.close();


        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), EditActivity.class);
                intent.putExtra("id",profile_number.getText().toString());
                startActivity(intent);
            }
        });

        return view;
    }

}