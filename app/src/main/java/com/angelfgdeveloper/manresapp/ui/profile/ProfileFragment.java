package com.angelfgdeveloper.manresapp.ui.profile;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.data.models.Postulation;
import com.angelfgdeveloper.manresapp.databinding.FragmentProfileBinding;
import com.angelfgdeveloper.manresapp.ui.NavigationActivity;
import com.angelfgdeveloper.manresapp.ui.SplashActivity;
import com.angelfgdeveloper.manresapp.utils.AppConstants;
import com.angelfgdeveloper.manresapp.utils.LoadConvertPhotoFileTask;
import com.angelfgdeveloper.manresapp.utils.SharedPreferencesManager;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;
    private PermissionListener mAllPermissionListener;

    private MyPostulationRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getData();

        binding.buttonLogout.setOnClickListener(v -> logout());

        binding.imageViewProfile.setOnClickListener(view -> {
            checkPermissions();
        });

        binding.imageButtonEdit.setOnClickListener(v -> {
            Navigation.findNavController(root).navigate(R.id.action_navigation_profile_to_editProfileFragment);
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        String photoPath = ((NavigationActivity) getActivity()).setPhoto();
        if (!photoPath.isEmpty()) {
            new LoadConvertPhotoFileTask(binding.imageViewProfile).execute(photoPath);
        }
    }

    private void checkPermissions() {
        PermissionListener dialogDeniedPermissionListener =
                DialogOnDeniedPermissionListener.Builder.withContext(getActivity())
                        .withTitle("Permisos")
                        .withMessage("Los permisos solicitados son necesarios para poder seleccionar una foto de perfil")
                        .withButtonText("Aceptar")
                        .withIcon(R.mipmap.ic_launcher)
                        .build();

        mAllPermissionListener = new CompositePermissionListener(
                (PermissionListener) getActivity(),
                dialogDeniedPermissionListener
        );

        Dexter.withContext(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(mAllPermissionListener)
                .check();

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