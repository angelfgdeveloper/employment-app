package com.angelfgdeveloper.manresapp.ui.question;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentMedicBinding;

public class MedicFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentMedicBinding binding;

    private String mHealth = "", mBloodType = "", mSport = "", mSmoke = "", mAlcohol = "", mSurgery = "", mAccidents = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        binding = FragmentMedicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addSelectData();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonNext.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_medicFragment_to_extrasFragment);
        });

        return root;
    }

    private void addSelectData() {
        mViewModel.getAllHealth().observe(getViewLifecycleOwner(), health -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, health);
            binding.autoCompleteTextViewHealth.setAdapter(adapter);
            binding.autoCompleteTextViewHealth.setOnItemClickListener((parent, view1, position, id) -> {
                mHealth = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mHealth + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

        mViewModel.getAllBloodType().observe(getViewLifecycleOwner(), bloodType -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, bloodType);
            binding.autoCompleteTextViewBloodType.setAdapter(adapter);
            binding.autoCompleteTextViewBloodType.setOnItemClickListener((parent, view1, position, id) -> {
                mBloodType = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mBloodType + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

        mViewModel.getAllYesAndNot().observe(getViewLifecycleOwner(), yesAndNot -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, yesAndNot);
            binding.autoCompleteTextViewSport.setAdapter(adapter);
            binding.autoCompleteTextViewSmoke.setAdapter(adapter);
            binding.autoCompleteTextViewAlcohol.setAdapter(adapter);
            binding.autoCompleteTextViewSurgery.setAdapter(adapter);
            binding.autoCompleteTextViewAccidents.setAdapter(adapter);

            binding.autoCompleteTextViewSport.setOnItemClickListener((parent, view1, position, id) -> {
                mSport = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mSport + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });

            binding.autoCompleteTextViewSmoke.setOnItemClickListener((parent, view1, position, id) -> {
                mSmoke = parent.getItemAtPosition(position).toString();
                if (mSmoke.equals("Si")) {
                    binding.llDetailsSmoke.setVisibility(View.VISIBLE);
                } else {
                    binding.llDetailsSmoke.setVisibility(View.GONE);
                }
            });

            binding.autoCompleteTextViewAlcohol.setOnItemClickListener((parent, view1, position, id) -> {
                mAlcohol = parent.getItemAtPosition(position).toString();
                if (mAlcohol.equals("Si")) {
                    binding.llDetailsAlcohol.setVisibility(View.VISIBLE);
                } else {
                    binding.llDetailsAlcohol.setVisibility(View.GONE);
                }
            });

            binding.autoCompleteTextViewSurgery.setOnItemClickListener((parent, view1, position, id) -> {
                mSurgery = parent.getItemAtPosition(position).toString();
                if (mSurgery.equals("Si")) {
                    binding.llDetailsSurgeries.setVisibility(View.VISIBLE);
                } else {
                    binding.llDetailsSurgeries.setVisibility(View.GONE);
                }

            });

            binding.autoCompleteTextViewAccidents.setOnItemClickListener((parent, view1, position, id) -> {
                mAccidents = parent.getItemAtPosition(position).toString();
                if (mAccidents.equals("Si")) {
                    binding.llDetailsAccidents.setVisibility(View.VISIBLE);
                } else {
                    binding.llDetailsAccidents.setVisibility(View.GONE);
                }
            });

        });

    }
}