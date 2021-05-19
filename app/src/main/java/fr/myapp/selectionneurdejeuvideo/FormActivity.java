package fr.myapp.selectionneurdejeuvideo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

import static fr.myapp.selectionneurdejeuvideo.Helpers.randomGenerator;

public class FormActivity extends MainActivity {

    private Button findGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
//        toolbar=findViewById(R.id.navToolbar);
//      setSupportActionBar(toolbar);
    }

    ArrayList<String> category = new ArrayList<>();

    //https://api.rawg.io/api/genres

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.cb_independant:
                if (checked) {
                    category.add("51"/*indie*/);
                    break;
                }
                category.remove("51");
                break;
            case R.id.cb_strategy:
                if (checked) {
                    category.add("10"/*strategy*/);
                    break;
                }
                category.remove("10");
                break;
            case R.id.cb_management:
                if (checked) {
                    category.add("14"/*simulation*/);
                    break;
                }
                category.remove("14");
                break;
            case R.id.cb_action:
                if (checked) {
                    category.add("4"/*action*/);
                    break;
                }
                category.remove("4");
                break;
            case R.id.cb_rpg:
                if (checked) {
                    category.add("5"/*rpg*/);
                    break;
                }
                category.remove("5");
                break;
            case R.id.cb_shooter:
                if (checked) {
                    category.add("2"/*shooter*/);
                    break;
                }
                category.remove("2");
                break;
            case R.id.cb_adventure:
                if (checked) {
                    category.add("3"/*adventure*/);
                    break;
                }
                category.remove("3");
                break;
            case R.id.cb_race:
                if (checked) {
                    category.add("1"/*race*/);
                    break;
                }
                category.remove("1");
                break;

            case R.id.cb_sport:
                if (checked) {
                    category.add("15"/*sport*/);
                    break;
                }
                category.remove("15");
                break;

//            case R.id.cb_multiplayer:
//                if (checked) {
//                    category.add("multiplayer");
//                    break;
//                } {
//                    category.add("singleplayer");
//                break;
            //          }
            case R.id.cb_fighting:
                if (checked) {
                    category.add("6"/*sport*/);
                    break;
                }
                category.remove("6");
                break;
            case R.id.cb_puzzle:
                if (checked) {
                    category.add("7"/*sport*/);
                    break;
                }
                category.remove("7");
                break;
            case R.id.cb_arcade:
                if (checked) {
                    category.add("11"/*sport*/);
                    break;
                }
                category.remove("11");
                break;
            case R.id.cb_cards:
                if (checked) {
                    category.add("17"/*sport*/);
                    break;
                }
                category.remove("17");
                break;
            case R.id.cb_family:
                if (checked) {
                    category.add("19"/*sport*/);
                    break;
                }
                category.remove("19");
                break;
            case R.id.cb_boardGames:
                if (checked) {
                    category.add("28"/*sport*/);
                    break;
                }
                category.remove("28");
                break;
            case R.id.cb_educational:
                if (checked) {
                    category.add("34"/*sport*/);
                    break;
                }
                category.remove("34");
                break;
            case R.id.cb_casual:
                if (checked) {
                    category.add("40"/*sport*/);
                    break;
                }
                category.remove("40");
                break;
            case R.id.cb_mmo:
                if (checked) {
                    category.add("59"/*sport*/);
                    break;
                }
                category.remove("59");
                break;
            case R.id.cb_platformer:
                if (checked) {
                    category.add("83"/*platforme*/);
                    break;
                }
                category.remove("83");
                break;

        }
        Log.println(Log.DEBUG, "Category", category.toString());
    }


    public void onFindGameBtnClick() {
        findGameBtn = findViewById(R.id.id_findGameBtn);
        findGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.println(Log.DEBUG, "Category", category.toString());
            }
        });
    }

    public void goToGameView(View view) {
        Intent i = (new Intent(this, GameViewActivity.class));
        i.putExtra("Category", category);
        startActivity(i);
    }
}