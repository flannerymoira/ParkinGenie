package com.example.splashscreenjpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Find_Car_Park extends AppCompatActivity {

    public EditText name;
    public TextView result_address, result_tariff, result_opening;
    public String findByName, address, tariffInfo, openingTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_car_park);
        name = findViewById(R.id.editText_cpname);
        result_address = findViewById(R.id.result);
        result_tariff = findViewById(R.id.tariff);
        result_opening = findViewById(R.id.openingTimes);
    }

    public void viewCarPark(View view){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        name = findViewById(R.id.editText_cpname);
        findByName = name.getText().toString();
        address = databaseAccess.getAddress(findByName);
        result_address.setText(address);

        tariffInfo = databaseAccess.getTariff();
        result_tariff.setText(tariffInfo);

        openingTimes = databaseAccess.getOpeningTimes();
        result_opening.setText(openingTimes);

        databaseAccess.close();
    }
}
