package com.example.listadetareaspp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        agregar=(Button) findViewById(R.id.btnAdd);
        tarea_nueva=(EditText) findViewById(R.id.etTarea);
        lista_tareas=(TextView) findViewById(R.id.txtLista);
        eliminar=(Button) findViewById(R.id.btndelete);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista=lista_tareas.getText().toString();
                tn=tarea_nueva.getText().toString();
                lista=lista + "\n" +tn;
                lista_tareas.setText(lista);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TareaEliminar=tarea_nueva.getText().toString();
                if(lista.contains(TareaEliminar)){
                    lista=lista.replace(eliminar + "\n", "");
                    lista_tareas.setText(lista);
                }else {
                    Toast.makeText(MainActivity2.this,"La tarea no esta en la lista",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}