// Classe CadastroUsuario
package com.example.farmafacil; // Define o pacote da classe

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle; // Importa a classe Bundle
import android.widget.Button; // Importa a classe Button
import android.widget.EditText; // Importa a classe EditText
import android.widget.TextView; // Importa a classe TextView
import android.widget.Toast; // Importa a classe Toast

import androidx.activity.EdgeToEdge; // Importa a classe EdgeToEdge
import androidx.appcompat.app.AppCompatActivity; // Importa a classe AppCompatActivity

public class CadastroUsuario extends AppCompatActivity { // Declaração da classe CadastroUsuario

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método onCreate chamado na criação da Activity
        super.onCreate(savedInstanceState); // Chama o método onCreate da superclasse
        EdgeToEdge.enable(this); // Habilita o modo EdgeToEdge
        setContentView(R.layout.activity_cadastro_usuario); // Define o layout da Activity

        EditText edtNome = findViewById(R.id.edtNome); // Obtém a referência ao EditText edtNome
        EditText edtCPF = findViewById(R.id.edtCPF); // Obtém a referência ao EditText edtCPF
        EditText edtSenha = findViewById(R.id.edtSenha); // Obtém a referência ao EditText edtSenha
        Button btnCadastrar = findViewById(R.id.btnCadastrar); // Obtém a referência ao Button btnCadastrar
        TextView tvToCadastroFornecedor = findViewById(R.id.tvToCadastroFornecedor); // Obtém a referência ao TextView tvToCadastroFornecedor
        TextView tvToLoginUser = findViewById(R.id.tvToLoginUser); // Obtém a referência ao TextView tvToLoginUser

        btnCadastrar.setOnClickListener(v -> { // Define um listener para o botão btnCadastrar
            String nome = edtNome.getText().toString(); // Obtém o texto do EditText edtNome
            String senha = edtSenha.getText().toString(); // Obtém o texto do EditText edtSenha

            if (!nome.isEmpty() && !senha.isEmpty()) { // Verifica se os campos não estão vazios
                Database.addUser(nome, senha); // Adiciona o novo usuário ao banco de dados
                Toast.makeText(CadastroUsuario.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show(); // Exibe uma mensagem de sucesso
                startActivity(new Intent(CadastroUsuario.this, HomeUsuario.class)); // Inicia a Activity HomeUsuario
                finish(); // Finaliza a Activity atual
            } else { // Caso contrário
                Toast.makeText(CadastroUsuario.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show(); // Exibe uma mensagem de erro
            }
        });

        tvToLoginUser.setOnClickListener(v -> { // Define um listener para o TextView tvToLoginUser
            startActivity(new Intent(CadastroUsuario.this, MainActivity.class)); // Inicia a Activity MainActivity
            finish(); // Finaliza a Activity atual
        });

        tvToCadastroFornecedor.setOnClickListener(v -> { // Define um listener para o TextView tvToCadastroFornecedor
            startActivity(new Intent(CadastroUsuario.this, CadastroFornecedor.class)); // Inicia a Activity CadastroFornecedor
            finish(); // Finaliza a Activity atual
        });
    }
}