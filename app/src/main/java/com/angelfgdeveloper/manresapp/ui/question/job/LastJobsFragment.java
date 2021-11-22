package com.angelfgdeveloper.manresapp.ui.question.job;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentJobBinding;
import com.angelfgdeveloper.manresapp.databinding.FragmentLastJobsBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class LastJobsFragment extends Fragment {

    private FragmentLastJobsBinding binding;
    private QuestionViewModel mViewModel;
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public LastJobsFragment() {
        // Required empty public constructor
    }

    public static LastJobsFragment newInstance(String param1) {
        LastJobsFragment fragment = new LastJobsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentLastJobsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}