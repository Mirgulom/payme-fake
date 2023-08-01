package com.example.mobilebanking.PaymentParagraph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobilebanking.HumansActivity;
import com.example.mobilebanking.MobiUzActivity;
import com.example.mobilebanking.OperatorActivity;
import com.example.mobilebanking.PerfectumActivity;
import com.example.mobilebanking.R;
import com.example.mobilebanking.UcellActivity;
import com.example.mobilebanking.UzmobileActivity;

public class MobilniyOperator extends AppCompatActivity {

    CardView beeline, ucell, mobiuz, uzmobile, perfectum, humans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilniy_operator);

        beeline = findViewById(R.id.beeline);
        ucell = findViewById(R.id.ucell);
        mobiuz = findViewById(R.id.mobiuz);
        uzmobile = findViewById(R.id.uzmobile);
        perfectum = findViewById(R.id.perfectum);
        humans = findViewById(R.id.humans);

        beeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OperatorActivity.class);
                startActivity(intent);
            }
        });
        ucell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UcellActivity.class);
                startActivity(intent);
            }
        });
        mobiuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MobiUzActivity.class);
                startActivity(intent);
            }
        });
        uzmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UzmobileActivity.class);
                startActivity(intent);
            }
        });
        perfectum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerfectumActivity.class);
                startActivity(intent);
            }
        });
        humans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HumansActivity.class);
                startActivity(intent);
            }
        });

    }
}