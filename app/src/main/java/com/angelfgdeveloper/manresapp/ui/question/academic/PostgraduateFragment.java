package com.angelfgdeveloper.manresapp.ui.question.academic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentPostgraduateBinding;
import com.angelfgdeveloper.manresapp.ui.question.QuestionViewModel;

public class PostgraduateFragment extends Fragment {

    private FragmentPostgraduateBinding binding;
    private QuestionViewModel mViewModel;

    private String mStartMonths = "", mLastMonths = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentPostgraduateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addSelectData();

        return root;
    }

    private void addSelectData() {
        mViewModel.getAllMonths().observe(getViewLifecycleOwner(), months -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, months);
            binding.autoCompleteTextViewStartMonth.setAdapter(adapter);
            binding.autoCompleteTextViewLastMonth.setAdapter(adapter);

            binding.autoCompleteTextViewStartMonth.setOnItemClickListener((parent, view1, position, id) -> {
                mStartMonths = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mStartMonths + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });

            binding.autoCompleteTextViewLastMonth.setOnItemClickListener((parent, view1, position, id) -> {
                mLastMonths = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mLastMonths + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });
    }
}