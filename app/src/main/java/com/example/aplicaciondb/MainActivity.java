package com.example.aplicaciondb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicaciondb.database.DbHelper;
import com.example.aplicaciondb.database.UsuarioContract;

public class MainActivity extends AppCompatActivity {


    EditText InputNombre;
    EditText InputApellido;
    Button btnRegistrarse;

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


        InputNombre = findViewById(R.id.InputNombre);
        InputApellido = findViewById(R.id.InputApellido);
        btnRegistrarse = findViewById(R.id.btnRegistrarte);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String Nombre = InputNombre.getText().toString();
                String Apellido = InputApellido.getText().toString();

                ContentValues values = new ContentValues();
                values.put(UsuarioContract.UsuarioEntry.COLUMN_NAME, Nombre);
                values.put(UsuarioContract.UsuarioEntry.COLUMN_APELLIDO, Apellido);

                long newId = db.insert(UsuarioContract.UsuarioEntry.TABLE_NAME, null, values);


                if(newId != 1) {
                    Toast.makeText(MainActivity.this, "se guardo correctamente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Usuario no se guardo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}