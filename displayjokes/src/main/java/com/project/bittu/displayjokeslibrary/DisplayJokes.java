package com.project.bittu.displayjokeslibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayJokes extends AppCompatActivity {

    String json;
    ArrayAdapter<String>  arrayAdapter;
    ArrayList<String> jokes;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        listView = (ListView)findViewById(R.id.listView);
        jokes = new ArrayList<>();

        json = getIntent().getStringExtra("Jokes");

        getJokes();

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.jokelistitemview, jokes);
        listView.setAdapter(arrayAdapter);
    }

    public void getJokes(){
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jokes.add(jsonObject.getString("joke"));
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}
