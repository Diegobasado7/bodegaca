package com.example.bodegaca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCat = findViewById(R.id.btnGestionCategorias);
        Button btnProv = findViewById(R.id.btnGestionProveedores);
        Button btnProd = findViewById(R.id.btnGestionProductos);

        btnCat.setOnClickListener(v -> startActivity(new Intent(this, CategoriaActivity.class)));
        btnProv.setOnClickListener(v -> startActivity(new Intent(this, ProveedorActivity.class)));
        btnProd.setOnClickListener(v -> startActivity(new Intent(this, ProductoActivity.class)));
    }
}