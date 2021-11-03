package com.angelfgdeveloper.manresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextView tvForgotPassword, tvTitleCreateAccount, tvCreateAccount;
    private TextInputEditText etEmail, etPassword;
    private Button btnLogin, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        methods();
    }

    private void findViews() {
        tvForgotPassword = findViewById(R.id.textViewForgotPassword);
        tvTitleCreateAccount = findViewById(R.id.textViewTitleCreateAccount);
        tvCreateAccount = findViewById(R.id.textViewCreateAccount);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnGoogle = findViewById(R.id.buttonGoogle);
    }

    private void methods() {
        tvForgotPassword.setOnClickListener(v -> Toast.makeText(LoginActivity.this, "Olvide mi contraseña!!!", Toast.LENGTH_SHORT).show());
        tvTitleCreateAccount.setOnClickListener(v -> Toast.makeText(LoginActivity.this, "Titulo - Crear cuenta", Toast.LENGTH_SHORT).show());
        tvCreateAccount.setOnClickListener(v -> Toast.makeText(LoginActivity.this, "Titulo - Crear cuenta", Toast.LENGTH_SHORT).show());

        btnLogin.setOnClickListener(v -> validUser());

        etPassword.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                validUser();
                handled = true;
            }
            return handled;
        });

        btnGoogle.setOnClickListener(v -> Toast.makeText(LoginActivity.this, "Inicio de sesión con Google", Toast.LENGTH_SHORT).show());
    }

    private void validUser() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.trim().length() > 0 && password.trim().length() > 0) {
            if (isValidEmail(email) && isValidPassword(password)) {
                Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Requiere un correo y contraseña mayor a 5 caracteres - validos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(LoginActivity.this, "Credenciales incorrectas, por favor vuela a intentarlo", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 5;
    }
}