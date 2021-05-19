package fr.myapp.selectionneurdejeuvideo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
//
//    public Button cFacebook;
//    public Button cGoogle;
//    public Button cConnexion;
//    public TextView cEmail;
//    public TextView cPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
}
//
//        cFacebook = findViewById(R.id.via_facebook);
//        cGoogle = findViewById(R.id.via_google);
//        cConnexion = findViewById(R.id.btn_se_connecter);
//        cEmail = findViewById(R.id.editTextTextPassword);
//        cPassword = findViewById(R.id.editTextTextPassword);

//        cConnexion.setEnabled(false);
//        cEmail.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            cConnexion.setEnabled(s.toString().length() !=0);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });





//        cConnexion.setOnClickListener(v -> {
//            Intent menuActivity = new Intent(HomeActivity.this, MenuActivity.class);
//             startActivity(menuActivity);
//        });

