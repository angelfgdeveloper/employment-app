package com.angelfgdeveloper.manresapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.angelfgdeveloper.manresapp.databinding.FragmentProfileBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.SplashActivity;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonLogout.setOnClickListener(v -> logout());

        return root;
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