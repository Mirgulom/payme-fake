package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.mobilebanking.Fragments.PaymentFragment;
import com.example.mobilebanking.Fragments.ProfileFragment;
import com.example.mobilebanking.Fragments.ServiceFragment;
import com.example.mobilebanking.databinding.ActivityMainBinding;
import com.example.mobilebanking.databinding.ActivityMainInterface2Binding;

public class MainInterface2 extends AppCompatActivity {

    ActivityMainInterface2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainInterface2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new PaymentFragment());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.payment:
                    replaceFragment(new PaymentFragment());
                    break;
                case R.id.service:
                    replaceFragment(new ServiceFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }
            return true;
        });



    }
    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}