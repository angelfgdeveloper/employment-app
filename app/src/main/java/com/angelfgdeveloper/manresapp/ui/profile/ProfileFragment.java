package com.angelfgdeveloper.manresapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.data.models.Postulation;
import com.angelfgdeveloper.manresapp.databinding.FragmentProfileBinding;
import com.angelfgdeveloper.manresapp.helpers.Constants;
import com.angelfgdeveloper.manresapp.ui.LoginActivity;
import com.angelfgdeveloper.manresapp.ui.QuestionMainActivity;
import com.angelfgdeveloper.manresapp.ui.SplashActivity;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    private MyPostulationRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getData();

        binding.buttonLogout.setOnClickListener(v -> logout());

        binding.imageButtonEdit.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_navigation_profile_to_editProfileFragment);
        });

        return root;
    }

    private void getData() {
        ArrayList<Postulation> postulations = new ArrayList<>();
        postulations.add(new Postulation(1, "Operador de producción", "Lala", "Aún no te han asignado pruebas", "No puedes eliminar esta postulaccción ya que la empresa ha depurados a los candidados y has sido un seleccionado."));
        postulations.add(new Postulation(2, "Agente de ventas/Cambaceo", "Takis - Barcell", "Aún no te han asignado pruebas", ""));
        postulations.add(new Postulation(3, "Cobrador con motocicleta propia", "Elektra", "Aún no te han asignado pruebas", "No puedes eliminar esta postulaccción ya que la empresa ha depurados a los candidados y has sido un seleccionado."));
        postulations.add(new Postulation(4, "Agente de ventas/Cambaceo", "Takis - Barcell", "Aún no te han asignado pruebas", ""));

        adapter = new MyPostulationRecyclerViewAdapter(getActivity(), postulations);
        binding.recyclerViewApplications.setAdapter(adapter);
        binding.recyclerViewApplications.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void logout() {
        SharedPreferencesManager.removeDataValue(AppConstants.USER_TOKEN);
        Intent intent = new Intent(getActivity(), SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}