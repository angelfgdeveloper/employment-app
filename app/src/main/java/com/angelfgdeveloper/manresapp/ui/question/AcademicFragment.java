package com.angelfgdeveloper.manresapp.ui.question;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentAcademicBinding;

public class AcademicFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentAcademicBinding binding;

    public static AcademicFragment newInstance(String param1, String param2) {
        AcademicFragment fragment = new AcademicFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentAcademicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonNext.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_academicFragment_to_medicFragment);
        });

        return root;
    }
}