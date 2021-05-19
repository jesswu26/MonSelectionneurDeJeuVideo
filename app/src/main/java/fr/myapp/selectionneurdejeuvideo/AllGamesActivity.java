package fr.myapp.selectionneurdejeuvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


public class AllGamesActivity extends AppCompatActivity {
    SearchView gameResearch;
    TextView gameTitle;
    ImageView gameView;
    TextView gameDescription;
    String search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbar);
        gameTitle = findViewById(R.id.id_game_title);
        gameDescription = findViewById(R.id.id_game_description);
        gameView = findViewById(R.id.id_game_image);
        gameResearch = findViewById(R.id.id_game_research);

        gameResearch.getQuery().toString();
        Log.println(Log.DEBUG, "Game", String.valueOf(gameResearch));

        searchedGame();

    }
    public void searchedGame(){
        gameResearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(gameResearch != null){
                    HttpClient client = new HttpClient("https://api.rawg.io/api/games/" + query + "?key=de9fa738d91442bfb81dfd7973786208");
                    Log.println(Log.DEBUG, "Game", String.valueOf(search));
                    client.start();                     // commence une connexion avec l'url indiqué
                    try {                               //on essaie de joindre le serveur
                        client.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String result = client.getResponse();
                    Log.println(Log.DEBUG, "Game", result);
                    try {
                        JSONObject json = new JSONObject(result);
                        String nom = json.getString("name");
                        String image = json.getString("background_image");
                        gameTitle.setText(nom);
                        gameDescription.setText(json.getString("description"));
                        Picasso.get().load(image).into(gameView);
                    } catch (
                            JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(AllGamesActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
//
//    SearchView searchView ;
//    TextView gameTitle;
//    ImageView gameView;
//    TextView gameDescription;
//
//        String getTextFromSearch = null;
//        searchView = findViewById(R.id.id_game_research);
//
//        gameTitle = findViewById(R.id.id_game_title);
//        gameDescription = findViewById(R.id.id_game_description);
//        gameView = findViewById(R.id.id_game_image);
//
//        searchView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Toast.makeText(Searchbar.this, keyCode, Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
//
////        sendToApi() {}
//
////        sendResultToMyLibrary() {}
//
////        sendResultToAllGamesActivity() {}
//
//                //get texte écrit
//                //intègre dans requête API
//                //affiche résultat
//    }
