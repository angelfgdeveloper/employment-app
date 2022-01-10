package com.angelfgdeveloper.manresapp.ui.question;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentExtrasBinding;

public class ExtrasFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentExtrasBinding binding;

    private OnExtraFragmentListener listener;

    private String mSelection = "", mContractJob = "", mReasonContract = "";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnExtraFragmentListener) {
            listener = (OnExtraFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + "OnExtraFragmentListener");
        }
    }

    @SuppressLint("SetTextI18n")
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent data = result.getData();
            binding.textViewNameFile.setVisibility(View.VISIBLE);
            binding.textViewNameFile.setText("Archivo: " + data.getData());
        }
    });

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        binding = FragmentExtrasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addSelectData();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonFinish.setOnClickListener(v -> {
            listener.setQuestionInfo("Success_Test");
        });

        binding.buttonNewFile.setOnClickListener(v -> {
            callChooseFileFromDevide();
        });

        return root;
    }

    private void callChooseFileFromDevide() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        someActivityResultLauncher.launch(intent);
    }

    private void addSelectData() {
        mViewModel.getAllYesAndNot().observe(getViewLifecycleOwner(), yesAndNot -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_item, yesAndNot);
            binding.autoCompleteTextViewSelection.setAdapter(adapter);
            binding.autoCompleteTextViewContractJobs.setAdapter(adapter);
            binding.autoCompleteTextViewReasonContract.setAdapter(adapter);

            binding.autoCompleteTextViewSelection.setOnItemClickListener((parent, view1, position, id) -> {
                mSelection = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), mSelection + " - Posicion: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
            });

            binding.autoCompleteTextViewContractJobs.setOnItemClickListener((parent, view1, position, id) -> {
                mContractJob = parent.getItemAtPosition(position).toString();

            });

            binding.autoCompleteTextViewReasonContract.setOnItemClickListener((parent, view1, position, id) -> {
                mReasonContract = parent.getItemAtPosition(position).toString();
            });

        });
    }

    public interface OnExtraFragmentListener {
        void setQuestionInfo(String infoUser);
    }
}