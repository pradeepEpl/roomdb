package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.roomdb.databinding.ActivityMainBinding;
import com.example.roomdb.fragment.InputFragment;
import com.example.roomdb.room.ExDatabase;
import com.example.roomdb.room.Purchase;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    public List<Purchase> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        load();
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(binding.getRoot(), "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                InputFragment inputFragment = new InputFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.input, inputFragment);
                transaction.commit();
            }
        });
    }

    private void load() {
        new GetData().execute();

    }
    class GetData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            list = ExDatabase.getInstance(MainApplication.getAppContext()).purchaseDao().getAll();
            for (Purchase purchase : list) {
                Log.d(TAG, " GET >> " + purchase.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            RecyAdapter adapter = new RecyAdapter(list, MainActivity.this);
            binding.list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            binding.list.setAdapter(adapter);
        }
    }
}
