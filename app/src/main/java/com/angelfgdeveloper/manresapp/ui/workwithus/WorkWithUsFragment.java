package com.angelfgdeveloper.manresapp.ui.workwithus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentJobBinding;
import com.angelfgdeveloper.manresapp.databinding.FragmentWorkWithUsBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class WorkWithUsFragment extends Fragment {

    private FragmentWorkWithUsBinding binding;

    public WorkWithUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWorkWithUsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonWorkWithUs.setOnClickListener(v -> Toast.makeText(getActivity(), "Disculpe las molestias estamos en desarrollo :D", Toast.LENGTH_SHORT).show());

        return root;
    }
}