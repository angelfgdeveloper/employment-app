package com.angelfgdeveloper.manresapp.ui.question.job;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentReferencesBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class ReferencesFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentReferencesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentReferencesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
}