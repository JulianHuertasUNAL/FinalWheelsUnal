package com.example.uberunal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PublicarRuta1 extends AppCompatActivity {
    private EditText et_Placa;
    private EditText et_Origen;
    private EditText et_Dias;
    private EditText et_Salida;
    private EditText et_Cupos;
    private EditText et_Celular;

    public void publicarruta(View view){
        Intent i = new Intent(this, TipoRuta.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_ruta1);
        et_Placa = findViewById(R.id.txt_placa);
        et_Origen = findViewById(R.id.txt_origen);
        et_Dias = findViewById(R.id.txt_dias);
        et_Salida = findViewById((R.id.txt_hora));
        et_Cupos = findViewById(R.id.txt_cupos);
        et_Celular = findViewById(R.id.txt_contacto);
    }

    public void guardarRuta(View view){

        BaseSQLite admin = new BaseSQLite(this, "administracion", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String Placa = et_Placa.getText().toString();
        String Origen = et_Origen.getText().toString();
        String Dia = et_Dias.getText().toString();
        String HoraSalida = et_Salida.getText().toString();
        String NumCupos = et_Cupos.getText().toString();


        String Contacto = et_Celular.getText().toString();

        if(Placa.isEmpty() || Origen.isEmpty() || Dia.isEmpty() || HoraSalida.isEmpty() || NumCupos.isEmpty() || Contacto.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();

        }
        else{
            ContentValues registro = new ContentValues();
            registro.put("Placa", Placa);
            registro.put("Origen", Origen);
            registro.put("Dia", Dia);
            registro.put("HoraSalida", HoraSalida);
            registro.put("NumCupos", NumCupos);
            registro.put("Contacto", Contacto);

            BasedeDatos.insert("RutaTipoA", null, registro);
            BasedeDatos.close();
            et_Placa.setText("");
            et_Origen.setText("");
            et_Dias.setText("");
            et_Salida.setText("");
            et_Cupos.setText("");
            et_Celular.setText("");

            Toast.makeText(this, "Datos guardados de manera exitosa", Toast.LENGTH_SHORT).show();

        }
    }//PublicarRuta

    public void consultarRuta(View view){
        BaseSQLite admin = new BaseSQLite(this, "administracion", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();
        String Placa = et_Placa.getText().toString();
        if(Placa.isEmpty()){Toast.makeText(this, "Complete el campo placa", Toast.LENGTH_SHORT).show();}
        else {
            Cursor fila = BasedeDatos.rawQuery
                    ("select Origen, Dia, HoraSalida, NumCupos, Contacto from administracion where Placa = "+ Placa, null);
            if(fila.moveToFirst()){
                et_Origen.setText(fila.getString(0));
                et_Dias.setText(fila.getString(1));
                et_Salida.setText(fila.getString(2));
                et_Cupos.setText(fila.getString(3));
                et_Celular.setText(fila.getString(4));
                BasedeDatos.close();
            }else{
                Toast.makeText(this, "No se ha encontrado ninguna ruta", Toast.LENGTH_SHORT).show();
                BasedeDatos.close();
            }
        }
    }//ConsultarRuta
    public void modificarRuta(View view){
        Toast.makeText(this, "Ruta modificada con éxito", Toast.LENGTH_SHORT).show();
        et_Placa.setText("");
        et_Origen.setText("");
        et_Dias.setText("");
        et_Salida.setText("");
        et_Cupos.setText("");
        et_Celular.setText("");
    }
    public void EliminarRuta(View view){
        Toast.makeText(this, "La Ruta ha sido eliminada", Toast.LENGTH_SHORT).show();
        et_Placa.setText("");
        et_Origen.setText("");
        et_Dias.setText("");
        et_Salida.setText("");
        et_Cupos.setText("");
        et_Celular.setText("");
    }

}