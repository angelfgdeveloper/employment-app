package com.angelfgdeveloper.manresapp;

import android.os.Bundle;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding binding;

    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getIntent().getExtras();
        if(args != null){
            isLogin = args.getBoolean(Constants.IS_LOGIN_USER);
        }

        Toast.makeText(this, "Acceso por Login: " + isLogin, Toast.LENGTH_SHORT).show();

        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isLogin) {
            finishAffinity(); // Cierra todas las Activities atras
        }
    }
}