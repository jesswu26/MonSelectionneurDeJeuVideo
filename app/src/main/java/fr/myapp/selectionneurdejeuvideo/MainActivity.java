package fr.myapp.selectionneurdejeuvideo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        toolbar=findViewById(R.id.navToolbar);
//        setSupportActionBar(toolbar);
    }

    public void goToMenu(View view) {
        Intent i = (new Intent(this, MenuActivity.class));
        startActivity(i);
    }

    public void goToSearchbar(View view) {
        Intent i = (new Intent(this, SearchbarActivity.class));
        startActivity(i);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_findGame:
                startActivity(new Intent(this, FormActivity.class));
                break;
            case R.id.id_Logout:
                /*Toast.makeText(getApplicationContext(),  "LogOut", Toast.LENGTH_SHORT);*/
                startActivity(new Intent(this, LogOutActivity.class));
                break;
            case R.id.id_mylibrary:
                startActivity(new Intent(this, LibraryActivity.class));
                break;
            case R.id.id_parameters:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.id_randomgamemenu:
                startActivity(new Intent(this, RandomActivity.class));
                break;
        } return super.onOptionsItemSelected(item);
    }
}



