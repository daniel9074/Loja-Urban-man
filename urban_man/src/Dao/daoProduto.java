package Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class daoProduto {

    Connection conn; //criando um objeto do tipo connection chamado conn

    public String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "daniS1974@"; //senha do MySQL 

    public boolean conectarProduto() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM produto"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
            return false;
        }

    }

    public void desconectarProduto() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public ResultSet obterProdutos() {
        try {
            String query = "SELECT * FROM produto";
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

   public void atualizarProduto(int id, String nome, String marca, Double valor, String tamanho, String dataHora, int quantidade) {
    try {
        String query = "UPDATE produto SET nome=?, marca=?, valor=?, tamanho=?, datahora=?, quantidade=? WHERE id=?";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, nome);
        pst.setString(2, marca);
        pst.setDouble(3, valor);
        pst.setString(4, tamanho);   
        pst.setString(5, dataHora);
        pst.setInt(6, quantidade);
        pst.setInt(7, id);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar o produto. Verifique o ID.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
}

    public ResultSet obterIdsProdutos() {
        try {
            String query = "SELECT id FROM produto";
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

    public ResultSet obterInformacoesProduto(int id) {
        try {
            String query = "SELECT * FROM produto WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao obter informações do produto: " + ex.getMessage());
            return null;
        }
    }

    public void removerProduto(int id) {
        try {
            String query = "DELETE FROM produto WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao remover o produto. Verifique o ID.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }

    public boolean inserirProdutoComDataHora(String nome, String marca, Double valor, String tamanho, String dataHora, int quantidade) {
        try {
            // Inserir a data e hora no banco de dados
            String query = "INSERT INTO produto (nome, marca, valor, tamanho, datahora, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, marca);
            preparedStatement.setDouble(3, valor);
            preparedStatement.setString(4, tamanho);
            preparedStatement.setString(5, dataHora);
            preparedStatement.setInt(6, quantidade);
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void removerQuantidadeProduto(int id) {
    try {
        // Verifica se o produto com o ID fornecido existe
        ResultSet rs = obterInformacoesProduto(id);
        if (rs.next()) {
            int quantidadeAtual = rs.getInt("quantidade");
            // Se a quantidade atual for maior que zero, decrementa 1 da quantidade
            if (quantidadeAtual > 0) {
                atualizarProduto(id, rs.getString("nome"), rs.getString("marca"), rs.getDouble("valor"), rs.getString("tamanho"), rs.getString("datahora"), quantidadeAtual - 1);
                JOptionPane.showMessageDialog(null, "Uma unidade do produto foi removida.");
            } else {
                JOptionPane.showMessageDialog(null, "Não há unidades deste produto para remover.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL: " + ex.getMessage());
    }
}

    
    public int obterQuantidadeProduto(int id) {
    try {
        String query = "SELECT quantidade FROM produto WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt("quantidade");
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao obter a quantidade do produto: " + ex.getMessage());
    }
    return 0; // Retorna 0 se houver algum erro ou se o produto não for encontrado
}

    public void removerQuantidadeProduto(int idProduto, int quantidadeVendida) {
    try {
        // Recupere a quantidade atual do produto no banco de dados usando o ID do produto
        int quantidadeAtual = obterQuantidadeProduto(idProduto);

        // Subtraia a quantidade vendida da quantidade atual para obter a nova quantidade
        int novaQuantidade = quantidadeAtual - quantidadeVendida;

        // Atualize a quantidade do produto no banco de dados com a nova quantidade calculada
        String query = "UPDATE produto SET quantidade = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, novaQuantidade);
        pst.setInt(2, idProduto);
        pst.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Erro ao remover quantidade do produto: " + ex.getMessage());
    }
}

    public ResultSet obterProdutosPorNome(String nome) {
    try {
        String query = "SELECT * FROM produto WHERE nome LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}

     public ResultSet obterProdutosPorMarca(String nome) {
    try {
        String query = "SELECT * FROM produto WHERE marca LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
     
      public ResultSet obterProdutosPorTam(String nome) {
    try {
        String query = "SELECT * FROM produto WHERE tamanho LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    
         public ResultSet obterProdutosPorQuant(String nome) {
    try {
        String query = "SELECT * FROM produto WHERE quantidade LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%");
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
         
          public ResultSet obterProdutosPorNomeETamanho(String nome, String tamanho) {
        try {
            String query = "SELECT * FROM produto WHERE nome LIKE ? AND tamanho LIKE ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + tamanho + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

    public ResultSet obterProdutosPorNomeEQuantidade(String nome, int quantidade) {
        try {
            String query = "SELECT * FROM produto WHERE nome LIKE ? AND quantidade = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + nome + "%");
            pst.setInt(2, quantidade);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

    public ResultSet obterProdutosPorMarcaETamanho(String marca, String tamanho) {
        try {
            String query = "SELECT * FROM produto WHERE marca LIKE ? AND tamanho LIKE ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + marca + "%");
            pst.setString(2, "%" + tamanho + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }

    public ResultSet obterProdutosPorMarcaEQuantidade(String marca, int quantidade) {
        try {
            String query = "SELECT * FROM produto WHERE marca LIKE ? AND quantidade = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + marca + "%");
            pst.setInt(2, quantidade);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }
}
