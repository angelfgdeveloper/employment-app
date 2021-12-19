package com.angelfgdeveloper.manresapp.ui.question.academic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelfgdeveloper.manresapp.databinding.FragmentProcessAcademicBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class ProcessAcademicFragment extends Fragment {

    private FragmentProcessAcademicBinding binding;
    private QuestionViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentProcessAcademicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

}