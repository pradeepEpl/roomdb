package com.example.roomdb;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.roomdb.room.ExDatabase;
import com.example.roomdb.room.Purchase;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();
    private ExDatabase database = null;


    public Repository() {
        database = ExDatabase.getInstance(MainApplication.getAppContext());
    }

    public void save(Purchase purchase, MutableLiveData<String> mutableLiveData) {
        new DBAction(purchase, mutableLiveData).execute();
    }

    class DBAction extends AsyncTask {
        private Purchase purchase;
        MutableLiveData<String> mutableLiveData;

        public DBAction(Purchase purchase, MutableLiveData<String> mutableLiveData) {
            this.purchase = purchase;
            this.mutableLiveData = mutableLiveData;
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            long row = database.purchaseDao().insert(purchase);
            Log.d(TAG, " row inserted >> " + row);
            if (row != 0) {
                mutableLiveData.postValue("success");
            } else {
                mutableLiveData.postValue("fail");
            }
            return null;
        }
    }

}
