package com.example.uberunal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroConductor extends AppCompatActivity {
    EditText tipoVehiculo;
    EditText ModeloVehiculo;
    EditText PlacaVehiculo;
    EditText NumeroCedula;

    public void publicarruta(View view){
        Intent i = new Intent(this, TipoRuta.class);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_conductor);
        tipoVehiculo = findViewById(R.id.tipo_vehiculo);
        ModeloVehiculo = findViewById(R.id.modelo);
        PlacaVehiculo = findViewById(R.id.placa);
        NumeroCedula = findViewById(R.id.cedula);
    }
    public void BotonRegistrarse(View view){
        String Vehiculo = tipoVehiculo.getText().toString();
        String Modelo = ModeloVehiculo.getText().toString();
        String Placa = PlacaVehiculo.getText().toString();
        String Cedula = NumeroCedula.getText().toString();

        if(Vehiculo.isEmpty() || Modelo.isEmpty() || Placa.isEmpty() || Cedula.isEmpty()){
            Toast.makeText(this,"Ingrese todos los datos",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Datos guardados correctamente"+Vehiculo+Modelo+Placa+Cedula, Toast.LENGTH_SHORT).show();
        }//Condicional

    }//Boton registrarse
}
