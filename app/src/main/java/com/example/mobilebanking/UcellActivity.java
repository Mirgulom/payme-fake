package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilebanking.databinding.ActivityPerfectumBinding;
import com.example.mobilebanking.databinding.ActivityUcellBinding;
import com.example.mobilebanking.databinding.ActivityUzmobileBinding;

public class UcellActivity extends AppCompatActivity {
    EditText number, count_paying;
    Button pay_button;
    ActivityUcellBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucell);

        binding = ActivityUcellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        number = findViewById(R.id.number);
        count_paying = findViewById(R.id.count_paying);
        pay_button = findViewById(R.id.pay_button);

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.number.getText().toString();
                String count_paying = binding.countPaying.getText().toString();

                if (number.equals("")||count_paying.equals(""))
                    Toast.makeText(UcellActivity.this, "Поля должны быть заполнены", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UcellActivity.this, "Оплата проведена успешно", Toast.LENGTH_SHORT).show();
            }
        });
    }
}