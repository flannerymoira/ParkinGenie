package com.example.splashscreenjpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import static com.example.splashscreenjpg.MainActivity.myDb;

public class Enter_CarPark extends AppCompatActivity {
    EditText editName;
    EditText editWebsite;
    EditText editAddress;
    EditText editPhone;
    EditText editGPS;
    EditText editTotal;
    EditText editFree;
    EditText editHeight;
    EditText editPayment;

    String temp;
    int total_val, free_val;

    //ArrayList carParks = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_car_park);
    }

    public void createCarPark(View view) {
        editName = (EditText) findViewById(R.id.editText_name);
        editWebsite = (EditText) findViewById(R.id.editText_website);
        editAddress = (EditText) findViewById(R.id.editText_address);
        editPhone = (EditText) findViewById(R.id.editText_phone);
        editGPS = (EditText) findViewById(R.id.editText_gps);
        editTotal = (EditText) findViewById(R.id.editText_totspaces);
        editFree =  (EditText) findViewById(R.id.editText_freespaces);
        editHeight = (EditText) findViewById(R.id.editText_height);
        editPayment = (EditText) findViewById(R.id.editText_payment);

        temp = editTotal.getText().toString();
        total_val = Integer.parseInt(temp);
        temp = editFree.getText().toString();
        free_val = Integer.parseInt(temp);


        boolean isInserted = myDb.insertData(editName.getText().toString(),
                editWebsite.getText().toString(), editAddress.getText().toString(),
                editPhone.getText().toString(), editGPS.getText().toString(),
                total_val, free_val,
                editHeight.getText().toString(), editPayment.getText().toString());

        if (isInserted = true)
        Toast.makeText(this,"Data Inserted",Toast.LENGTH_LONG).show();
            //setContentView(R.layout.enter_car_park);
        else
            Toast.makeText(this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

    public void viewOwnerCarPark(View view){
        startActivity(new Intent(getApplicationContext(), Find_Car_Park.class));
    }

    public void addTariff(View view) {
        startActivity(new Intent(getApplicationContext(), Enter_Tariff.class));
    }
}

