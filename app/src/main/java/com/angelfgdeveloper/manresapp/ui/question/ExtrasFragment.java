package com.angelfgdeveloper.manresapp.ui.question;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentExtrasBinding;

public class ExtrasFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentExtrasBinding binding;

    private OnExtraFragmentListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnExtraFragmentListener) {
            listener = (OnExtraFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + "OnExtraFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        binding = FragmentExtrasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBack.setOnClickListener(v -> Navigation.findNavController(root).popBackStack());

        binding.buttonFinish.setOnClickListener(v -> {
            listener.setQuestionInfo("Encuesta realizada!!!");
        });


        return root;
    }

    public interface OnExtraFragmentListener {
        void setQuestionInfo(String infoUser);
    }
}