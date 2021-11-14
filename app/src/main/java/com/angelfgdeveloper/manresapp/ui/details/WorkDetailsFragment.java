package com.angelfgdeveloper.manresapp.ui.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.data.models.Work;
import com.angelfgdeveloper.manresapp.databinding.FragmentWorkDetailsBinding;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.google.gson.Gson;

public class WorkDetailsFragment extends Fragment {

    private FragmentWorkDetailsBinding binding;
    private Toolbar toolbar;
    private String jsonWork = "";
    private Work work;

    private OnWorkDetailsFragmentListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnWorkDetailsFragmentListener) {
            listener = (OnWorkDetailsFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " OnWorkDetailsFragmentListener");
        }
    }

    public WorkDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener.setVisibleBottomNavigation(false);
        if (getArguments() != null) {
            jsonWork = getArguments().getString(AppConstants.WORK);
        }
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWorkDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        toolbar = binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Más detalles");
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).popBackStack();
            listener.setVisibleBottomNavigation(true);
        });

        Gson gson = new Gson();
        work = gson.fromJson(jsonWork, Work.class);
        binding.textViewTitle.setText(work.getTitle());
        binding.textViewWorkStation.setText(work.getWorkstation());
        binding.textViewLocation.setText(work.getLocation());
        binding.textViewReleased.setText(work.getReleased());
        binding.textViewDescription.setText(work.getDescription());
        binding.textViewSalary.setText("$" + work.getSalary() + " MXN (" + work.getPayments() + ")");

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener.setVisibleBottomNavigation(true);
    }

    public interface OnWorkDetailsFragmentListener {
        void setVisibleBottomNavigation(boolean isVisible);
    }
}