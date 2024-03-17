 
package Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

 
public class daoCliente {
    
     Connection conn; //criando um objeto do tipo connection chamado conn

    public String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "daniS1974@"; //senha do MySQL 
    
    
    public boolean conectarCliente() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM cliente"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();
          

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
            return false;
        }

    }
    
    
    public void desconectarCliente() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }

    }
  
  public void inserirClientecomdataHora(String nome, String cpf, String telefone, String email, String endereco, String dataHora) {
        try {
           
            String query = "INSERT INTO cliente (nome,cpf,telefone,email,endereco,datahora) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, telefone);
            pst.setString(4, email);
            pst.setString(5, endereco);
            pst.setString(6, dataHora);

            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso");
            } else {
                System.out.println("Falha ao cadastrar o cliente.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }

    }
  
  
  public ResultSet obterCliente() {
        try {
            String query = "SELECT * FROM cliente";
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }
  
   public void removerCliente(int id) {
        try {
            String query = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao remover o cliente. Verifique o ID.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }
  
   public void atualizarCliente(int id, String nome, String cpf, String telefone, String email, String endereco, String dataHora) {
    try {
        String query = "UPDATE cliente SET nome=?, cpf=?, telefone=?, email=?, endereco=?, datahora=? WHERE id=?";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, nome);
        pst.setString(2, cpf);
        pst.setString(3, telefone);
        pst.setString(4, email);
        pst.setString(5, endereco);
        pst.setString(6, dataHora); // Incluindo a data e hora
        pst.setInt(7, id);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar o cliente. Verifique o ID.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
}

  
   public ResultSet obterIdsCliente() {
    try {
        String query = "SELECT id FROM cliente";
        PreparedStatement pst = conn.prepareStatement(query);
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
   
    public ResultSet obterInformacoesCliente(int id) {
    try {
        String query = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao obter informações do cliente: " + ex.getMessage());
        return null;
    }
}
    public ResultSet obterClientePorNome(String nome) {
    try {
        String query = "SELECT * FROM cliente WHERE nome LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%"); // Use LIKE para permitir correspondências parciais
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    
     public ResultSet obterClientePorCpf(String cpf) {
    try {
        String query = "SELECT * FROM cliente WHERE cpf LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + cpf + "%"); // Use LIKE para permitir correspondências parciais
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    
}
