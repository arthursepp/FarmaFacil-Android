package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroProdutoFornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto_fornecedor);

        EditText edtNomeProduto = findViewById(R.id.edtNomeProduto);
        EditText edtDescricaoProduto = findViewById(R.id.edtDescricaoProduto);
        EditText edtPrecoProduto = findViewById(R.id.edtPrecoProduto);
        Button btnCadastrarProduto = findViewById(R.id.btnCadastrarProduto);

        btnCadastrarProduto.setOnClickListener(v -> {
            String nome = edtNomeProduto.getText().toString();
            String descricao = edtDescricaoProduto.getText().toString();
            double preco;

            try {
                preco = Double.parseDouble(edtPrecoProduto.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(CadastroProdutoFornecedor.this, "Preço inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("nome", nome);
            resultIntent.putExtra("descricao", descricao);
            resultIntent.putExtra("preco", preco);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}