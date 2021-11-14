package com.angelfgdeveloper.manresapp.ui.home;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.data.models.Work;
import com.angelfgdeveloper.manresapp.databinding.FragmentHomeBinding;
import com.angelfgdeveloper.manresapp.helpers.Validators;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.google.gson.Gson;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private MyWorkRecyclerViewAdapter mAdapter;
    private Toolbar toolbar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        toolbar = binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Alef App");
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

        mAdapter = new MyWorkRecyclerViewAdapter(getActivity());
        binding.recyclerViewOccupation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewOccupation.setAdapter(mAdapter);

        homeViewModel.getAllWorks().observe(getViewLifecycleOwner(), works -> {
            mAdapter.setDataWorkList(works);
            mAdapter.setOnItemClickListener(work -> goWorkDetailsFragment(view, work));
        });
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