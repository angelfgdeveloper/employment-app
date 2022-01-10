package com.angelfgdeveloper.manresapp.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.ActivityNavigationBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.details.WorkDetailsFragment;
import com.angelfgdeveloper.manresapp.ui.exit.ExitFragment;
import com.angelfgdeveloper.manresapp.ui.profile.EditProfileFragment;
import com.angelfgdeveloper.manresapp.ui.profile.ProfileViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class NavigationActivity extends AppCompatActivity implements
        ExitFragment.OnExitFragmentListener,
        WorkDetailsFragment.OnWorkDetailsFragmentListener,
        EditProfileFragment.OnEditProfileFragmentListener,
        PermissionListener {

    private ActivityNavigationBinding binding;
    private BottomNavigationView navView;
    private ProfileViewModel mProfileViewModel;

    private boolean isLogin = false;
    private String mPhotoPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProfileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        init();
    }

    private void init() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
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

        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.IS_LOGIN_USER, isLogin);
        navController.navigate(R.id.navigation_home, bundle);
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

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Log.d("IMAGEN", data.toString());
                    if (data != null) {
                        Uri selectedPhoto = data.getData(); // content://gallery/photo/..
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(selectedPhoto,
                                filePathColumn, null, null, null);

                        if (cursor != null) {
                            cursor.moveToFirst();
                            int imgIndex = cursor.getColumnIndex(filePathColumn[0]);
                            String photoPath = cursor.getString(imgIndex);

                            // Subir la foto al Viewmodel.upload(photoPath);
                            Log.d("IMAGEN", photoPath);
//                            mProfileViewModel.setPhoto(photoPath);
                            mPhotoPath = photoPath;

                            cursor.close();
                        }
                    }
                }
            });

    public String setPhoto() {
        return mPhotoPath;
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
        // Invocamos la seleccion de fotos de la galeria
        Intent selectedPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        someActivityResultLauncher.launch(selectedPhoto);
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
        Toast.makeText(this, "No se pudo seleccionar la fotografía", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

    }
}