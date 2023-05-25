package com.example.mobilebanking.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mobilebanking.DebtActivity;
import com.example.mobilebanking.DoctorActivity;
import com.example.mobilebanking.InsuranceActivity;
import com.example.mobilebanking.MainInterface2;
import com.example.mobilebanking.MonitoringActivity;
import com.example.mobilebanking.PayingActivity;
import com.example.mobilebanking.R;
import com.example.mobilebanking.Service;
import com.example.mobilebanking.ServiceAdapter;
import com.example.mobilebanking.TaxActivity;

import java.util.ArrayList;
import java.util.List;


public class PaymentFragment extends Fragment {

    private List<Service> serviceList;
    private RecyclerView serviceFragmentList ;
    private ServiceAdapter serviceAdapter;

    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        serviceList = generateListItems();

        ServiceAdapter.OnChoosedItemClickListener onClickListener = new ServiceAdapter.OnChoosedItemClickListener() {
            @Override
            public void onServiceClick(Service service, int position) {
                switch (position){
                    case 0:
                        Intent intent  = new Intent(getActivity().getApplicationContext(), DoctorActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent  = new Intent(getActivity().getApplicationContext(), MonitoringActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent  = new Intent(getActivity().getApplicationContext(), PayingActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent  = new Intent(getActivity().getApplicationContext(), DebtActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent  = new Intent(getActivity().getApplicationContext(), TaxActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent  = new Intent(getActivity().getApplicationContext(), InsuranceActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        serviceFragmentList = rootView.findViewById(R.id.servicesList);
        serviceFragmentList.setLayoutManager(new LinearLayoutManager(getActivity()));
        serviceAdapter = new ServiceAdapter(serviceList, onClickListener);
        serviceFragmentList.setAdapter(serviceAdapter);

        return rootView;


    }

    private List<Service> generateListItems(){
        List<Service> serviceItem = new ArrayList<>();
        serviceItem.add(new Service("Записаться на прием к врачу", R.drawable.medicina));
        serviceItem.add(new Service("Мониторинг платежей", R.drawable.monitoring_search));
        serviceItem.add(new Service("Оплата на расчестный счет", R.drawable.paying));
        serviceItem.add(new Service("Проверка задолжненности МИБ", R.drawable.proverka));
        serviceItem.add(new Service("Уведомление о штрафах ГУБДД", R.drawable.radar));
        serviceItem.add(new Service("Автостраховние", R.drawable.straxovka));

        return serviceItem;
    }
}