package com.example.listadetareaspp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private EditText etTarea;
    private Button btnAdd, btndelete;
    private TextView txtLista;
    private List<String> listaTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etTarea = findViewById(R.id.etTarea);
        btnAdd = findViewById(R.id.btnAdd);
        btndelete = findViewById(R.id.btndelete);
        txtLista = findViewById(R.id.txtLista);

        listaTareas = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarea = etTarea.getText().toString();
                if (!tarea.isEmpty()) {
                    listaTareas.add(tarea);
                    mostrarTareas();
                    etTarea.setText("");
                }
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!listaTareas.isEmpty()) {
                    mostrarDialogoEliminar();
                }
            }
        });
    }

    private void mostrarTareas() {
        StringBuilder builder = new StringBuilder();
        for (String tarea : listaTareas) {
            builder.append(tarea).append("\n");
        }
        txtLista.setText(builder.toString());
    }

    private void mostrarDialogoEliminar() {
        final CharSequence[] tareas = listaTareas.toArray(new CharSequence[listaTareas.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione la tarea a eliminar");
        builder.setItems(tareas, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listaTareas.remove(which);
                mostrarTareas();
            }
        });
        builder.show();
    }
}

