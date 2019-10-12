package com.example.roomdb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.roomdb.R;
import com.example.roomdb.databinding.FillDetailsFragmentBinding;

public class InputFragment extends Fragment {

    private FillDetailsFragmentBinding binding;
    private InputViewModel inputViewModel;
    private static final String TAG = InputFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fill_details_fragment);
        inputViewModel = ViewModelProviders.of(getActivity()).get(InputViewModel.class);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
