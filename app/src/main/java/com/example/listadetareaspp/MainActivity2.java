package com.example.listadetareaspp;

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
                String tareaSeleccionada = txtLista.getText().toString();
                listaTareas.remove(tareaSeleccionada);
                mostrarTareas();
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
}
