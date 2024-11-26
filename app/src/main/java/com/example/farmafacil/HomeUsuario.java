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

public class HomeUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_usuario);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProdutos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Paracetamol", "Analgésico e antipirético", 5.99));
        produtos.add(new Produto("Ibuprofeno", "Anti-inflamatório", 12.49));
        produtos.add(new Produto("Amoxicilina", "Antibiótico", 18.75));
        produtos.add(new Produto("Dipirona", "Analgésico e antipirético", 4.50));
        produtos.add(new Produto("Omeprazol", "Inibidor de bomba de prótons", 15.00));

        ProdutoAdapter adapter = new ProdutoAdapter(this, produtos);
        recyclerView.setAdapter(adapter);

        Button btnVerCarrinho = findViewById(R.id.btnSeuCarrinho);
        btnVerCarrinho.setOnClickListener(v -> {
            Intent intent = new Intent(HomeUsuario.this, CarrinhoActivity.class);
            startActivity(intent);
        });
    }
}