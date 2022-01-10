package com.angelfgdeveloper.manresapp.ui.profile;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentProfileBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.LoginActivity;
import com.angelfgdeveloper.manresapp.ui.NavigationActivity;
import com.angelfgdeveloper.manresapp.ui.QuestionMainActivity;
import com.angelfgdeveloper.manresapp.ui.SplashActivity;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.LoadConvertPhotoFileTask;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;
    private PermissionListener mAllPermissionListener;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonLogout.setOnClickListener(v -> logout());

        binding.imageViewProfile.setOnClickListener(view -> {
            checkPermissions();
        });

        binding.imageButtonEdit.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_navigation_profile_to_editProfileFragment);
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        String photoPath = ((NavigationActivity)getActivity()).setPhoto();
        if (!photoPath.isEmpty()) {
            new LoadConvertPhotoFileTask(binding.imageViewProfile).execute(photoPath);
        }
    }

    private void checkPermissions() {
        PermissionListener dialogDeniedPermissionListener =
                DialogOnDeniedPermissionListener.Builder.withContext(getActivity())
                        .withTitle("Permisos")
                        .withMessage("Los permisos solicitados son necesarios para poder seleccionar una foto de perfil")
                        .withButtonText("Aceptar")
                        .withIcon(R.mipmap.ic_launcher)
                        .build();

        mAllPermissionListener = new CompositePermissionListener(
                (PermissionListener) getActivity(),
                dialogDeniedPermissionListener
        );

        Dexter.withContext(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(mAllPermissionListener)
                .check();
    }

    private void logout() {
        SharedPreferencesManager.removeDataValue(AppConstants.USER_TOKEN);
        Intent intent = new Intent(getActivity(), SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}