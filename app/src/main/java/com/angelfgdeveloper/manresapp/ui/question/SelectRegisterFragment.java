package com.angelfgdeveloper.manresapp.ui.question;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentSelectRegisterBinding;
import com.angelfgdeveloper.manresapp.databinding.QuestionFragmentBinding;

public class SelectRegisterFragment extends Fragment {

    private QuestionViewModel mViewModel;
    private FragmentSelectRegisterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding = FragmentSelectRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getShowDialog();

        return root;
    }

    private void getShowDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_person_or_company);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ImageView ivPersonal = dialog.findViewById(R.id.ivRegisterPerson);
        ImageView ivCompany = dialog.findViewById(R.id.ivRegisterCompany);

        ivPersonal.setOnClickListener(view -> {
            setDataNavigation("Personal", binding.getRoot());
            dialog.dismiss();
        });

        ivCompany.setOnClickListener(view -> {
            setDataNavigation("Negocio", binding.getRoot());
            dialog.dismiss();
        });

        dialog.show();

    }

    private void setDataNavigation(String data, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("DATA_USER", data);
        Navigation.findNavController(view).navigate(R.id.action_selectRegisterFragment_to_questionFragment, bundle);
    }
}