package com.example.proyectointegrador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "USUARIOS_DB";

    static final int DATABASE_VERSION = 1;

    public final String CREATE_TABLE_USUARIOS = "CREATE TABLE " + UsuarioContract.UsuarioEntry.TABLE_NAME + "(" +
            UsuarioContract.UsuarioEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            UsuarioContract.UsuarioEntry.COLUMN_NAME_APE + " TEXT NOT NULL, " +
            UsuarioContract.UsuarioEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
            UsuarioContract.UsuarioEntry.COLUMN_USUARIO + " TEXT NOT NULL, " +
            UsuarioContract.UsuarioEntry.COLUMN_PASSWORD + " TEXT NOT NULL, " +
            UsuarioContract.UsuarioEntry.COLUMN_CONFIRM_PASSWORD + " TEXT NOT NULL, ";

    public UsuarioSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioContract.UsuarioEntry.TABLE_NAME);
        onCreate(db);
    }
}
