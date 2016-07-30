package com.project.bittu.jokesreader;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.bittu.myapplication.backend.myApi.MyApi;
import com.example.bittu.myapplication.backend.myApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.project.bittu.displayjokeslibrary.DisplayJokes;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bittu on 7/15/2016.
 */
class FetchAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
    String type;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokes-reader.appspot.com/_ah/api/");


            myApiService = builder.build();
        }

        context = params[0].first;
        type = params[0].second;

        try {
            List<Joke> jokes = myApiService.getJokes(type).execute().getItems();
            return jokes + "";
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, DisplayJokes.class);
        intent.putExtra("Jokes", "" + result);
        context.startActivity(intent);
    }
}