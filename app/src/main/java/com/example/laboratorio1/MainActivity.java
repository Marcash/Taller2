package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id_name;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_name = (EditText)findViewById(R.id.id_name);
    }

    public void Iniciarsesion(View view){
        Intent Iniciarsesion  = new Intent(this, WelcomeActivity.class);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
        Iniciarsesion.putExtra("usuario",id_name.getText().toString());
        startActivity(Iniciarsesion);
    }

    public void Registro(View view){
        Intent Registro  = new Intent(this, RegisterActivity.class);
        startActivity(Registro);
    }

}