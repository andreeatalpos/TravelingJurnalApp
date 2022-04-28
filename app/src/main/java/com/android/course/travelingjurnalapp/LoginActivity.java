package com.android.course.travelingjurnalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button loginButton;
    private TextView singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        singUp = findViewById(R.id.signUp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText, passwordText;
                emailText = email.getText().toString();
                passwordText = password.getText().toString();

                if(emailText.equals("")) {
                    Toast.makeText(LoginActivity.this,"Email is blank!",Toast.LENGTH_SHORT).show();
                }
                else if(passwordText.equals("")) {
                    Toast.makeText(LoginActivity.this, "Password is blank!", Toast.LENGTH_SHORT).show();
                } else {
                    //Authentication
                }
            }
        });

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}