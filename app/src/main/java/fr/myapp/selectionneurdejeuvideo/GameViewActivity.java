package fr.myapp.selectionneurdejeuvideo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static fr.myapp.selectionneurdejeuvideo.Helpers.randomGenerator;

public class GameViewActivity extends MainActivity {

    TextView gameTitle;
    ImageView gameView;
    TextView gameScore;
    TextView gameDescription;

    private RecyclerView recyclerView;
    private CardViewAdapter adapter;
    private ArrayList<ItemCardView> itemCardViewArrayList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
//        toolbar = findViewById(R.id.navToolbar);
//        setSupportActionBar(toolbar);

        gameTitle = findViewById(R.id.cv_title0);
        gameView = findViewById(R.id.cv_img);
        gameScore = findViewById(R.id.cv_note0);

        recyclerView = findViewById(R.id.id_listview);

        InitializeCardView();

        ArrayList<String> category = getIntent().getStringArrayListExtra("Category");

        String http1 = "https://api.rawg.io/api/games?genres=";
        String http2 = "&page_size=5&key=de9fa738d91442bfb81dfd7973786208";
        String genre = "";

        for (int i=0; i <category.size(); i++) {
            if (genre=="") {
                genre = category.get(i);
            } genre = genre + "," + category.get(i);
        }

        String url = http1+genre+http2;

        System.out.println(url);
//        HttpClient client = new HttpClient("https://api.rawg.io/api/games/"+ number +"?key=de9fa738d91442bfb81dfd7973786208");
        HttpClient client = new HttpClient(url);


        client.start();
        try {
            client.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = client.getResponse();
        Log.println(Log.DEBUG, "Game", result);

        try {
            JSONObject json = new JSONObject(result);
            JSONArray resultat = json.getJSONArray("results");
            Log.d("test", String.valueOf(resultat.length()));

            for (int i = 0; i < resultat.length(); i++) {
                JSONObject obj = resultat.getJSONObject(i);
                String title = obj.getString("name");
                String note = obj.getString("metacritic");
                String img = obj.getString("background_image");
                CreateDataForCards(img,title,note);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void InitializeCardView() {
        recyclerView = findViewById(R.id.id_recyclerviewItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemCardViewArrayList = new ArrayList<>();
        adapter = new CardViewAdapter(this, itemCardViewArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void CreateDataForCards(String img, String title, String score) {
        ItemCardView card = new ItemCardView(img,title,score);
        itemCardViewArrayList.add(card);
        adapter.notifyDataSetChanged();
    }

    public void goToGameViewRandom(View view) {
        Intent i = (new Intent(this, GameViewActivity.class));
        i.putExtra("randomNumber", randomGenerator(0,534700));
        startActivity(i);
    }

    public void goToForm(View view) {
        Intent i = (new Intent(this, FormActivity.class));
        startActivity(i);
    }
}