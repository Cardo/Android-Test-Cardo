package com.cardo.bairesdevtest.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProyectosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    // De rutina por pattern

    public ProyectosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la lista de GitHub");
    }

    public LiveData<String> getText() {
        return mText;
    }
}