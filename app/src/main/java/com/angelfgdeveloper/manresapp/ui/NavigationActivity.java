package com.angelfgdeveloper.manresapp.ui;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.details.WorkDetailsFragment;
import com.angelfgdeveloper.manresapp.ui.exit.ExitFragment;
import com.angelfgdeveloper.manresapp.ui.profile.EditProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class NavigationActivity extends AppCompatActivity implements
        ExitFragment.OnExitFragmentListener,
        WorkDetailsFragment.OnWorkDetailsFragmentListener,
        EditProfileFragment.OnEditProfileFragmentListener {

    private ActivityNavigationBinding binding;
    private BottomNavigationView navView;

    private boolean isLogin = false;
    private String isCompleteTestSuccess = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            isLogin = args.getBoolean(Constants.IS_LOGIN_USER);

            if (args.getString(Constants.IS_COMPLETE_TEST_SUCCESS) != null) {
                isCompleteTestSuccess = args.getString(Constants.IS_COMPLETE_TEST_SUCCESS);
            }
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

        if (isCompleteTestSuccess.equals("Success_Test")) {
            showCustomDialog();
        }

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_navigation);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.IS_LOGIN_USER, isLogin);
        navController.navigate(R.id.navigation_home, bundle);
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
        builder.setTitle("Información guardada");
        builder.setMessage("Los datos fueron guardados exitosamente!");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(NavigationActivity.this, isCompleteTestSuccess, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
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
    public void setVisibleBottomNavigation(boolean isVisible) {
        isLogin = false;
        if (!isVisible) {
            navView.setVisibility(View.GONE);
        } else {
            navView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setEditVisibleBottomNavigation(boolean isVisible) {
        isLogin = false;
        if (!isVisible) {
            navView.setVisibility(View.GONE);
        } else {
            navView.setVisibility(View.VISIBLE);
        }
    }
}