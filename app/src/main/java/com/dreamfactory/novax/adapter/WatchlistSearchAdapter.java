package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Watchlist> watchlistsSearch=new ArrayList<>();
    Context mcontext;
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    public WatchlistSearchAdapter(List<Watchlist> watchlists, Context mcontext) {
        this.watchlistsSearch = watchlists;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.watchlist_search_single_row_design, viewGroup, false);
        return new WatchlistViewHolder(view);
    }
    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(watchlistsSearch.get(position).getType())) {
            return USER_TYPE;
        } else {
            return HEADER_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Watchlist list = watchlistsSearch.get(position);
        ((WatchlistViewHolder) viewHolder).txt_product_name.setText(list.getTxt_product_name());
        ((WatchlistViewHolder) viewHolder).txt_product_price.setText(list.getTxt_product_price());
        ((WatchlistViewHolder) viewHolder).txt_product_percentage.setText(list.getTxt_product_percentage());
        ((WatchlistViewHolder) viewHolder).txt_product_amount.setText(list.getTxt_product_amount());
        ((WatchlistViewHolder) viewHolder).txt_product_share_amount.setText(list.getTxt_product_share_amount());
        ((WatchlistViewHolder) viewHolder).img_product.setImageResource(list.getImg_product());
        int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((WatchlistViewHolder) viewHolder).img_toggle_add.setImageResource(R.drawable.icon_adding);
        } else {
            ((WatchlistViewHolder) viewHolder).img_toggle_add.setImageResource(R.drawable.icon_tick);
        }

    }

    @Override
    public int getItemCount() {
        return watchlistsSearch == null ? 0 : watchlistsSearch.size();
    }

    public class WatchlistViewHolder extends RecyclerView.ViewHolder{

         ImageView img_product,img_toggle_add;
         TextView txt_product_name,txt_product_price,txt_product_percentage,txt_product_amount,txt_product_share_amount;

        public WatchlistViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_product_name=itemView.findViewById(R.id.txt_product_name);
            txt_product_price=itemView.findViewById(R.id.txt_product_price);
            txt_product_percentage=itemView.findViewById(R.id.txt_product_percentage);
            txt_product_amount=itemView.findViewById(R.id.txt_product_amount);
            txt_product_share_amount=itemView.findViewById(R.id.txt_product_share_amount);


            img_product=itemView.findViewById(R.id.img_product);
            img_toggle_add=itemView.findViewById(R.id.img_toggle_add);

            img_toggle_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
