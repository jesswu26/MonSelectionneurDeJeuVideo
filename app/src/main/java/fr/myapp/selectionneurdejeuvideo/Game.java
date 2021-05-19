package fr.myapp.selectionneurdejeuvideo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import org.json.JSONObject;

import static fr.myapp.selectionneurdejeuvideo.Helpers.randomGenerator;

public class Game extends MainActivity {
    TextView gameTitle;
    ImageView gameView;
    TextView gameDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        toolbar=findViewById(R.id.navToolbar);
//        setSupportActionBar(toolbar);
        gameTitle = findViewById(R.id.id_gametitle_jeupropose);
        gameView = findViewById(R.id.id_imageView);
        gameDescription = findViewById(R.id.id_descriptiongame);

        Integer number = getIntent().getIntExtra("randomNumber", 0);
        HttpClient client = new HttpClient("https://api.rawg.io/api/games/"+ number +"?key=de9fa738d91442bfb81dfd7973786208");

        client.start();
        try {
            client.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = client.getResponse();
        Log.println(Log.DEBUG,"Game",result);

        try {
            JSONObject json = new JSONObject(result);
            String nom = json.getString("name");
            String image = json.getString("background_image");
            gameTitle.setText(nom);
            gameDescription.setText(json.getString("description_raw"));
            Picasso.get().load(image).into(gameView);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
//    public void goToGameViewRandom(View view) {
//        Intent i = (new Intent(this, RandomActivity.class));
//        i.putExtra("randomNumber", randomGenerator(0,534700));
//        startActivity(i);
//    }

//    public void goToForm(View view) {
//        Intent i = (new Intent(this, FormActivity.class));
//        startActivity(i);
//    }
}