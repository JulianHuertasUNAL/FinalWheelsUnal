package com.example.uberunal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberunal.ui.home.HomeFragment;

public class AccountActivity extends AppCompatActivity {

    private TextView textViewNombre,textViewConductor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textViewNombre = (TextView)findViewById(R.id.textNombre);
        textViewConductor = (TextView)findViewById(R.id.textConductor);
        String celular = getIntent().getStringExtra("celular");


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wheelsUnal", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        try {
            Cursor fila = BaseDeDatos.rawQuery
                    ("select nombre, estado_conductor from usuario where celular ="+ celular, null);
            if (fila.moveToFirst()) {
                textViewNombre.setText(fila.getString(0));
                textViewConductor.setText(fila.getString(1));
            } else {
               // Toast.makeText(this,"Error al cargar los datos.",Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    public void volver(View view){
        Intent principal = new Intent(this, PantallaPrincipal.class);
        startActivity(principal);
    }
}