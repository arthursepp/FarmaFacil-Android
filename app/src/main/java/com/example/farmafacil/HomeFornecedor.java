package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFornecedor extends AppCompatActivity {

    private static final int REQUEST_CODE_CADASTRO = 1;
    private List<ProdutoFornecedor> produtos = new ArrayList<>();
    private ProdutoFornecedorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_fornecedor);

        RecyclerView recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
        Button btnCadastrarProduto = findViewById(R.id.btnCadastrarProduto);

        recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProdutoFornecedorAdapter(produtos);
        recyclerViewProdutos.setAdapter(adapter);

        btnCadastrarProduto.setOnClickListener(v -> {
            Intent intent = new Intent(HomeFornecedor.this, CadastroProdutoFornecedor.class);
            startActivityForResult(intent, REQUEST_CODE_CADASTRO);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CADASTRO && resultCode == RESULT_OK) {
            String nome = data.getStringExtra("nome");
            String descricao = data.getStringExtra("descricao");
            double preco = data.getDoubleExtra("preco", 0);

            ProdutoFornecedor produto = new ProdutoFornecedor(nome, descricao, preco);
            produtos.add(produto);
            adapter.notifyItemInserted(produtos.size() - 1);
        }
    }
}