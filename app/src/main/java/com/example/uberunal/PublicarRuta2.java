package com.example.uberunal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PublicarRuta2 extends AppCompatActivity {
    EditText DireccionDestino;
    EditText Dias;
    EditText Salida;
    EditText CantidadCupos;
    EditText Celular;
    public void publicarruta(View view){
        Intent i = new Intent(this, TipoRuta.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_ruta2);
        DireccionDestino = findViewById(R.id.txt_origen);
        Dias = findViewById(R.id.txt_dias);
        Salida = findViewById((R.id.txt_hora));
        CantidadCupos = findViewById(R.id.txt_cupos);
        Celular = findViewById(R.id.txt_contacto);
    }
    public void BotonGuardarRuta2(View view){
        String Origen = DireccionDestino.getText().toString();
        String Dia = Dias.getText().toString();
        String HoraSalida = Salida.getText().toString();
        String NumCupos = CantidadCupos.getText().toString();
        //int Cupos = Integer.parseInt(NumCupos);

        String Contacto = Celular.getText().toString();

        if(Origen.isEmpty() || Dia.isEmpty() || HoraSalida.isEmpty() || NumCupos.isEmpty() || Contacto.isEmpty()){
            Toast.makeText(this,"Ingrese todos los datos",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}