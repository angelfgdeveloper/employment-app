package com.angelfgdeveloper.manresapp.ui.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.QuestionFragmentBinding;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.google.gson.Gson;

public class QuestionFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private QuestionFragmentBinding binding;

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = QuestionFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonNext.setOnClickListener(v -> goToJob(root));


        return root;
    }

    private void goToJob(View view) {
//        Gson gson = new Gson();
//        String jsonWork = gson.toJson(work);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_USER", "Datos");
        Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_jobFragment, bundle);
    }

}