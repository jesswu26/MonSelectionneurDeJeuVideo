package fr.myapp.selectionneurdejeuvideo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static fr.myapp.selectionneurdejeuvideo.Helpers.randomGenerator;

public class RandomActivity extends MainActivity {

    public Button btnToGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);


        btnToGame = findViewById(R.id.id_btn_to_a_game);

        btnToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(RandomActivity.this, Game.class);
                game.putExtra("randomNumber", randomGenerator(0, 534700));
                startActivity(game);
            }
        });

    }
}

//    public void goToGameRandom(View view) {
//        Intent i = new Intent(this, Game.class);
//        Log.d("Test", "Random = " + randomGenerator(0,534700));
//        i.putExtra("randomNumber", randomGenerator(0,534700));
//        startActivity(i);
//    }


//            Integer number = getIntent().getIntExtra("randomNumber", 0);
//            HttpClient client = new HttpClient("https://api.rawg.io/api/games/"+ number +"?key=de9fa738d91442bfb81dfd7973786208" );
//

