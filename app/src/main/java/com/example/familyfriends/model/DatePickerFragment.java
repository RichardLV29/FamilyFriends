package com.example.familyfriends.model;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    private DatePickerDialog.OnDateSetListener list;

      public DatePickerFragment (DatePickerDialog.OnDateSetListener list){
            this.list = list;
        }

        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar dates = Calendar.getInstance();

            int day = dates.get(Calendar.DAY_OF_MONTH);
            int month = dates.get(Calendar.MONTH);
            int year = dates.get(Calendar.YEAR);

            //DatePickerDialog obtendremos el widget de calendario.
            /*Cada ves que seleccionemos una fecha se llamara al metodo onDateSet de
              la interface onDateSetListener de su clase  DatePickerDialog
             */

            return new DatePickerDialog(getActivity(),list,year,month,day);

        }
}
