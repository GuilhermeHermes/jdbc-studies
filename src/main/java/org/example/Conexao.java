package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/jdbc-studie"; // URL correta do banco de dados
        String username = "postgres"; // Seu nome de usuário
        String password = "MARLI123"; // Sua senha
        Connection conn = null;
        try {
            // Carregar o driver do PostgreSQL (não é mais necessário nas versões mais recentes do JDBC)
            Class.forName("org.postgresql.Driver");

            // Obter conexão
             conn = DriverManager.getConnection(url, username, password);
            conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS CLIENTE (ID SERIAL PRIMARY KEY, NOME VARCHAR(100))");
            conn.createStatement().executeUpdate("INSERT INTO CLIENTE (NOME) VALUES ('Nome Exemplo')");
            System.out.println("Conexão bem-sucedida com o banco de dados!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }finally {
            conn.close();
        }
    }
}
