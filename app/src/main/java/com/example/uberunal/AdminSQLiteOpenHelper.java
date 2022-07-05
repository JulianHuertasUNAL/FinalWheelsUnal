package com.example.uberunal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table   usuario(celular String primary key, nombre string, contraseña String, estado_conductor boolean)");
        BaseDeDatos.execSQL("create table vehiculo(placa String  primary key, tipo_vehiculo String, modelo String, celular_dueño String)");
        BaseDeDatos.execSQL("create table rutas(placa String primary key, direccion String, tipoRuta int, hora String, dia String, celularCreador String, tarifa String)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
