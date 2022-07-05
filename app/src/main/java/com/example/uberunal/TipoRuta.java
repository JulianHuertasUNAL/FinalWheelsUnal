package com.example.uberunal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TipoRuta extends AppCompatActivity {
    public void publicarruta1(View view){
        Intent i = new Intent(this, PublicarRuta1.class);
        startActivity(i);
    }
    public void publicarruta2(View view){
        Intent i = new Intent(this, PublicarRuta2.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_ruta);
    }
}