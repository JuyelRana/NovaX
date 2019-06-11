package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_continue;

    private EditText etUsername, etPassword;

    private String username, password;

    private TextView txtNotThisUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initialize();

    }

    private void initialize() {
        btn_continue = findViewById(R.id.btn_continue_welcomePage);
        etUsername = findViewById(R.id.editText_userName_WelcomePage);
        etPassword = findViewById(R.id.editText_userPassword_WelcomePage);

        txtNotThisUser = findViewById(R.id.forgotPassText_welcomePage);

        txtNotThisUser.setOnClickListener(this);
        btn_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_continue_welcomePage:

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if ((username != null) && (!username.isEmpty())) {
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                } else {
                    etUsername.setError("At least 6 to 16 characters");
                }

                if ((password != null) && (!password.isEmpty())) {
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                } else {
                    etUsername.setError("At least 6 to 16 characters");
                }

                break;

            case R.id.forgotPassText_welcomePage:
                startActivity(new Intent(getApplicationContext(), SellGTDOrder.class));
                break;
        }
    }
}
