package com.example.farmafacil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProdutoDetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_detalhes);

        TextView nomeProduto = findViewById(R.id.nomeProdutoDetalhes);
        TextView descricaoProduto = findViewById(R.id.descricaoProdutoDetalhes);
        TextView precoProduto = findViewById(R.id.precoProdutoDetalhes);
        EditText quantidadeProduto = findViewById(R.id.quantidadeProduto);
        Button btnComprar = findViewById(R.id.btnComprar);

        // Obtém os dados do produto a partir do Intent
        String nome = getIntent().getStringExtra("nome");
        String descricao = getIntent().getStringExtra("descricao");
        double preco = getIntent().getDoubleExtra("preco", 0);

        nomeProduto.setText(nome);
        descricaoProduto.setText(descricao);
        precoProduto.setText(String.valueOf(preco));

        btnComprar.setOnClickListener(v -> {
            String quantidadeStr = quantidadeProduto.getText().toString();
            if (!quantidadeStr.isEmpty()) {
                int quantidade = Integer.parseInt(quantidadeStr);
                Produto produto = new Produto(nome, descricao, preco);
                Carrinho.adicionarItem(produto, quantidade);
                Toast.makeText(this, "Adicionado ao carrinho: " + quantidade + " unidades de " + nome, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Por favor, insira a quantidade", Toast.LENGTH_SHORT).show();
            }
        });
    }
}