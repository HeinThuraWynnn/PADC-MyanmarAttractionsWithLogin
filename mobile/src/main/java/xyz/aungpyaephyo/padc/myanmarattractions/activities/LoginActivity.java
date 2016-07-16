package xyz.aungpyaephyo.padc.myanmarattractions.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.R;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.LoginFragment;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.RegisterFragment;

public class LoginActivity extends AppCompatActivity {

    /**
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /**/

    public static Intent newIntent() {
        Intent intent = new Intent(MyanmarAttractionsApp.getContext(), LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this, this);

        /**
        toolbar.setTitle(R.string.home_screen_title);
        setSupportActionBar(toolbar);
        /**/

        if(findViewById(R.id.fl_container_2) != null) {
            RegisterFragment fragment = new RegisterFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container_2, fragment)
                    .commit();
        }
        LoginFragment loginfragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, loginfragment)
                .commit();

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginFragment fragment = LoginFragment.newInstance("dummy default");

                /**
                 Bundle bundle = new Bundle();
                 bundle.putString(LoginFragment.BARG_DUMMY_USERNAME,"dummy");
                 fragment.setArguments(bundle);
                 /**/
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit();
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment fragment = new RegisterFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit();
            }
        });
    }
}
