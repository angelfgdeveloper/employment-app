package com.angelfgdeveloper.manresapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.helpers.Validators;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextView tvForgotPassword, tvTitleCreateAccount, tvCreateAccount;
    private TextInputEditText etEmail, etPassword;
    private Button btnLogin, btnGoogle, btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        methods();
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            String userToken = SharedPreferencesManager.getStringValue(AppConstants.USER_TOKEN);

            if (!userToken.isEmpty()) {
                goToHome(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findViews() {
        tvForgotPassword = findViewById(R.id.textViewForgotPassword);
        tvTitleCreateAccount = findViewById(R.id.textViewTitleCreateAccount);
        tvCreateAccount = findViewById(R.id.textViewCreateAccount);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnGoogle = findViewById(R.id.buttonGoogle);
        btnTest = findViewById(R.id.buttonTest);
    }

    private void methods() {

        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> validUser());

        etPassword.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                validUser();
                handled = true;
            }
            return handled;
        });

        btnGoogle.setOnClickListener(v -> {
            boolean isRegisterUser = true;
            Intent intent = new Intent(LoginActivity.this, QuestionMainActivity.class);
            intent.putExtra(Constants.IS_REGISTER_USER, isRegisterUser);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        btnTest.setOnClickListener(v -> goToHome(false));

        tvTitleCreateAccount.setOnClickListener(v -> goToRegister());
        tvCreateAccount.setOnClickListener(v -> goToRegister());
    }

    private void validUser() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.trim().length() > 0 && password.trim().length() > 0) {
            if (Validators.isValidEmail(email) && Validators.isValidPassword(password)) {
                goToHome(true);
            } else {
                Toast.makeText(LoginActivity.this, "Requiere un correo y contraseña mayor a 5 caracteres - validos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(LoginActivity.this, "Credenciales incorrectas, por favor vuela a intentarlo", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToHome(boolean isLoginUser) {
        Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
        intent.putExtra(Constants.IS_LOGIN_USER, isLoginUser);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        if (isLoginUser) {
            String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFuZ2VsIiwiaWF0IjoxNTE2MjM5MDIyfQ.5sqP7aP7XI_UOCQLvRQuWTDCusnyq-WVsBex8rrX_ic";
            SharedPreferencesManager.setStringValue(AppConstants.USER_TOKEN, userToken);
            finish();
        }
    }

    private void goToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}