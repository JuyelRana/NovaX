package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.activity.SellMktOrder;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class SocialFollowersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Watchlist> socialFollowers = new ArrayList<>();
    Context mcontext;

    public SocialFollowersAdapter(List<Watchlist> socialFollowers, Context mcontext) {
        this.socialFollowers = socialFollowers;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.social_followers_single_row_design, viewGroup, false);
        return new SocialFollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Watchlist list = socialFollowers.get(position);
        ((SocialFollowersViewHolder) viewHolder).txt_product_name_social_follwer.setText(list.getTxt_product_name_social_follwer());
        ((SocialFollowersViewHolder) viewHolder).txt_product_Buy_amount.setText(list.getTxt_product_Buy_amount());
        ((SocialFollowersViewHolder) viewHolder).txt_product_SL_amount.setText(list.getTxt_product_SL_amount());
        ((SocialFollowersViewHolder) viewHolder).txt_product_exit_amount.setText(list.getTxt_product_exit_amount());
        ((SocialFollowersViewHolder) viewHolder).txt_product_quentity.setText(list.getTxt_product_quentity());

        ((SocialFollowersViewHolder) viewHolder).img_product_social_followers.setImageResource(list.getImg_product_social_followers());
    }

    @Override
    public int getItemCount() {
        return socialFollowers == null ? 0 : socialFollowers.size();
    }

    public class SocialFollowersViewHolder extends RecyclerView.ViewHolder {

        ImageView img_product_social_followers;
        TextView txt_product_name_social_follwer, txt_product_Buy_amount, txt_product_SL_amount, txt_product_exit_amount, txt_product_quentity;
        ImageView SLEdit, decriment_social_followers, increment_social_followers;
        Button btn_social_follers_sell;

        public SocialFollowersViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_product_name_social_follwer = itemView.findViewById(R.id.txt_product_name_social_follwer);
            txt_product_Buy_amount = itemView.findViewById(R.id.txt_product_Buy_amount);
            txt_product_SL_amount = itemView.findViewById(R.id.txt_product_SL_amount);
            txt_product_exit_amount = itemView.findViewById(R.id.txt_product_exit_amount);
            txt_product_quentity = itemView.findViewById(R.id.txt_product_quentity);

            img_product_social_followers = itemView.findViewById(R.id.img_product_social_followers);
            SLEdit = itemView.findViewById(R.id.SLEdit);
            decriment_social_followers = itemView.findViewById(R.id.decriment_social_followers);
            increment_social_followers = itemView.findViewById(R.id.increment_social_followers);
            btn_social_follers_sell = itemView.findViewById(R.id.btn_social_follers_sell);

            SLEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            decriment_social_followers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            increment_social_followers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            btn_social_follers_sell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mcontext.startActivity(new Intent(mcontext, SellMktOrder.class));
                }
            });


        }
    }
}
