package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginFornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_fornecedor);

        TextView tvToCadastroFornecedor = findViewById(R.id.tvToCadastroFornecedor2);
        TextView tvToLoginCliente = findViewById(R.id.tvToLoginCliente);

        tvToLoginCliente.setOnClickListener(v -> {
            startActivity(new Intent(LoginFornecedor.this, MainActivity.class));
            finish();
        });

        tvToCadastroFornecedor.setOnClickListener(v -> {
            startActivity(new Intent(LoginFornecedor.this, CadastroFornecedor.class));
            finish();
        });

    }
}