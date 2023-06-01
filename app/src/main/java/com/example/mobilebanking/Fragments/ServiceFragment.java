package com.example.mobilebanking.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.PaymentParagraph.Eshopping;
import com.example.mobilebanking.PaymentParagraph.Ethernet;
import com.example.mobilebanking.PaymentParagraph.Ewallet;
import com.example.mobilebanking.PaymentParagraph.GamesSC;
import com.example.mobilebanking.PaymentParagraph.MobilniyOperator;
import com.example.mobilebanking.PaymentParagraph.OnlineService;
import com.example.mobilebanking.R;


public class ServiceFragment extends Fragment {

    CardView mobOperator, ethernet, onlineService, eWallet, eShopping, games;
    public ServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        mobOperator = view.findViewById(R.id.mobOperator);
        ethernet = view.findViewById(R.id.ethernet);
        onlineService = view.findViewById(R.id.onlineService);
        eWallet = view.findViewById(R.id.eWallet);
        eShopping = view.findViewById(R.id.eShopping);
        games = view.findViewById(R.id.games);

        mobOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MobilniyOperator.class);
                startActivity(intent);
            }
        });
        ethernet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Ethernet.class);
                startActivity(intent);
            }
        });
        onlineService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), OnlineService.class);
                startActivity(intent);
            }
        });
        eWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Ewallet.class);
                startActivity(intent);
            }
        });
        eShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Eshopping.class);
                startActivity(intent);
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), GamesSC.class);
                startActivity(intent);
            }
        });

        return view;
    }
}