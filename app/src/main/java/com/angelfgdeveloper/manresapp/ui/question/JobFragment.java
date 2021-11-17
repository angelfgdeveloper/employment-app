package com.angelfgdeveloper.manresapp.ui.question;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentJobBinding;

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

        binding.switchExperience.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.linearLayoutExperience.setBackgroundColor(Color.BLUE);
            } else {
                binding.linearLayoutExperience.setBackgroundResource(R.color.purple_200);
            }
        });

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonNext.setOnClickListener(v -> Toast.makeText(getActivity(), "Siguiente apartado", Toast.LENGTH_SHORT).show());

        return root;
    }
}