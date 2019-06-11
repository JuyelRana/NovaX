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

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.SocialRating;

import java.util.ArrayList;
import java.util.List;

public class SocialMyRatingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SocialRating> SocialMyRating = new ArrayList<>();
    Context mcontext;
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    public SocialMyRatingAdapter(List<SocialRating> SocialRating, Context mcontext) {
        this.SocialMyRating = SocialRating;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.social_my_rating_single_row, viewGroup, false);
        return new SocialRatingViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(SocialMyRating.get(position).getChecking())) {
            return USER_TYPE;
        } else {
            return HEADER_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SocialRating list = SocialMyRating.get(position);
        ((SocialRatingViewHolder) viewHolder).tradersName.setText(list.getTradersName());
        ((SocialRatingViewHolder) viewHolder).tradersRating.setText(list.getTradersRating());
        ((SocialRatingViewHolder) viewHolder).tradersImage.setImageResource(list.getTradersImage());
        int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((SocialRatingViewHolder) viewHolder).ratingSign.setImageResource(R.drawable.icon_green_arrow);
        } else {
            ((SocialRatingViewHolder) viewHolder).ratingSign.setImageResource(R.drawable.icon_red_arrow);
        }

    }

    @Override
    public int getItemCount() {
        return SocialMyRating == null ? 0 : SocialMyRating.size();
    }

    public class SocialRatingViewHolder extends RecyclerView.ViewHolder {

        ImageView tradersImage, ratingSign;
        TextView tradersName, tradersRating;

        public SocialRatingViewHolder(@NonNull View itemView) {
            super(itemView);

            tradersName = itemView.findViewById(R.id.tradersName);
            tradersRating = itemView.findViewById(R.id.tradersRating);
            tradersImage = itemView.findViewById(R.id.tradersImage);
            ratingSign = itemView.findViewById(R.id.ratingSign);


        }
    }
}
