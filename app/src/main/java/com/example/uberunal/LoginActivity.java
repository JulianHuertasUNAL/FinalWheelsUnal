package com.example.uberunal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberunal.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputCelular;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputCelular = (TextInputLayout)findViewById(R.id.text_input_celular);
        textInputPassword= (TextInputLayout)findViewById(R.id.text_input_password);
    }
    public void login(View view){
        String celularUser = textInputCelular.getEditText().getText().toString().trim();
        String passwordUser = textInputPassword.getEditText().getText().toString().trim();

        boolean inputsCorrectos=true;
        if(celularUser.isEmpty()){
            textInputCelular.setError("Ingrese un numero celular");
            inputsCorrectos=false;
        } else {
            textInputCelular.setError(null);
        }

        if(passwordUser.isEmpty()){
            textInputPassword.setError("Ingrese una contraseña");
            inputsCorrectos=false;
        } else {
            textInputPassword.setError(null);
        }

        if(inputsCorrectos) {

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wheelsUnal", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            try {
                Cursor fila = BaseDeDatos.rawQuery
                        ("select contraseña from usuario where celular ="+ celularUser, null);
                if (fila.moveToFirst()) {

                    if(fila.getString(0).equals(passwordUser)){

                        SharedPreferences login_preferencias = getSharedPreferences("login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = login_preferencias.edit();
                        editor.putString("celular", celularUser);
                        editor.commit();
                        editor.putString("password", passwordUser);
                        editor.commit();

                        /////Codigo de envio
                        Intent i = new Intent(this, HomeFragment.class);
                        i.putExtra("celular",celularUser);
                        startActivity(i);
                    } else {
                        Toast.makeText(this,"Contraseña invalida",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this,"El numero no esta registrado",Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void Registro (View view){
        Intent registro = new Intent(this, RegisterActivity.class);
        startActivity(registro);
    }
}