package com.example.farmafacil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {
    private List<Produto> produtos;
    private Context context;

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.nome.setText(produto.getNome());
        holder.descricao.setText(produto.getDescricao());
        holder.preco.setText(String.valueOf(produto.getPreco()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProdutoDetalhesActivity.class);
            intent.putExtra("nome", produto.getNome());
            intent.putExtra("descricao", produto.getDescricao());
            intent.putExtra("preco", produto.getPreco());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView nome, descricao, preco;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomeProduto);
            descricao = itemView.findViewById(R.id.descricaoProduto);
            preco = itemView.findViewById(R.id.precoProduto);
        }
    }
}