package com.example.gunderhospital.paketku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gunderhospital.R;

import java.util.List;

public class AdapterDataku extends RecyclerView.Adapter<AdapterDataku.ViewHolder>  {
    Context context;
    List<Dataku> list;
    OnCallBack onCallBack;
    public void setOnCallBack(OnCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    public AdapterDataku(Context context, List<Dataku> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_data_leot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.teksViu_data.setText(list.get(position).getNama());
        holder.tblHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onTblHapus(list.get(position));
            }
        });
        holder.tblEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onTblEdit(list.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView teksViu_data;
        ImageButton tblHapus,tblEdit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teksViu_data = itemView.findViewById(R.id.teks_viu_data);
            tblHapus = itemView.findViewById(R.id.tbl_hapus);
            tblEdit = itemView.findViewById(R.id.tbl_edit);
        }
    }
    public interface OnCallBack{
        void onTblHapus(Dataku dataku);
        void onTblEdit(Dataku dataku);
    }
}
