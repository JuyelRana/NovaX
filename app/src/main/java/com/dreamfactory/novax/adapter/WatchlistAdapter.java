package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Watchlist> watchlists=new ArrayList<>();
    Context mcontext;

    public WatchlistAdapter(List<Watchlist> watchlists, Context mcontext) {
        this.watchlists = watchlists;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.watchlist_single_row_design, viewGroup, false);
        return new WatchlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Watchlist list = watchlists.get(position);
        ((WatchlistViewHolder) viewHolder).txt_product_name.setText(list.getTxt_product_name());
        ((WatchlistViewHolder) viewHolder).txt_product_price.setText(list.getTxt_product_price());
        ((WatchlistViewHolder) viewHolder).txt_product_percentage.setText(list.getTxt_product_percentage());
        ((WatchlistViewHolder) viewHolder).txt_product_amount.setText(list.getTxt_product_amount());
        ((WatchlistViewHolder) viewHolder).txt_product_share_amount.setText(list.getTxt_product_share_amount());
        ((WatchlistViewHolder) viewHolder).txt_product_loss.setText(list.getTxt_product_loss());
        ((WatchlistViewHolder) viewHolder).txt_product_loss_weight.setText(list.getTxt_product_loss_weight());
        ((WatchlistViewHolder) viewHolder).img_product.setImageResource(list.getImg_product());
    }

    @Override
    public int getItemCount() {
        return watchlists == null ? 0 : watchlists.size();
    }

    public class WatchlistViewHolder extends RecyclerView.ViewHolder{

         ImageView img_product;
         TextView txt_product_name,txt_product_price,txt_product_percentage,txt_product_amount,txt_product_share_amount,txt_product_loss,txt_product_loss_weight;

        public WatchlistViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_product_name=itemView.findViewById(R.id.txt_product_name);
            txt_product_price=itemView.findViewById(R.id.txt_product_price);
            txt_product_percentage=itemView.findViewById(R.id.txt_product_percentage);
            txt_product_amount=itemView.findViewById(R.id.txt_product_amount);
            txt_product_share_amount=itemView.findViewById(R.id.txt_product_share_amount);
            txt_product_loss=itemView.findViewById(R.id.txt_product_loss);
            txt_product_loss_weight=itemView.findViewById(R.id.txt_product_loss_weight);

            img_product=itemView.findViewById(R.id.img_product);


        }
    }
}
