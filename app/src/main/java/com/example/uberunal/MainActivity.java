package com.example.uberunal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberunal.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressLogin);

        SharedPreferences usuario_preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        String celular =  usuario_preferences.getString("celular","");
        String password =  usuario_preferences.getString("password","");

        if(celular.isEmpty()){
            Intent login = new Intent(this,LoginActivity.class );
            startActivity(login);
        } else {
            Intent login = new Intent(this,PantallaPrincipal.class );
            login.putExtra("celular",celular);
            startActivity(login);
        }
    }
    public void x() {

    }
}