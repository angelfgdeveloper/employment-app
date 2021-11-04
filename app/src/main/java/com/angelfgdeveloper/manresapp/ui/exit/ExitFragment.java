package com.angelfgdeveloper.manresapp.ui.exit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.angelfgdeveloper.manresapp.R;

public class ExitFragment extends Fragment {

    private OnExitFragmentListener listener;

    public ExitFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnExitFragmentListener) {
            listener = (OnExitFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " OnExitFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listener.onClosedPreview(true);
        return inflater.inflate(R.layout.fragment_exit, container, false);
    }

    public interface OnExitFragmentListener {
        void onClosedPreview(boolean isClosed);
    }
}