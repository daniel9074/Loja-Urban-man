package Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class daoVenda {

    Connection conn; //criando um objeto do tipo connection chamado conn

    public String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "daniS1974@"; //senha do MySQL 

    public boolean conectarVenda() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM venda"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
            return false;
        }

    }

   public void inserirDadosVenda(String produto, String marca, double valor, String tamanho, String cliente, String cpf, String telefone, String email, String endereco,String funcionario,String cpff,String cargo, String dataHora,int quantidade) {
        try {
            String query = "INSERT INTO venda (produto, marca, valor, tamanho, cliente, cpf, telefone, email, endereco, funcionario, cpff, cargo, datahora,quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, produto);
            pst.setString(2, marca);
            pst.setDouble(3, valor);
            pst.setString(4, tamanho);
            pst.setString(5, cliente);
            pst.setString(6, cpf);
            pst.setString(7, telefone);
            pst.setString(8, email);
            pst.setString(9, endereco);
            pst.setString(10, funcionario);
            pst.setString(11, cpff);
            pst.setString(12, cargo);
            pst.setString(13,dataHora);
            pst.setInt(14, quantidade);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {

            } else {
                System.out.println("Falha ao cadastrar os dados da venda.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }

    public ResultSet obterVenda() {
        try {
            String query = "SELECT * FROM venda";
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

    public void excluirVenda(int id) {
    try {
        String query = "DELETE FROM venda WHERE ID = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Venda excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao excluir a venda.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
}

    public void atualizarVenda(int id) {
    try {
        String query = "DELETE FROM venda WHERE ID = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
          
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar a venda.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
}
    
    public double calcularValorTotalVendas() {
    double total = 0.0;
    try {
        String query = "SELECT SUM(valor) AS total FROM venda";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            total = rs.getDouble("total");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao calcular o valor total das vendas: " + ex.getMessage());
    }
    return total;
}
    
    public ResultSet obterVendasPorNomeCliente(String nomeCliente) {
    try {
        String query = "SELECT * FROM venda WHERE cliente LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nomeCliente + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
public ResultSet obterVendasPorNomeProduto(String nomeProduto) {
    try {
        String query = "SELECT * FROM venda WHERE produto LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nomeProduto + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}

public ResultSet obterVendasPorNomeFuncionario(String nomeFuncionario) {
    try {
        String query = "SELECT * FROM venda WHERE funcionario LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nomeFuncionario + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}

public ResultSet obterVendasPorMarca(String Marca) {
    try {
        String query = "SELECT * FROM venda WHERE marca LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + Marca + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    
}
