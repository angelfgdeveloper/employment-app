package com.angelfgdeveloper.manresapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.helpers.Validators;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputEditText etName, etEmail, etPassword, etConfPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        etName = findViewById(R.id.editTextName);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        etConfPassword = findViewById(R.id.editTextConfPassword);
        btnRegister = findViewById(R.id.buttonRegister);

    }

    private void methods() {
        btnRegister.setOnClickListener(v -> validUser());

        etConfPassword.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                validUser();
                handled = true;
            }
            return handled;
        });
    }

    private void validUser() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confPassword = etConfPassword.getText().toString();

        if (name.trim().length() > 0 && email.trim().length() > 0) {
            if (Validators.isValidEmail(email)) {
                if (Validators.isValidPassword(password)) {
                    if (password.equals(confPassword)) {
                        goToHome();
                    } else {
                        Toast.makeText(this, "Por favor verifique las contraseñas, son distintas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Requiere una contraseña mayor a 5 caracteres", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Correo invalido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Se necesitan rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToHome() {
        String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFuZ2VsIiwiaWF0IjoxNTE2MjM5MDIyfQ.5sqP7aP7XI_UOCQLvRQuWTDCusnyq-WVsBex8rrX_ic";
        SharedPreferencesManager.setStringValue(AppConstants.USER_TOKEN, userToken);

        Intent intent = new Intent(RegisterActivity.this, NavigationActivity.class);
        intent.putExtra(AppConstants.IS_LOGIN_USER, true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
//        finish();
        finishAffinity();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}