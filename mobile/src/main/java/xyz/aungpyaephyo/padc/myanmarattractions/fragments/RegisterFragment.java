package xyz.aungpyaephyo.padc.myanmarattractions.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        //For Spinner
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerCountry);
        // Initializing a String Array
        String[] country_array = new String[]{
                "Myanmar",
                "American",
                "Japan",
                "China",
                "Spain"};

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                MyanmarAttractionsApp.getContext(),R.layout.spinner_item,country_array);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);


        final EditText etUsername = (EditText) view.findViewById(R.id.et_username_reg);
        final EditText etPassword = (EditText) view.findViewById(R.id.et_password_reg);
        final EditText etEmail = (EditText) view.findViewById(R.id.et_email_reg);
        final Spinner spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountry);

        Button btnRegister = (Button) view.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                String country = spinnerCountry.getSelectedItem().toString();

                /**
                Intent intentRegisterSummery = RegisterSummeryActivity.newIntent(username, password, email,
                        phone, country, gender);
                startActivity(intentRegisterSummery);
                /**/
            }
        });
        return view;
    }
}
