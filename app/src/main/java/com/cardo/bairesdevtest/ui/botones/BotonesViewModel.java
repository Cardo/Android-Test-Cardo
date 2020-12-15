package com.cardo.bairesdevtest.ui.botones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BotonesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    //  De rutina por pattern

    public BotonesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}