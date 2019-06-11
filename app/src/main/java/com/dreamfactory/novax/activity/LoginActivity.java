package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_signin;
    private EditText et_login_username, et_login_password;
    private TextView txtSignUp;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initialize();


    }

    private void initialize() {
        btn_signin = findViewById(R.id.btn_signin);
        et_login_username = findViewById(R.id.et_login_username);
        et_login_password = findViewById(R.id.et_login_password);
        txtSignUp = findViewById(R.id.txtSignUp);

        btn_signin.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signin:
                username = et_login_username.getText().toString();
                password = et_login_password.getText().toString();

                if ((username != null) && (!username.isEmpty()) && username.length() > 6) {

                    Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("tabSlector",0);
                    startActivity(intent);

                  //  startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                } else {
                    et_login_username.setError("At least 6 to 16 characters");
                }

                if (( password != null) && (!password.isEmpty())) {
                    Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("tabSlector",0);
                    startActivity(intent);

                  //  startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                } else {
                    et_login_password.setError("At least 8 characters");
                }

                break;

        }
    }
}
