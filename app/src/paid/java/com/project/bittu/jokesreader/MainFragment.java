package com.project.bittu.jokesreader;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bittu.myapplication.backend.myApi.MyApi;
import com.example.bittu.myapplication.backend.myApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.project.bittu.jokesreader.R;

import java.io.IOException;
import java.util.List;


public class MainFragment extends Fragment {

    String type;
    Button button;
    FrameLayout frameLayout;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        type = "PAID";

        frameLayout = (FrameLayout)view.findViewById(R.id.loadingContainer);
        frameLayout.setVisibility(View.GONE);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        button  = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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



}
