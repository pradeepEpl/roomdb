package com.example.roomdb.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdb.Repository;
import com.example.roomdb.room.Purchase;

public class InputViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<String> mutableLiveData;

    public InputViewModel() {
        repository = new Repository();
        mutableLiveData = new MutableLiveData<>();
    }

    public void save(Purchase purchase) {
        repository.save(purchase, mutableLiveData);
    }
    public LiveData<String> getLiveData() {
        return mutableLiveData;
    }
}
