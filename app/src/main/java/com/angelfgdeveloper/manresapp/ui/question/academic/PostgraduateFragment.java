package com.angelfgdeveloper.manresapp.ui.question.academic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelfgdeveloper.manresapp.databinding.FragmentPostgraduateBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class PostgraduateFragment extends Fragment {

    private FragmentPostgraduateBinding binding;
    private QuestionViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentPostgraduateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}