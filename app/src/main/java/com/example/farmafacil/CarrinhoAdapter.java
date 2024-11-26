package com.example.farmafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {
    private List<ItemCarrinho> itensCarrinho;

    public CarrinhoAdapter(List<ItemCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        ItemCarrinho item = itensCarrinho.get(position);
        holder.nomeProduto.setText(item.getProduto().getNome());
        holder.quantidadeProduto.setText(String.valueOf(item.getQuantidade()));
        holder.precoProduto.setText(String.valueOf(item.getProduto().getPreco()));

        holder.btnRemover.setOnClickListener(v -> {
            Carrinho.removerItem(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, itensCarrinho.size());
        });
    }

    @Override
    public int getItemCount() {
        return itensCarrinho.size();
    }

    static class CarrinhoViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto, quantidadeProduto, precoProduto;
        Button btnRemover;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nomeProdutoCarrinho);
            quantidadeProduto = itemView.findViewById(R.id.quantidadeProdutoCarrinho);
            precoProduto = itemView.findViewById(R.id.precoProdutoCarrinho);
            btnRemover = itemView.findViewById(R.id.btnRemover);
        }
    }
}