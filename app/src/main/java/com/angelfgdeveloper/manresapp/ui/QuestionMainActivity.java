package com.angelfgdeveloper.manresapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;
import com.angelfgdeveloper.manresapp.databinding.QuestionMainActivityBinding;

public class QuestionMainActivity extends AppCompatActivity {

    private QuestionMainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = QuestionMainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}