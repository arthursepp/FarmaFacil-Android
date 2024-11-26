package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class CadastroFornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_fornecedor);

        TextView tvToLoginFornecedor = findViewById(R.id.tvToLoginFornecedor2);
        TextView tvToCadastroCliente = findViewById(R.id.tvToCadastroCliente);

        tvToLoginFornecedor.setOnClickListener(v -> {
            startActivity(new Intent(CadastroFornecedor.this, LoginFornecedor.class));
            finish();
        });

        tvToCadastroCliente.setOnClickListener(v -> {
            startActivity(new Intent(CadastroFornecedor.this, CadastroUsuario.class));
            finish();
        });

    }
}