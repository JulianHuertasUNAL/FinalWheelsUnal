package com.example.uberunal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout textInputNombre;
    private TextInputLayout textInputCelular;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputNombre = (TextInputLayout)findViewById(R.id.text_input_nombre);
        textInputCelular = (TextInputLayout)findViewById(R.id.text_input_celular);
        textInputPassword = (TextInputLayout)findViewById(R.id.text_input_contraseña);
        textInputPassword2    = (TextInputLayout)findViewById(R.id.text_input_verificarContraseña);
    }

    public void registro (View view){
        String nombre = textInputNombre.getEditText().getText().toString().trim();
        String celular = textInputCelular.getEditText().getText().toString().trim();
        String contraseña = textInputPassword.getEditText().getText().toString().trim();
        String contraseña2 = textInputPassword2.getEditText().getText().toString().trim();

        boolean verificacionDatos = true;

        if(nombre.isEmpty()){
            textInputNombre.setError("Ingrese un nombre.");
            verificacionDatos = false;
        } else {
            textInputNombre.setError(null);
            if(nombre.length()<10){
                textInputNombre.setError("El nombre debe tener mas de 10 digitos.");
                verificacionDatos = false;
            } else {
                textInputNombre.setError(null);
            }


        }
        if(celular.isEmpty()){
            textInputCelular.setError("Ingrese un numero de celular.");
            verificacionDatos = false;
        } else {
            textInputCelular.setError(null);
            if(celular.length()<=9){
                textInputCelular.setError("Ingrese un numero valido.");
                verificacionDatos = false;
            } else {
                textInputCelular.setError(null);
            }
        }

        if(contraseña.isEmpty()){
            textInputPassword.setError("Ingrese una contraseña.");
            verificacionDatos = false;
        } else {
            textInputPassword.setError(null);
            if (contraseña2.isEmpty()){
                textInputPassword2.setError("Ingrese una contraseña.");
                verificacionDatos = false;
            } else{
                textInputPassword2.setError(null);
                if(!contraseña.equals(contraseña2)){
                    textInputPassword2.setError("Las contraseñas no son iguales.");
                    verificacionDatos = false;
                } else{
                    textInputPassword2.setError(null);
                }
            }
        }
        if(verificacionDatos){

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wheelsUnal", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();



            boolean InsertFunciona = false;
            try{
                Cursor fila = BaseDeDatos.rawQuery
                        ("select nombre from usuario where celular =" + celular,null);
                if(fila.moveToFirst()) {
                    textInputCelular.setError("Celular registrado");
                } else {
                    ContentValues registro = new ContentValues();
                    registro.put("nombre", nombre);
                    registro.put("celular", celular);
                    registro.put("contraseña", contraseña);
                    registro.put("estado_conductor", false);
                    try {
                        BaseDeDatos.insert("usuario", null, registro);
                    } catch(Exception e) {
                        Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
                    }


                   InsertFunciona= true;
                }

            } catch (Exception e) {
                Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
            }
            BaseDeDatos.close();
            if(InsertFunciona){
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
            }

        }
    }
    public void volver (View vie){
        Intent login = new Intent( this,LoginActivity.class);
        startActivity(login);

    }
}