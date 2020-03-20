package com.example.proyectointegrador.db;

import android.provider.BaseColumns;

public class UsuarioContract {

    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String COLUMN_ID = BaseColumns._ID;

        public static final String COLUMN_NAME_APE = "NOMBRE Y APELLIDOS";
        public static final String COLUMN_USUARIO = "USUARIO";
        public static final String COLUMN_EMAIL = "EMAIL";
        public static final String COLUMN_PASSWORD = "PASSWORD";
        public static final String COLUMN_CONFIRM_PASSWORD = "CONFIRM PASSWORD";
        public static final String TABLE_NAME = "USUARIOS";
    }
}
