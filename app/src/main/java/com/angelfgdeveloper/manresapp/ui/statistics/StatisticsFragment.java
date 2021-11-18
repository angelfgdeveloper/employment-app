package com.angelfgdeveloper.manresapp.ui.statistics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentStatisticsBinding;

public class StatisticsFragment extends Fragment {

    private FragmentStatisticsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}