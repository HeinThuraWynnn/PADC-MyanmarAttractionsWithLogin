package xyz.aungpyaephyo.padc.myanmarattractions.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Phyoe Khant on 6/25/2016.
 */
public class MyDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener  {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String str = "Year : " + year + " Month : " + monthOfYear + " Day : " + dayOfMonth;
        Toast.makeText(view.getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
