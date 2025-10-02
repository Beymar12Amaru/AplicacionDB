package com.example.aplicaciondb.database;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASSE_VERSION = 1;
    public static final String DATABASE_NAME = "DbListas";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UsuarioContract.UsuarioEntry.TABLE_NAME + " (" +
                    UsuarioContract.UsuarioEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    UsuarioContract.UsuarioEntry.COLUMN_NAME + " TEXT, " +
                    UsuarioContract.UsuarioEntry.COLUMN_APELLIDO + " TEXT, " +
                    UsuarioContract.UsuarioEntry.COLUMN_NAME_USUARIO + " TEXT, " +
                    UsuarioContract.UsuarioEntry.COLUMN_CORREO + " TEXT, " +
                    UsuarioContract.UsuarioEntry.COLUMN_PASSWORD + " TEXT)";


    public DbHelper (Context context){
        super(context,DATABASE_NAME, null, DATABASSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioContract.UsuarioEntry.TABLE_NAME);
        onCreate(db);
    }

}
