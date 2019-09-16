package com.example.familyfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {
        private TextView tvName,tvDate,tvPhone,tvEmail,tvDesc;
        private Button cdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion_datos);

        Bundle bundle = getIntent().getExtras();

        String name  = bundle.getString(getResources().getString(R.string.user));
        String date  = bundle.getString(getResources().getString(R.string.date));
        String phone = bundle.getString(getResources().getString(R.string.phone));
        String email = bundle.getString(getResources().getString(R.string.email));
        String desc  = bundle.getString(getResources().getString(R.string.descripcion));

        tvName   = findViewById(R.id.tvCdName);
        tvDate   = findViewById(R.id.tvCdDate);
        tvPhone  = findViewById(R.id.tvCdPhone);
        tvEmail  =  findViewById(R.id.tvCdEmail);
        tvDesc   = findViewById(R.id.tvCdDescription);
        cdButton = findViewById(R.id.cdSend);

        tvName.setText(name);
        tvDate.setText(date);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        cdButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                returnActivity();
            }
        });
    }

    public void returnActivity(){
        String name        = tvName.getText().toString();
        String date        = tvDate.getText().toString();
        String phone       = tvPhone.getText().toString();
        String email       = tvEmail.getText().toString();
        String description = tvDesc.getText().toString();
       Intent cdIntent = new Intent(ConfirmacionDatos.this,MainActivity.class);
        cdIntent.putExtra(getResources().getString(R.string.user),name);
        cdIntent.putExtra(getResources().getString(R.string.date),date);
        cdIntent.putExtra(getResources().getString(R.string.phone),phone);
        cdIntent.putExtra(getResources().getString(R.string.email),email);
        cdIntent.putExtra(getResources().getString(R.string.descripcion),description);
        setResult(1,cdIntent);
        finish();
    }
}
