package com.example.ejercicio6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextEdad;
    private EditText editTextCorreo;
    private EditText editTextContraseña;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    String nombre = editTextNombre.getText().toString();
                    String apellido = editTextApellido.getText().toString();
                    String edad = editTextEdad.getText().toString();
                    String correo = editTextCorreo.getText().toString();
                    String contraseña = editTextContraseña.getText().toString();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido);
                    intent.putExtra("edad", edad);
                    intent.putExtra("correo", correo);
                    intent.putExtra("contraseña", contraseña);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validarCampos() {
        String nombre = editTextNombre.getText().toString().trim();
        String apellido = editTextApellido.getText().toString().trim();
        String edad = editTextEdad.getText().toString().trim();
        String correo = editTextCorreo.getText().toString().trim();
        String contraseña = editTextContraseña.getText().toString().trim();

        if (nombre.isEmpty()) {
            editTextNombre.setError("Debe ingresar un nombre");
            return false;
        }

        if (!esNombreValido(nombre)) {
            editTextNombre.setError("El nombre debe contener solo letras");
            return false;
        }

        if (apellido.isEmpty()) {
            editTextApellido.setError("Debe ingresar un apellido");
            return false;
        }

        if (!esNombreValido(apellido)) {
            editTextApellido.setError("El apellido debe contener solo letras");
            return false;
        }

        if (edad.isEmpty()) {
            editTextEdad.setError("Debe ingresar su edad");
            return false;
        }

        if (!esNumeroValido(edad)) {
            editTextEdad.setError("La edad debe ser un número válido");
            return false;
        }

        if (edad.length() > 3) {
            editTextEdad.setError("La edad debe tener un máximo de 3 dígitos");
            return false;
        }

        if (correo.isEmpty()) {
            editTextCorreo.setError("Debe ingresar un correo electrónico");
            return false;
        }

        if (!esCorreoValido(correo)) {
            editTextCorreo.setError("Debe ingresar un correo electrónico válido");
            return false;
        }

        if (contraseña.isEmpty()) {
            editTextContraseña.setError("Debe ingresar una contraseña");
            return false;
        }

        return true;
    }

    private boolean esNombreValido(String nombre) {
        return nombre.matches("[a-zA-Z]+");
    }

    private boolean esNumeroValido(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esCorreoValido(String correo) {
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}