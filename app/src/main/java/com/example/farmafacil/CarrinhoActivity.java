package com.example.farmafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCarrinho);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ItemCarrinho> itensCarrinho = Carrinho.getItens();
        CarrinhoAdapter adapter = new CarrinhoAdapter(itensCarrinho);
        recyclerView.setAdapter(adapter);

        Button btnToHome = findViewById(R.id.btnToHome);

        btnToHome.setOnClickListener(v -> {
            startActivity(new Intent(CarrinhoActivity.this, HomeUsuario.class));
            finish();
        });

    }
}