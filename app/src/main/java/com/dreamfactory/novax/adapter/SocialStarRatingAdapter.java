package com.dreamfactory.novax.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.activity.SocialFollowers;
import com.dreamfactory.novax.model.SocialRating;

import java.util.ArrayList;
import java.util.List;

public class SocialStarRatingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SocialRating> SocialStarRating = new ArrayList<>();
    Context mcontext;
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    public SocialStarRatingAdapter(List<SocialRating> SocialRating, Context mcontext) {
        this.SocialStarRating = SocialRating;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.social_star_rating_single_row, viewGroup, false);
        return new SocialStarRatingViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SocialRating list = SocialStarRating.get(position);
        ((SocialStarRatingViewHolder) viewHolder).startradersName.setText(list.getStartradersName());
        ((SocialStarRatingViewHolder) viewHolder).startradersImage.setImageResource(list.getStartradersImage());


    }

    @Override
    public int getItemCount() {
        return SocialStarRating == null ? 0 : SocialStarRating.size();
    }

    public class SocialStarRatingViewHolder extends RecyclerView.ViewHolder {

        ImageView startradersImage;
        TextView startradersName, btn_cancel,btn_continue,txt_followTrader_social_star;
        Dialog dialog;

        public SocialStarRatingViewHolder(@NonNull View itemView) {
            super(itemView);

            startradersImage = itemView.findViewById(R.id.startradersImage);
            startradersName = itemView.findViewById(R.id.startradersName);
            txt_followTrader_social_star = itemView.findViewById(R.id.txt_followTrader_social_star);
            //  btn_cancel=itemView.findViewById(R.id.btn_cancel);

//            txt_followTrader_social_star.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent=new Intent(mcontext, SocialFollowers.class);
//                    mcontext.startActivity(intent);
//                }
//            });

            txt_followTrader_social_star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog = new Dialog(mcontext);
                    dialog.setContentView(R.layout.social_star_traders_verify_dialog);
                    btn_cancel = dialog.findViewById(R.id.btn_cancel);
                    btn_continue = dialog.findViewById(R.id.btn_continue_welcomePage);
                    btn_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Toast.makeText(mcontext, "Dismiss", Toast.LENGTH_SHORT).show();
                        }
                    });
                    btn_continue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent=new Intent(mcontext, SocialFollowers.class);
                            mcontext.startActivity(intent);
                        }
                    });
                    dialog.show();
                }
            });



        }
    }
}
