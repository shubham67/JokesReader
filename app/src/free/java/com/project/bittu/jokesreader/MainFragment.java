package com.project.bittu.jokesreader;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.project.bittu.jokesreader.R;

import java.lang.Override;


public class MainFragment extends Fragment {


    String type;
    Button button;
    FrameLayout frameLayout;
    ProgressBar progressBar;
    AdView mAdView;
    InterstitialAd mInterstitial;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        type = "FREE";

        mInterstitial = new InterstitialAd(getActivity());
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);

        mAdView = (AdView)view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        frameLayout = (FrameLayout)view.findViewById(R.id.loadingContainer);
        frameLayout.setVisibility(View.GONE);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        button  = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitial.isLoaded()) {
                    mInterstitial.show();
                }
                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
                new FetchAsyncTask().execute(new Pair<Context, String>(getActivity(), type));
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        frameLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);
    }
}
