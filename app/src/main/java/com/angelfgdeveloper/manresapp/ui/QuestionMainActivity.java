package com.angelfgdeveloper.manresapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;
import com.angelfgdeveloper.manresapp.databinding.QuestionMainActivityBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.question.ExtrasFragment;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;

public class QuestionMainActivity extends AppCompatActivity implements ExtrasFragment.OnExtraFragmentListener {

    private QuestionMainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = QuestionMainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    public void setQuestionInfo(String infoUser) {
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra(Constants.IS_LOGIN_USER, true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFuZ2VsIiwiaWF0IjoxNTE2MjM5MDIyfQ.5sqP7aP7XI_UOCQLvRQuWTDCusnyq-WVsBex8rrX_ic";
        SharedPreferencesManager.setStringValue(AppConstants.USER_TOKEN, userToken);
        finishAffinity();
    }
}