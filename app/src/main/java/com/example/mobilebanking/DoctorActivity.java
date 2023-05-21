package com.example.mobilebanking;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorActivity extends AppCompatActivity {
    TextView specialist, analize, diagnostic;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    AlertDialog.Builder radiobuilder = new AlertDialog.Builder(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        specialist = findViewById(R.id.specialist);
        diagnostic = findViewById(R.id.diagnostic);
        analize = findViewById(R.id.analize);

        specialist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] mSpecialist={ "Аллерголог", "Ветеринар", "Врач УЗИ","Гематолог","Дерматолог","Детский невролог","Кардиолог","Невролог","Нейрохирург","Онколог","Ортопед" };
                radiobuilder.setTitle("Выберите специальность").setCancelable(false)
                        .setNeutralButton("Назад", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();      }
                        })


                        .setSingleChoiceItems(mSpecialist, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                Toast.makeText(getApplicationContext(), "Выбрано " +
                                        mSpecialist[item], Toast.LENGTH_SHORT).show();
                            }
                        });

                radiobuilder.show();
        }
        });

        diagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean[] mCheckedItems = { false, false, false, false, false, false, false };
                final String[] checkSpecialistName = {"Ангиография","Биопсия","МРТ(Магнитно-резонансная томография)","Рентген","УЗИ(ультразвуковое исследование)","ЭКГ(Электрокардиография)","ЭХОКГ(эхокардиография)"};

                builder.setTitle("Выберите специальность").setCancelable(false)
                        .setMultiChoiceItems(checkSpecialistName, mCheckedItems,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,int which, boolean isChecked) {
                                        mCheckedItems[which] = isChecked;
                                    } })

                        .setPositiveButton("Готово",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                StringBuilder state = new StringBuilder();
                                for (int i = 0; i < checkSpecialistName.length; i++) {
                                    state.append("" + checkSpecialistName[i]);
                                    if (mCheckedItems[i]) state.append(" выбран\n");
                                    else   state.append(" не выбран\n");
                                }
                                Toast.makeText(getApplicationContext(), state.toString(), Toast.LENGTH_LONG).show();
                            } }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
    }

}