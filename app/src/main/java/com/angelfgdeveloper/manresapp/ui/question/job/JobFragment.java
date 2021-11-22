package com.angelfgdeveloper.manresapp.ui.question.job;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentJobBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class JobFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentJobBinding binding;

    private String data = "";

    public JobFragment() {
    }

    public static JobFragment newInstance() {
        return new JobFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            data = getArguments().getString("DATA_USER");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentJobBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initFragment();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonNext.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_jobFragment_to_academicFragment);
        });

        return root;
    }

    private void initFragment() {
        Fragment lastJobsFragment = new LastJobsFragment();
        Fragment referencesFragment = new ReferencesFragment();

        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.fragmentContainer, lastJobsFragment);
        transaction.commit();

        binding.switchExperience.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                fragmentContainer(lastJobsFragment);
            } else {
                fragmentContainer(referencesFragment);
            }
        });
    }

    private void fragmentContainer(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}