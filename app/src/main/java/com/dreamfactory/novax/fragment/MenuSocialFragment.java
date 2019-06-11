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
import android.widget.SeekBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.SocialMyRatingAdapter;
import com.dreamfactory.novax.adapter.SocialStarRatingAdapter;
import com.dreamfactory.novax.model.SocialRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuSocialFragment extends Fragment {

    private LinearLayout llMyTradingTab, llRecentTab;
    private TextView txtMyTradingTab, txtRecentTab;

    private TextView txtCurrentRatingValue, txtFollowersValue, txtFollowingValue;

    private SeekBar seekBarMyTradingRecentTab;

    private TextView txtPercentageValue, txtZeroPercentage, txtThirtyPercentage;

    private LinearLayout llMyRatingTab, llStarTradersTab;

    private TextView txtMyRatingTab, txtStarTradersTab;

    //Handle ProgressBar
    private int progress = 0;
    private Handler handler = new Handler();

    private RecyclerView socialRecycler;
    private SocialStarRatingAdapter socialStarRatingAdapter;
    private SocialMyRatingAdapter socialMyRatingAdapter;
    private List<SocialRating> socialRatings = new ArrayList<>();

    public MenuSocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_social, container, false);

        llMyTradingTab = view.findViewById(R.id.llMyTradingTab);
        llRecentTab = view.findViewById(R.id.llRecentTab);
        txtMyTradingTab = view.findViewById(R.id.txtMyTradingTab);
        txtRecentTab = view.findViewById(R.id.txtRecentTab);
        socialRecycler = view.findViewById(R.id.socialRecycler);
        socialRecycler.setHasFixedSize(false);
        socialRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        txtCurrentRatingValue = view.findViewById(R.id.txtCurrentRatingValue);
        txtFollowersValue = view.findViewById(R.id.txtFollowersValue);
        txtFollowingValue = view.findViewById(R.id.txtFollowingValue);

        txtPercentageValue = view.findViewById(R.id.txtPercentageValue);
        txtZeroPercentage = view.findViewById(R.id.txtZeroPercentage);
        txtThirtyPercentage = view.findViewById(R.id.txtThirtyPercentage);

        txtMyRatingTab = view.findViewById(R.id.txtMyRatingTab);
        txtStarTradersTab = view.findViewById(R.id.txtStarTradersTab);

        seekBarMyTradingRecentTab = view.findViewById(R.id.seekBarMyTradingRecentTab);

        llMyRatingTab = view.findViewById(R.id.llMyRatingTab);
        llStarTradersTab = view.findViewById(R.id.llStarTradersTab);

        implementationllMyTradingTab();
        implementationllRecentTab();
        implementationseekBarMyTradingRecentTab();
        implementationllMyRatingTab();
        implementationllStarTradersTab();

        firstCall();

        return view;
    }

    private void firstCall() {
        llMyRatingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
        txtMyRatingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

        llStarTradersTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
        txtStarTradersTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

        llMyTradingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
        txtMyTradingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

        llRecentTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));

        //for recyclerview
        socialRatings.clear();
        socialRatings.add(new SocialRating(R.drawable.icon_profile, "Arthur Morgan", "34", ""));
        socialRatings.add(new SocialRating(R.drawable.icon_profile, "Jeremy Clarkson", "37", "0"));
        socialMyRatingAdapter = new SocialMyRatingAdapter(socialRatings, getContext());
        socialRecycler.setAdapter(socialMyRatingAdapter);
    }

    private void implementationllStarTradersTab() {
        llStarTradersTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                llStarTradersTab.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                llStarTradersTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_sharpe));
                txtStarTradersTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

                llMyRatingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_shape_white));
                txtMyRatingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                socialRatings.clear();
                socialRatings.add(new SocialRating(R.drawable.icon_profile, "Richard Hammond"));
                socialRatings.add(new SocialRating(R.drawable.icon_profile, "Harry Lincoln"));
                socialStarRatingAdapter = new SocialStarRatingAdapter(socialRatings, getContext());
                socialRecycler.setAdapter(socialStarRatingAdapter);


            }
        });
    }

    private void implementationllMyRatingTab() {
        llMyRatingTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMyRatingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
                txtMyRatingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

                llStarTradersTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
                txtStarTradersTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                socialRatings.clear();
                socialRatings.add(new SocialRating(R.drawable.icon_profile, "Arthur Morgan", "34", ""));
                socialRatings.add(new SocialRating(R.drawable.icon_profile, "Jeremy Clarkson", "37", "0"));
                socialMyRatingAdapter = new SocialMyRatingAdapter(socialRatings, getContext());
                socialRecycler.setAdapter(socialMyRatingAdapter);
            }
        });
    }

    private void implementationseekBarMyTradingRecentTab() {
        progress = 7;
        seekBarMyTradingRecentTab.setProgress(progress);
        txtPercentageValue.setText(progress + "%");
//        if (progress > 0) {
//            progress = 0;
//        }
//
//        new Thread(new Runnable() {
//            public void run() {
//                while (progress < getProgressData()) {
//                    progress += 1;
//                    handler.post(new Runnable() {
//                        public void run() {
//                            seekBarMyTradingRecentTab.setProgress(progress);
//                            txtPercentageValue.setText(progress + "%");
//                            //txtPercentageValue.setPadding(progress + 270, 0, 0, 0);
//                        }
//                    });
//                    try {
//                        // Sleep for 100 milliseconds to show the progress slowly.
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    private void implementationllRecentTab() {
        llRecentTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llRecentTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_sharpe));
                txtRecentTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

                llMyTradingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_shape_white));
                txtMyTradingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                txtCurrentRatingValue.setText("42");
                txtFollowersValue.setText("322");
                txtFollowingValue.setText("143");
            }
        });
    }

    private void implementationllMyTradingTab() {
        llMyTradingTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMyTradingTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
                txtMyTradingTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

                llRecentTab.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
                txtRecentTab.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                txtCurrentRatingValue.setText("45");
                txtFollowersValue.setText("423");
                txtFollowingValue.setText("156");
            }
        });
    }

    public int getProgressData() {
        return new Random().nextInt(30) + 1;
    }

}
