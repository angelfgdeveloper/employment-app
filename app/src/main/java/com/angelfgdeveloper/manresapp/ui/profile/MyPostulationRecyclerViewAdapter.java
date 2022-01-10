package com.angelfgdeveloper.manresapp.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.angelfgdeveloper.manresapp.data.models.Postulation;
import com.angelfgdeveloper.manresapp.databinding.ItemPostulationBinding;

import java.util.ArrayList;
import java.util.List;

public class MyPostulationRecyclerViewAdapter extends RecyclerView.Adapter<MyPostulationRecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Postulation> mPostulation;
    private Context mContext;

    public MyPostulationRecyclerViewAdapter(Context context, ArrayList<Postulation> postulations) {
        this.mContext = context;
        this.mPostulation = postulations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemPostulationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        if (mPostulation == null) return 0;
        else return mPostulation.size();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Postulation postulation = mPostulation.get(position);
        holder.tvJob.setText(postulation.getPostulation());
        holder.tvCompany.setText(postulation.getCompany());
        holder.tvTestsComplete.setText(postulation.getTestToCompany());

        if (!postulation.getObjections().isEmpty()) {
            holder.tvDecline.setVisibility(View.VISIBLE);
            holder.tvDecline.setText(postulation.getObjections());
            holder.btnDecline.setText("Desistir");
        } else {
            holder.tvDecline.setVisibility(View.GONE);
            holder.btnDecline.setText("Eliminar");
        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvJob, tvCompany, tvTestsComplete, tvDecline;
        public final Button btnDecline;

        public ViewHolder(ItemPostulationBinding binding) {
            super(binding.getRoot());

            tvJob = binding.textViewJob;
            tvCompany = binding.textViewCompany;
            tvTestsComplete = binding.textViewTestsComplete;
            tvDecline = binding.textViewDecline;
            btnDecline = binding.buttonDecline;

            binding.tableRow.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onPostulationItemClick(mPostulation.get(position));
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onPostulationItemClick(Postulation postulation);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}