package com.angelfgdeveloper.manresapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.ActivitySelectRegisterBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;

public class SelectRegisterActivity extends AppCompatActivity {

    private ActivitySelectRegisterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySelectRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        getShowDialog();

    }

    private void getShowDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_person_or_company);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        LinearLayout llPerson = dialog.findViewById(R.id.llRegisterPerson);
        LinearLayout llCompany = dialog.findViewById(R.id.llRegisterCompany);
        Button btnReturnLogin = dialog.findViewById(R.id.btnReturnLogin);

        llPerson.setOnClickListener(view -> {
            registerPersonOrCompany("Person");
            dialog.dismiss();
        });

        llCompany.setOnClickListener(view -> {
            registerPersonOrCompany("Company");
            dialog.dismiss();
        });

        btnReturnLogin.setOnClickListener(view -> finish());

        dialog.show();
    }

    private void registerPersonOrCompany(String typeUser) {
        Intent intent = new Intent(this, QuestionMainActivity.class);
        intent.putExtra(Constants.IS_USER_EDIT, typeUser);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}