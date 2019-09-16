package com.example.familyfriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.familyfriends.model.DatePickerFragment;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
        private TextInputEditText nombre,fecha,tel,emails,descr;
        private Button maSend;
        final int pickCode =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editUser);
        fecha  = findViewById(R.id.editDate);
        tel    = findViewById(R.id.editPhone);
        emails = findViewById(R.id.editEmail);
        descr   = findViewById(R.id.editDescripcion);
        maSend = findViewById(R.id.maSend);

        //----Integrando un Listener-------------------------------------------------
        fecha  = findViewById(R.id.editDate);
        fecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                callDate();
            }});

        maSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //onSendData();
                pickContac();
            }
        });
    }

    public void callDate(){
            DialogFragment getDate = new DatePickerFragment(new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view,int year,int month,int day){
                    fecha.setText(day+"/"+(month+1)+"/"+year);
                }
            });

            getDate.show(getSupportFragmentManager(),"datePicker");
    }





    private void pickContac(){
        String name        = nombre.getText().toString();
        String date        = fecha.getText().toString();
        String phone       = tel.getText().toString();
        String email       = emails.getText().toString();
        String description = descr.getText().toString();
        Intent i= new Intent(MainActivity.this,ConfirmacionDatos.class);

        i.putExtra(getResources().getString(R.string.user),name);
        i.putExtra(getResources().getString(R.string.date),date);
        i.putExtra(getResources().getString(R.string.phone),phone);
        i.putExtra(getResources().getString(R.string.email),email);
        i.putExtra(getResources().getString(R.string.descripcion),description);
        startActivityForResult(i,1);

    }
@Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == pickCode & resultCode == RESULT_OK) {
        String rname = data.getStringExtra(getResources().getString(R.string.user));
        String rdate = data.getStringExtra(getResources().getString(R.string.date));
        String rphone  = data.getStringExtra(getResources().getString(R.string.phone));
        String remail = data.getStringExtra(getResources().getString(R.string.email));
        String rdesc = data.getStringExtra(getResources().getString(R.string.descripcion));
        nombre.setText(rname);
        fecha.setText(rdate);
        tel.setText(rphone);
        emails.setText(remail);
        descr.setText(rdesc);
    }

}

}
