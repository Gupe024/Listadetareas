package com.example.listadetareaspp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    Button agregar;
    Button eliminar;
    EditText tarea_nueva;
    TextView lista_tareas;
    String lista;
    String tn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        agregar=(Button) findViewById(R.id.btnAdd);
        tarea_nueva=(EditText) findViewById(R.id.etTarea);
        lista_tareas=(TextView) findViewById(R.id.txtLista);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista=lista_tareas.getText().toString();
                tn=tarea_nueva.getText().toString();
                lista=lista + "\n" +tn;
                lista_tareas.setText(lista);
            }
        });
    }
}