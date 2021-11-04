package com.angelfgdeveloper.manresapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.exit.ExitFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity implements ExitFragment.OnExitFragmentListener {

    private ActivityNavigationBinding binding;
    private BottomNavigationView navView;

    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        Bundle args = getIntent().getExtras();
        if(args != null){
            isLogin = args.getBoolean(Constants.IS_LOGIN_USER);
        }

        Toast.makeText(this, "Acceso por Login: " + isLogin, Toast.LENGTH_SHORT).show();

        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);

        if (!isLogin) {
            navView.getMenu().removeItem(R.id.navigation_profile);
            navView.getMenu().removeItem(R.id.navigation_notifications);
        } else {
            navView.getMenu().removeItem(R.id.navigation_exit);
        }

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_navigation);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public void onClosedPreview(boolean isClosed) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, SplashActivity.class);
        intent.putExtra(Constants.IS_CLOSED_PREVIEW_TIME, isClosed);
        startActivity(intent, options.toBundle());
        finishAffinity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isLogin) {
            finishAffinity(); // Cierra todas las Activities - atras
        }
    }
}