package com.angelfgdeveloper.manresapp.ui.home;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.data.models.Work;
import com.angelfgdeveloper.manresapp.databinding.FragmentHomeBinding;
import com.angelfgdeveloper.manresapp.helpers.Validators;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private MyWorkRecyclerViewAdapter mAdapter;
    private Toolbar toolbar;

    private List<Work> mWork;
    private String state = "";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        toolbar = binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");
        }

        binding.linearLayoutLoading.setVisibility(View.VISIBLE);
        int colorPurpleDark = Color.parseColor("#FF3700B3");
        binding.progressBar.setIndeterminateTintList(ColorStateList.valueOf(colorPurpleDark));

        if (Validators.isConnected(getActivity())) {
            isConnected(root);
        } else {
            binding.linearLayoutLoading.setVisibility(View.GONE);
            binding.linearLayoutDisconnected.setVisibility(View.VISIBLE);
        }

        return root;
    }

    private void isConnected(View view) {
        binding.linearLayoutLoading.setVisibility(View.GONE);
        binding.linearLayoutDisconnected.setVisibility(View.GONE);
        binding.linearLayoutConnected.setVisibility(View.VISIBLE);

        mWork = new ArrayList<>();

        mAdapter = new MyWorkRecyclerViewAdapter(getActivity());
        binding.recyclerViewOccupation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewOccupation.setAdapter(mAdapter);

        homeViewModel.getAllStates().observe(getViewLifecycleOwner(), states -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, states);
            binding.autoCompleteTextViewLocation.setAdapter(adapter);
            binding.autoCompleteTextViewLocation.setOnItemClickListener((parent, view1, position, id) -> {
                state = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), state + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

        homeViewModel.getAllWorks().observe(getViewLifecycleOwner(), works -> {
            mAdapter.setDataWorkList(works);
            mAdapter.setOnItemClickListener(work -> goWorkDetailsFragment(view, work));
            mWork.addAll(works);
        });

        binding.editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.buttonSearch.setOnClickListener(v -> filter(s.toString()));
            }
        });

    }

    private void filter(String text) {
        ArrayList<Work> newWorkList = new ArrayList<>();
        for (Work work : mWork) {
            if (work.getTitle().toLowerCase().contains(text)){
                newWorkList.add(work);
            }
        }
        mAdapter.setFilter(newWorkList);
    }

    private void goWorkDetailsFragment(View view, Work work) {
        Gson gson = new Gson();
        String jsonWork = gson.toJson(work);
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.WORK, jsonWork);
        Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_workDetailsFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}