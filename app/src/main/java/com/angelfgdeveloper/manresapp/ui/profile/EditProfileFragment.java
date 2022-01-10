package com.angelfgdeveloper.manresapp.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.databinding.FragmentEditProfileBinding;
import com.angelfgdeveloper.manresapp.ui.QuestionMainActivity;

public class EditProfileFragment extends Fragment {

    private OnEditProfileFragmentListener listener;
    private FragmentEditProfileBinding binding;

    private Toolbar toolbar;

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    public static EditProfileFragment newInstance(String param1) {
        EditProfileFragment fragment = new EditProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnEditProfileFragmentListener) {
            listener = (OnEditProfileFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " OnEditProfileFragmentListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener.setEditVisibleBottomNavigation(false);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        toolbar = binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Editar perfíl");
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).popBackStack();
            listener.setEditVisibleBottomNavigation(true);
        });

        binding.editTextLastName.setText("Steve Jobs");
        binding.editTextEmail.setText("steve@test.com");
        binding.editTextEmail.setEnabled(false);

        binding.buttonSave.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        });

        binding.buttonInfoPersonal.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), QuestionMainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener.setEditVisibleBottomNavigation(true);
    }

    public interface OnEditProfileFragmentListener {
        void setEditVisibleBottomNavigation(boolean isVisible);
    }

}