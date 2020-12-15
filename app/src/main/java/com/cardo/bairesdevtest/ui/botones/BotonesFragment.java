package com.cardo.bairesdevtest.ui.botones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.cardo.bairesdevtest.R;

public class BotonesFragment extends Fragment {

    private BotonesViewModel botonesViewModel;


    // Solo alimenta view, trabajo de UI se realiza desde Main Activity desplegando Toasts y Alerts
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        botonesViewModel =
                ViewModelProviders.of(this).get(BotonesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_botones, container, false);

        return root;
    }


}
