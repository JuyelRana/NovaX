package com.dreamfactory.novax.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.PortfoliosAdapter;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuPortfoiloFragment extends Fragment {

    private RecyclerView recyclerViewMenuHomePorfolios;
    private PortfoliosAdapter homeMenuPorfoliosPageAdapter;
    private List<Watchlist> homeMenuPorfoliosList = new ArrayList<>();

    private LinearLayout llMenuPortfoiloAll, llMenuPortfoiloHKD, llMenuPortfoiloUSD;
    private TextView txtFirstPercentage, txtSecondPercentage;
    private ProgressBar progressBarMenuPortfoiloRVS, progressBarMenuPortfoiloDiversification;

    private View viewMenuAll, viewMenuHKD, viewMenuUSD;

    //Handle ProgressBar
    private int progress = 0;
    private Handler handler = new Handler();

    public MenuPortfoiloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_portfoilo, container, false);
        recyclerViewMenuHomePorfolios = view.findViewById(R.id.portfoliosRecycler);
        recyclerViewMenuHomePorfolios.setHasFixedSize(false);
        recyclerViewMenuHomePorfolios.setLayoutManager(new LinearLayoutManager(getContext()));

        llMenuPortfoiloAll = view.findViewById(R.id.llMenuPortfoiloAll);
        llMenuPortfoiloHKD = view.findViewById(R.id.llMenuPortfoiloHKD);
        llMenuPortfoiloUSD = view.findViewById(R.id.llMenuPortfoiloUSD);
        viewMenuAll = view.findViewById(R.id.viewMenuAll);
        viewMenuHKD = view.findViewById(R.id.viewMenuHKD);
        viewMenuUSD = view.findViewById(R.id.viewMenuUSD);

        txtFirstPercentage = view.findViewById(R.id.txtFirstPercentage);
        txtSecondPercentage = view.findViewById(R.id.txtSecondPercentage);

        progressBarMenuPortfoiloRVS = view.findViewById(R.id.progressBarMenuPortfoiloRVS);
        progressBarMenuPortfoiloDiversification = view.findViewById(R.id.progressBarMenuPortfoiloDiversification);


        implementationRecyclerViewMenuHome();

        implementationProgressBarMenuPortfoiloRVS();
        implementationProgressBarMenuPortfoiloDiversification();

        implementationllMenuPortfoiloAll();
        implementationllMenuPortfoiloHKD();
        implementationllMenuPortfoiloUSD();

        firstCall();

        return view;
    }

    private void firstCall() {
        viewMenuAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        viewMenuHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
        viewMenuUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
    }

    private void implementationProgressBarMenuPortfoiloDiversification() {

        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarMenuPortfoiloDiversification.setProgress(progress);
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void implementationProgressBarMenuPortfoiloRVS() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarMenuPortfoiloRVS.setProgress(progress);
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void implementationllMenuPortfoiloUSD() {
        llMenuPortfoiloUSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMenuAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                viewMenuHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                viewMenuUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

                txtFirstPercentage.setText("-13.62%");
                txtSecondPercentage.setText("08");

                implementationProgressBarMenuPortfoiloDiversification();
                implementationProgressBarMenuPortfoiloRVS();
            }
        });
    }

    private void implementationllMenuPortfoiloHKD() {
        llMenuPortfoiloHKD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMenuAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                viewMenuHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                viewMenuUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                txtFirstPercentage.setText("-18.60%");
                txtSecondPercentage.setText("11");

                implementationProgressBarMenuPortfoiloDiversification();
                implementationProgressBarMenuPortfoiloRVS();
            }
        });
    }

    private void implementationllMenuPortfoiloAll() {
        llMenuPortfoiloAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewMenuAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                viewMenuHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                viewMenuUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                txtFirstPercentage.setText("-28.90%");
                txtSecondPercentage.setText("05");

                implementationProgressBarMenuPortfoiloDiversification();
                implementationProgressBarMenuPortfoiloRVS();
            }
        });
    }

    private void implementationRecyclerViewMenuHome() {
        homeMenuPorfoliosList.clear();
        homeMenuPorfoliosList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        homeMenuPorfoliosList.add(new Watchlist(R.drawable.icon_facebook, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        homeMenuPorfoliosPageAdapter = new PortfoliosAdapter(homeMenuPorfoliosList, getContext());
        recyclerViewMenuHomePorfolios.setAdapter(homeMenuPorfoliosPageAdapter);
    }

    public int getProgressData() {
        return new Random().nextInt(100) + 1;
    }

}
