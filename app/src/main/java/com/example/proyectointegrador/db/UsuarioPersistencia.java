package com.example.proyectointegrador.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectointegrador.model.Usuario;

public class UsuarioPersistencia {
    private Context context;
    private UsuarioSQLiteHelper ush;

    public UsuarioPersistencia(Context context, UsuarioSQLiteHelper ush) {
        this.context = context;
        this.ush = new UsuarioSQLiteHelper(context);
    }

    public SQLiteDatabase openReadable () { return ush.getReadableDatabase();}
    public SQLiteDatabase openWritable () { return ush.getWritableDatabase();}
    public void close (SQLiteDatabase database) { database.close();}

    public long insertarUsuarios (Usuario usuario) {
        SQLiteDatabase database = openWritable();
        database.beginTransaction();

        ContentValues usuarioValues = new ContentValues();
        usuarioValues.put(UsuarioContract.UsuarioEntry.COLUMN_NAME_APE, usuario.getNomApe());
        usuarioValues.put(UsuarioContract.UsuarioEntry.COLUMN_USUARIO, usuario.getUsuario());
        usuarioValues.put(UsuarioContract.UsuarioEntry.COLUMN_EMAIL, usuario.getEmail());
        usuarioValues.put(UsuarioContract.UsuarioEntry.COLUMN_PASSWORD, usuario.getEmail());
        usuarioValues.put(UsuarioContract.UsuarioEntry.COLUMN_CONFIRM_PASSWORD, usuario.getConfirmPass());

        long id = database.insert(UsuarioContract.UsuarioEntry.TABLE_NAME, null, usuarioValues);

        if (id != -1){
            database.setTransactionSuccessful();
        }

        database.endTransaction();
        close(database);

        return id;
    }

    public Usuario leerUsuario (long idUsuarios) {
        Usuario usuarios = null;
        SQLiteDatabase database = openReadable();

        String query = "SELECT "
                + UsuarioContract.UsuarioEntry.COLUMN_ID +
                ", " + UsuarioContract.UsuarioEntry.COLUMN_NAME_APE +
                ", " + UsuarioContract.UsuarioEntry.COLUMN_USUARIO +
                ", " + UsuarioContract.UsuarioEntry.COLUMN_EMAIL +
                ", " + UsuarioContract.UsuarioEntry.COLUMN_PASSWORD +
                ", " + UsuarioContract.UsuarioEntry.COLUMN_CONFIRM_PASSWORD + "FROM " + UsuarioContract.UsuarioEntry.TABLE_NAME
                + " WHERE "
                + UsuarioContract.UsuarioEntry.COLUMN_ID + " = " + idUsuarios;

        Cursor cursor = database.rawQuery(query, null);

        long id;
        String nomApe;
        String usuario;
        String email;
        String password;
        String confirmPassword;

        if (cursor.moveToFirst()){
            id = cursor.getLong(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_ID));
            nomApe = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_NAME_APE));
            usuario = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_USUARIO));
            email = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_EMAIL));
            password = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_PASSWORD));
            confirmPassword = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.COLUMN_CONFIRM_PASSWORD));

            usuarios = new Usuario(nomApe, usuario, email, password, confirmPassword);
            usuarios.setId(id);
        }
        return usuarios;
    }

    public void borrarUsuario (long idUsuarios) {
        SQLiteDatabase database = openWritable();
        database.beginTransaction();

        String [] whereArgs = {String.valueOf(idUsuarios)};
    }
}
