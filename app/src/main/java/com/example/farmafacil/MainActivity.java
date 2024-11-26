// Classe MainActivity
package com.example.farmafacil; // Define o pacote da classe

import android.os.Bundle; // Importa a classe Bundle
import android.widget.Button; // Importa a classe Button
import android.widget.EditText; // Importa a classe EditText
import android.widget.TextView; // Importa a classe TextView
import android.widget.Toast; // Importa a classe Toast
import android.content.Intent; // Importa a classe Intent
import androidx.activity.EdgeToEdge; // Importa a classe EdgeToEdge
import androidx.appcompat.app.AppCompatActivity; // Importa a classe AppCompatActivity

import java.util.Map; // Importa a interface Map

public class MainActivity extends AppCompatActivity { // Declaração da classe MainActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método onCreate chamado na criação da Activity
        super.onCreate(savedInstanceState); // Chama o método onCreate da superclasse
        EdgeToEdge.enable(this); // Habilita o modo EdgeToEdge
        setContentView(R.layout.activity_main); // Define o layout da Activity

        EditText edtUsername = findViewById(R.id.edtNome); // Obtém a referência ao EditText edtNome
        EditText edtSenha = findViewById(R.id.edtSenha); // Obtém a referência ao EditText edtSenha

        TextView tvToCadastro = findViewById(R.id.tvToCadastro); // Obtém a referência ao TextView tvToCadastro
        TextView tvToLoginFornecedor = findViewById(R.id.tvToLoginFornecedor); // Obtém a referência ao TextView tvToLoginFornecedor

        Button btnSend = findViewById(R.id.btnSend); // Obtém a referência ao Button btnSend

        btnSend.setOnClickListener(v -> { // Define um listener para o botão btnSend
            String username = edtUsername.getText().toString(); // Obtém o texto do EditText edtNome
            String senha = edtSenha.getText().toString(); // Obtém o texto do EditText edtSenha

            Map<String, String> userCredentials = Database.getUserCredentials(); // Obtém as credenciais de usuário do banco de dados
            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(senha)) { // Verifica se as credenciais são válidas
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show(); // Exibe uma mensagem de sucesso
            } else { // Caso contrário
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show(); // Exibe uma mensagem de erro
            }
        });

        tvToCadastro.setOnClickListener(v -> { // Define um listener para o TextView tvToCadastro
            startActivity(new Intent(MainActivity.this, CadastroUsuario.class)); // Inicia a Activity CadastroUsuario
            finish(); // Finaliza a Activity atual
        });

        tvToLoginFornecedor.setOnClickListener(v -> { // Define um listener para o TextView tvToLoginFornecedor
            startActivity(new Intent(MainActivity.this, LoginFornecedor.class)); // Inicia a Activity LoginFornecedor
            finish(); // Finaliza a Activity atual
        });
    }
}