package com.example.pijee.mysubmission.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pijee.mysubmission.DetailActivity;
import com.example.pijee.mysubmission.R;
import com.example.pijee.mysubmission.model.Anggota;

import java.util.ArrayList;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.AnggotaViewHolder> {

    private Context context;
    private ArrayList<Anggota> listAnggota;

    public AnggotaAdapter(Context context) {this.context = context;}

    public ArrayList<Anggota> getListAnggota() {
        return listAnggota;
    }

    public void setListClub(ArrayList<Anggota> listAnggota) {
        this.listAnggota = listAnggota;
    }


    @NonNull
    @Override
    public AnggotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new AnggotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnggotaViewHolder holder, final int position) {
        holder.tvJudul.setText(getListAnggota().get(position).getNama());
        holder.ivGambar.setImageResource(getListAnggota().get(position).getPicture());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ANGGOTA, listAnggota.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()  { return getListAnggota().size(); }

    public class AnggotaViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul;
        ImageView ivGambar;

        public AnggotaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tvNama);
            ivGambar = itemView.findViewById(R.id.ivGambar);
        }
    }

}