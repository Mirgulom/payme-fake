package com.example.mobilebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainInterface extends AppCompatActivity {

    private List<Service> services = new ArrayList();
    ListView servicesList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        servicesList = (ListView) findViewById(R.id.servicesList);
        // создаем адаптер
        ServiceAdapter stateAdapter = new ServiceAdapter(this, R.layout.list_service_item, services);
        // устанавливаем адаптер
        servicesList.setAdapter(stateAdapter);
        // слушатель выбора в списке

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Service selectedState = (Service) servicesList.getItemAtPosition(position);

                switch (position){
                    case 0:
                        servicesList.getItemAtPosition(position);
                        Intent intent  = new Intent(getApplicationContext(), DoctorActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent  = new Intent(getApplicationContext(), MonitoringActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent  = new Intent(getApplicationContext(), PayingActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent  = new Intent(getApplicationContext(), DebtActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent  = new Intent(getApplicationContext(), TaxActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent  = new Intent(getApplicationContext(), InsuranceActivity.class);
                        startActivity(intent);
                        break;
                }
//                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
//                        Toast.LENGTH_SHORT).show();
            }
        };    servicesList.setOnItemClickListener(itemListener);   }

    private void setInitialData() {

        services.add(new Service("Записаться на прием к врачу", R.drawable.medicina));
        services.add(new Service("Мониторинг платежей", R.drawable.monitoring_search));
        services.add(new Service("Оплата на расчестный счет", R.drawable.paying));
        services.add(new Service("Проверка задолжненности МИБ", R.drawable.proverka));
        services.add(new Service("Уведомление о штрафах ГУБДД", R.drawable.radar));
        services.add(new Service("Автостраховние", R.drawable.straxovka));


    }
}