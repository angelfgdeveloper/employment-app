package com.angelfgdeveloper.manresapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.helpers.Validators;
import com.google.android.material.textfield.TextInputEditText;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputEditText etRecoverPassword;
    private Button btnRecoverPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        findViews();
        methods();
    }

    private void findViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etRecoverPassword = findViewById(R.id.editTextRecoverPassword);
        btnRecoverPassword = findViewById(R.id.buttonRecoverPassword);
    }

    private void methods() {
        btnRecoverPassword.setOnClickListener(v -> sendEmail());
        etRecoverPassword.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sendEmail();
                handled = true;
            }
            return handled;
        });
    }

    private void sendEmail() {
        String email = etRecoverPassword.getText().toString();

        if (Validators.isValidEmail(email)) {
            btnRecoverPassword.setEnabled(false);
            etRecoverPassword.setEnabled(false);
            Toast.makeText(this, "En unos momentos recibira un correo con instrucciones, revise su bandeja de entrada", Toast.LENGTH_LONG).show();

            new Handler().postDelayed(() -> {
                btnRecoverPassword.setEnabled(true);
                etRecoverPassword.setEnabled(true);
                etRecoverPassword.setText("");
            }, 3500);
        } else {
            Toast.makeText(this, "Correo electrónico invalido ó vacio", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}