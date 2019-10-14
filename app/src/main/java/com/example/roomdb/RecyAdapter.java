package com.example.roomdb;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.databinding.ListItemsBinding;
import com.example.roomdb.room.Purchase;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.RecViewHolder> {

    private List<Purchase> list;
    private Context context;

    public RecyAdapter(List<Purchase> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.list_items, parent, false);
        return new RecViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        Purchase purchase = list.get(position);
        holder.bind(purchase);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        ListItemsBinding binding;

        public RecViewHolder(@NonNull ListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Purchase purchase) {
            binding.Km.setText("K.M. " + purchase.getKm());
            binding.Date.setText("Date " + purchase.getDate());
            binding.Lit.setText(String.valueOf(purchase.getLitre()) + " Lit");
            binding.Rupee.setText(String.valueOf(purchase.getRupee()) + " ₹");
        }
    }
}





