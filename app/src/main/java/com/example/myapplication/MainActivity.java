package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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

        // Crear conjunto de datos
        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Juan", "Pérez", R.mipmap.ic_contacto_h, "juan.perez@example.com", "1234567890"));
        contactos.add(new Contacto("María", "González", R.mipmap.ic_contacto_m, "maria.gonzalez@example.com", "9876543210"));
        contactos.add(new Contacto("Luis", "Ramírez", R.mipmap.ic_contacto_h, "luis.ramirez@example.com", "4567891230"));
        contactos.add(new Contacto("Ana", "López", R.mipmap.ic_contacto_m, "ana.lopez@example.com", "7891234560"));
        contactos.add(new Contacto("Carlos", "Martínez", R.mipmap.ic_contacto_h, "carlos.martinez@example.com", "3216549870"));
        contactos.add(new Contacto("Lucía", "Hernández", R.mipmap.ic_contacto_m, "lucia.hernandez@example.com", "6549873210"));
        contactos.add(new Contacto("Pedro", "Gómez",R.mipmap.ic_contacto_h, "pedro.gomez@example.com", "1597534862"));
        contactos.add(new Contacto("Sofía", "Vargas", R.mipmap.ic_contacto_m, "sofia.vargas@example.com", "7539518462"));
        contactos.add(new Contacto("Diego", "Cruz", R.mipmap.ic_contacto_h, "diego.cruz@example.com", "8523697410"));
        contactos.add(new Contacto("Elena", "Mendoza", R.mipmap.ic_contacto_m, "elena.mendoza@example.com", "9513574628"));




        // Crear el adaptador
        ContactoAdapter ContactoAdapter = new ContactoAdapter(contactos);

        // Instanciar el RecyclerView
        RecyclerView rvContactos = findViewById(R.id.rv_Contactos);

        // Opcionalmente podríamos modificar el tipo de LayoutManager
        rvContactos.setLayoutManager(new LinearLayoutManager(this));

        // Asignar el adaptador al RecyclerView
        rvContactos.setAdapter(ContactoAdapter);

    }
}