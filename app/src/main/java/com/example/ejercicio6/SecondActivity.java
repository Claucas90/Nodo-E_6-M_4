package com.example.ejercicio6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewDatos = findViewById(R.id.textViewDatos);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");
        String correo = getIntent().getStringExtra("correo");
        String contraseña = getIntent().getStringExtra("contraseña");

        String datos = "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Correo electrónico: " + correo + "\n" +
                "Contraseña: " + contraseña;

        textViewDatos.setText(datos);
    }
}
