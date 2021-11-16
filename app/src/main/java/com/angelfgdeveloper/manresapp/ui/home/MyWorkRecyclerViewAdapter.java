package com.angelfgdeveloper.manresapp.ui.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.angelfgdeveloper.manresapp.data.models.Work;
import com.angelfgdeveloper.manresapp.databinding.FragmentWorkBinding;

import java.util.ArrayList;
import java.util.List;

public class MyWorkRecyclerViewAdapter extends RecyclerView.Adapter<MyWorkRecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Work> mWork;
    private Context mContext;

    public MyWorkRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setDataWorkList(List<Work> work) {
        this.mWork = work;
        notifyDataSetChanged();
    }

    public void setFilter(ArrayList<Work> newWorkList) {
        this.mWork = newWorkList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentWorkBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        if (mWork == null) return 0;
        else return mWork.size();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Work work = mWork.get(position);
        holder.tvLocation.setText(work.getLocation());
        holder.tvTitle.setText(work.getTitle());
        holder.tvWorkStation.setText(work.getWorkstation());
        holder.tvDescription.setText(work.getDescription().replace("\n", " "));
        holder.tvSalary.setText("$" + work.getSalary() + " MXN (" + work.getPayments() + ")");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvLocation, tvTitle, tvWorkStation, tvDescription, tvSalary;

        public ViewHolder(FragmentWorkBinding binding) {
            super(binding.getRoot());
            tvLocation = binding.textViewLocation;
            tvTitle = binding.textViewTitle;
            tvWorkStation = binding.textViewWorkStation;
            tvDescription = binding.textViewDescription;
            tvSalary = binding.textViewSalary;

            binding.cardViewWork.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onWorkItemClick(mWork.get(position));
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onWorkItemClick(Work work);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}