package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.HomeMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class FragmentHomeMenuPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeMenu> homeMenuList = new ArrayList<>();
    private Context context;
    private String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    private int[] yAxisData = {50, 20, 15, 30};

    public FragmentHomeMenuPageAdapter(List<HomeMenu> homeMenuList, Context context) {
        this.homeMenuList = homeMenuList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_list_row, viewGroup, false);
        return new FragmentHomeMenuListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        HomeMenu homeMenu = homeMenuList.get(position);
        ((FragmentHomeMenuListViewHolder) viewHolder).txtFirstText.setText(homeMenu.getFirstText());
        ((FragmentHomeMenuListViewHolder) viewHolder).txtSecondText.setText(homeMenu.getSecondText());
        ((FragmentHomeMenuListViewHolder) viewHolder).imgMenuImage.setImageResource(homeMenu.getImgMenuImage());

        ((FragmentHomeMenuListViewHolder) viewHolder).lineChartViewMenuHomeList.setLineChartData(getLineChartData());

    }

    private LineChartData getLineChartData() {
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#24A2C1"));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, getArr()));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        return data;
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

    @Override
    public int getItemCount() {
        return homeMenuList == null ? 0 : homeMenuList.size();
    }

    public class FragmentHomeMenuListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuImage;
        TextView txtFirstText, txtSecondText;
        LineChartView lineChartViewMenuHomeList;

        public FragmentHomeMenuListViewHolder(View view) {
            super(view);

            imgMenuImage = view.findViewById(R.id.imgMenuImage);
            txtFirstText = view.findViewById(R.id.txtFirstText);
            txtSecondText = view.findViewById(R.id.txtSecondText);
            lineChartViewMenuHomeList = view.findViewById(R.id.lineChartViewMenuHomeList);
        }

    }
}
