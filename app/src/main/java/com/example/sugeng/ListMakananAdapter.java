package com.example.sugeng;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMakananAdapter extends RecyclerView.Adapter<ListMakananAdapter.ListViewHolder> {
    private ArrayList<Makanan> listMakanan;
    public ListMakananAdapter(ArrayList<Makanan> list) {
        this.listMakanan = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_makanan, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Makanan makanan = listMakanan.get(position);
        // dibawah ini asal untuk membuat OnClick. bisa juga di ganti context
        Glide.with(holder.itemView.getContext()).load(makanan.getPhoto()).apply(new RequestOptions().override(55, 55)).into(holder.imgPhoto);
        holder.tvName.setText(makanan.getName());
        holder.tvDetail.setText(makanan.getDetail());

        holder.itemMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ingat biasanya Context disini holder.itemview.getContext
                //Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listMakanan.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);

                intent.putExtra("img_url", makanan.getPhoto());
                intent.putExtra("name_url", makanan.getName());
                intent.putExtra("detail_url", makanan.getDetail());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        RelativeLayout itemMakanan;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            itemMakanan = itemView.findViewById(R.id.item_makanan);
        }
    }
}
