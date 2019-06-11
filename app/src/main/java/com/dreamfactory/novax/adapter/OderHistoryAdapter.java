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
import com.dreamfactory.novax.model.OrderHistoryList;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class OderHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<OrderHistoryList> orderHistoryLists=new ArrayList<>();
    Context mcontext;
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    public OderHistoryAdapter(List<OrderHistoryList> orderHistoryLists, Context mcontext) {
        this.orderHistoryLists = orderHistoryLists;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_history_single_row_design, viewGroup, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(orderHistoryLists.get(position).getType())) {
            return USER_TYPE;
        } else {
            return HEADER_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        OrderHistoryList list = orderHistoryLists.get(position);
        ((OrderHistoryViewHolder) viewHolder).txt_product_name_history_order.setText(list.getTxt_product_name_history_order());
        ((OrderHistoryViewHolder) viewHolder).txt_order_history_date.setText(list.getTxt_order_history_date());
        ((OrderHistoryViewHolder) viewHolder).txt_Direction.setText(list.getTxt_Direction());
        ((OrderHistoryViewHolder) viewHolder).txt_Type.setText(list.getTxt_Type());
        ((OrderHistoryViewHolder) viewHolder).txt_Quantity.setText(list.getTxt_Quantity());
        ((OrderHistoryViewHolder) viewHolder).txt_LimitPrice.setText(list.getTxt_LimitPrice());
        ((OrderHistoryViewHolder) viewHolder).txt_ExpiryDate.setText(list.getTxt_ExpiryDate());

        int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((OrderHistoryViewHolder) viewHolder).img_order_history.setImageResource(R.drawable.icon_cross_myorders);
        } else {
            ((OrderHistoryViewHolder) viewHolder).img_order_history.setImageResource(R.drawable.icon_okay_myorders);
        }

    }

    @Override
    public int getItemCount() {
        return orderHistoryLists == null ? 0 : orderHistoryLists.size();
    }

    public class OrderHistoryViewHolder extends RecyclerView.ViewHolder{

         ImageView img_order_history;
         TextView txt_product_name_history_order,txt_order_history_date,txt_Direction,txt_Type,txt_Quantity,txt_LimitPrice,txt_ExpiryDate;

        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_product_name_history_order=itemView.findViewById(R.id.txt_product_name_history_order);
            txt_order_history_date=itemView.findViewById(R.id.txt_order_history_date);
            txt_Direction=itemView.findViewById(R.id.txt_Direction);
            txt_Type=itemView.findViewById(R.id.txt_Type);
            txt_Quantity=itemView.findViewById(R.id.txt_Quantity);
            txt_LimitPrice=itemView.findViewById(R.id.txt_LimitPrice);
            txt_ExpiryDate=itemView.findViewById(R.id.txt_ExpiryDate);

            img_order_history=itemView.findViewById(R.id.img_order_history);


        }
    }
}
