package com.example.roomdb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.roomdb.R;
import com.example.roomdb.databinding.FillDetailsFragmentBinding;
import com.example.roomdb.room.Purchase;

public class InputFragment extends Fragment {

    private FillDetailsFragmentBinding binding;
    private InputViewModel inputViewModel;
    private static final String TAG = InputFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fill_details_fragment);
        inputViewModel = ViewModelProviders.of(getActivity()).get(InputViewModel.class);
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Purchase purchase = new Purchase();
                purchase.setKm(binding.km.getText().toString());
                purchase.setRupee(Integer.parseInt(binding.rupee.getText().toString()));
                purchase.setLitre(Float.parseFloat(binding.ltr.getText().toString()));
                purchase.setDate(binding.date.getText().toString());
                inputViewModel.save(purchase);
            }
        });

        inputViewModel.getLiveData().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if ("success".equals(s)) {
                    getActivity().finishAndRemoveTask();
                }
            }
        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
