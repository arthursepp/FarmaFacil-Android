// Classe Database
package com.example.farmafacil; // Define o pacote da classe

import java.util.HashMap; // Importa a classe HashMap
import java.util.Map; // Importa a interface Map

public class Database { // Declaração da classe Database

    private static final Map<String, String> userCredentials = new HashMap<>(); // Cria um mapa estático para armazenar credenciais de usuário

    static { // Bloco estático para inicializar o mapa com alguns valores
        userCredentials.put("admin", "admin12344"); // Adiciona credenciais de administrador
        userCredentials.put("user", "user12344"); // Adiciona credenciais de usuário
        userCredentials.put("fornecedor", "fornecedor12344"); // Adiciona credenciais de fornecedor
    }

    public static Map<String, String> getUserCredentials() { // Método estático para obter as credenciais de usuário
        return userCredentials; // Retorna o mapa de credenciais de usuário
    }

    public static void addUser(String username, String senha) { // Método estático para adicionar um novo usuário
        userCredentials.put(username, senha); // Adiciona o novo usuário ao mapa de credenciais
    }
}