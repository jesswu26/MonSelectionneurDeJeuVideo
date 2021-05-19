package fr.myapp.selectionneurdejeuvideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static fr.myapp.selectionneurdejeuvideo.Helpers.randomGenerator;

public class MenuActivity extends AppCompatActivity {
   public Button mMesJeux;
   public Button mTrouverUnJeu;
   public Button mJeuAleatoire;
   public Button mTousLesJeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mMesJeux = findViewById(R.id.btn_jeux);
        mTrouverUnJeu = findViewById(R.id.btn_trouver_jeu);
        mJeuAleatoire = findViewById(R.id.btn_jeu_aleatoire);
        mTousLesJeux = findViewById(R.id.btn_ts_jeux);



        Integer number = getIntent().getIntExtra("randomNumber", 0);
        HttpClient client = new HttpClient("https://api.rawg.io/api/games/"+ number +"?key=de9fa738d91442bfb81dfd7973786208" );

        mTrouverUnJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formActivity = new Intent(MenuActivity.this, FormActivity.class);
                startActivity(formActivity);
            }
        });

        mTousLesJeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allGamesActivity = new Intent(MenuActivity.this, AllGamesActivity.class);
                startActivity(allGamesActivity);
            }
        });

        mJeuAleatoire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent randomActivity = new Intent(MenuActivity.this, RandomActivity.class);
                randomActivity.putExtra("randomNumber", randomGenerator(0,534700));
                startActivity(randomActivity);
            }
        });

        mMesJeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libraryActivity = new Intent(MenuActivity.this, LibraryActivity.class);
                startActivity(libraryActivity);
            }
        });
    }

}

