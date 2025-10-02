package com.example.aplicaciondb.database;


public class UsuarioContract {
    private UsuarioContract(){}

    public static class UsuarioEntry{
        public static final String TABLE_NAME = "Usuarios";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "Nombre";
        public static final String COLUMN_APELLIDO = "Apellido";
        public static final String COLUMN_NAME_USUARIO = "NombreUsuario";
        public static final String COLUMN_CORREO = "Correo";
        public static final String COLUMN_PASSWORD = "Contraseña";

    }
}

