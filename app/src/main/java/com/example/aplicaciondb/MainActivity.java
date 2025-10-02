package com.example.aplicaciondb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicaciondb.database.DbHelper;
import com.example.aplicaciondb.database.UsuarioContract;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    private ListView listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DbHelper(this);
        listaUsuarios = findViewById(R.id.ListaID);
        cargarDatos();
    }

    private void cargarDatos(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                UsuarioContract.UsuarioEntry.COLUMN_ID,
                UsuarioContract.UsuarioEntry.COLUMN_NAME,
                UsuarioContract.UsuarioEntry.COLUMN_APELLIDO
        };

        Cursor cursor = db.query(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );


        String[] fromColumns = {
                UsuarioContract.UsuarioEntry.COLUMN_NAME,
                UsuarioContract.UsuarioEntry.COLUMN_APELLIDO
        };

        int[] LosViews = {
                R.id.textoObtenerNombre,
                R.id.textoObtenerApellido
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.activity_lista_usuarios,
                cursor,
                fromColumns,
                LosViews,
                0
        );

        listaUsuarios.setAdapter(adapter);
    }
}