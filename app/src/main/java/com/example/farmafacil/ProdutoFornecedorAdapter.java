package com.example.farmafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutoFornecedorAdapter extends RecyclerView.Adapter<ProdutoFornecedorAdapter.ProdutoViewHolder> {
    private List<ProdutoFornecedor> produtos;

    public ProdutoFornecedorAdapter(List<ProdutoFornecedor> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto_fornecedor, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        ProdutoFornecedor produto = produtos.get(position);
        holder.nomeProduto.setText(produto.getNome());
        holder.descricaoProduto.setText(produto.getDescricao());
        holder.precoProduto.setText(String.valueOf(produto.getPreco()));

        holder.btnRemoverProduto.setOnClickListener(v -> {
            produtos.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, produtos.size());
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto, descricaoProduto, precoProduto;
        Button btnRemoverProduto;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nomeProduto);
            descricaoProduto = itemView.findViewById(R.id.descricaoProduto);
            precoProduto = itemView.findViewById(R.id.precoProduto);
            btnRemoverProduto = itemView.findViewById(R.id.btnRemoverProduto);
        }
    }
}