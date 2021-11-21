package com.angelfgdeveloper.manresapp.ui.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentAcademicBinding;

public class AcademicFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentAcademicBinding binding;

    private String mDegrees = "";
    private String mAdvanceStudies = "";
    private String mStartMonths = "";
    private String mLastMonths = "";

    public static AcademicFragment newInstance(String param1, String param2) {
        AcademicFragment fragment = new AcademicFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentAcademicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addSelectData();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonNext.setOnClickListener(v -> Navigation.findNavController(root).navigate(R.id.action_academicFragment_to_medicFragment));

        return root;
    }

    private void addSelectData() {
        mViewModel.getAllDegrees().observe(getViewLifecycleOwner(), degrees -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, degrees);
            binding.autoCompleteTextViewEducation.setAdapter(adapter);
            binding.autoCompleteTextViewEducation.setOnItemClickListener((parent, view1, position, id) -> {
                mDegrees = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mDegrees + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

        mViewModel.getAllAdvanceStudies().observe(getViewLifecycleOwner(), advanceStudies -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, advanceStudies);
            binding.autoCompleteTextViewAdvance.setAdapter(adapter);
            binding.autoCompleteTextViewAdvance.setOnItemClickListener((parent, view1, position, id) -> {
                mAdvanceStudies = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mAdvanceStudies + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

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