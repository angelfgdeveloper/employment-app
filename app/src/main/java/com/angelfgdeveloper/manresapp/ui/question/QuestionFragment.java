package com.angelfgdeveloper.manresapp.ui.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.QuestionFragmentBinding;

public class QuestionFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private QuestionFragmentBinding binding;

    private String mGender = "";
    private String mNationality = "";
    private String mData = "";

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mData = getArguments().getString("DATA_USER");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = QuestionFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addSelectData();

        binding.buttonNext.setOnClickListener(v -> goToJob(root));

        return root;
    }

    private void addSelectData() {
        mViewModel.getAllGender().observe(getViewLifecycleOwner(), gender -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, gender);
            binding.autoCompleteTextViewGender.setAdapter(adapter);
            binding.autoCompleteTextViewGender.setOnItemClickListener((parent, view1, position, id) -> {
                mGender = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mGender + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });

        mViewModel.getAllNationality().observe(getViewLifecycleOwner(), nationality -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, nationality);
            binding.autoCompleteTextViewNationality.setAdapter(adapter);
            binding.autoCompleteTextViewNationality.setOnItemClickListener((parent, view1, position, id) -> {
                mNationality = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mNationality + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });
        });
    }

    private void goToJob(View view) {
//        Gson gson = new Gson();
//        String jsonWork = gson.toJson(work);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_USER", "Datos");
        Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_jobFragment, bundle);
    }

}