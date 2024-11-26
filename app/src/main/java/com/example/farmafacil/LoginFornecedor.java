package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class LoginFornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_fornecedor);

        EditText edtCNPJ = findViewById(R.id.edtCNPJCadastro);
        EditText edtSenha = findViewById(R.id.edtSenhaFornecedorCadastro);
        Button btnLogar = findViewById(R.id.btnLogarFornecedor);

        btnLogar.setOnClickListener(v -> {
            String cnpj = edtCNPJ.getText().toString();
            String senha = edtSenha.getText().toString();
            Map<String, String> credentials = Database.getUserCredentials();

            if (credentials.containsKey(cnpj) && credentials.get(cnpj).equals(senha)) {
                Intent intent = new Intent(LoginFornecedor.this, HomeFornecedor.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginFornecedor.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
            }
        });

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