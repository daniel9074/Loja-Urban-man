 
package Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class daoFuncionario {
    
    
    Connection conn; //criando um objeto do tipo connection chamado conn

    public String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "daniS1974@"; //senha do MySQL 
    
    
    public boolean conectarFuncionario() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM funcionario"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();
          

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
            return false;
        }

    }
    
    
    public void desconectarFuncionario() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }

    }
    
    
    public void inserirFuncionario(String nome, String cpf, String telefone, String cargo, String login,String senha, String dataHora) {
        try {
            // Abre a conexão com o banco de dados
            conectarFuncionario();

            // Prepara a query SQL para inserção de dados
            String query = "INSERT INTO funcionario (nome, cpf, telefone, cargo, login, senha, datahora) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // Cria um objeto PreparedStatement para evitar SQL injection
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                // Define os valores dos parâmetros da query
                ps.setString(1, nome);
                ps.setString(2, cpf);
                ps.setString(3, telefone);
                ps.setString(4, cargo);
                ps.setString(5, login);
                ps.setString(6, senha);
                ps.setString(7, dataHora);
                
                // Executa a inserção
                ps.executeUpdate();
            }

            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir funcionário: " + ex.getMessage());
            // Exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário. Verifique os campos e tente novamente.");
        } finally {
            // Fecha a conexão com o banco de dados, independentemente de sucesso ou falha
            desconectarFuncionario();
        }
    }
    
    public ResultSet obterFuncionario() {
        try {
            String query = "SELECT * FROM funcionario";
            PreparedStatement pst = conn.prepareStatement(query);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
            return null;
        }
    }
    
    public ResultSet obterIdsFuncionario() {
    try {
        String query = "SELECT id FROM funcionario";
        PreparedStatement pst = conn.prepareStatement(query);
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    
    public ResultSet obterInformacoesFuncionario(int id) {
    try {
        String query = "SELECT * FROM funcionario WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao obter informações do funcionario: " + ex.getMessage());
        return null;
    }
}
    
    public void removerFuncionario(int id) {
        try {
            String query = "DELETE FROM funcionario WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao remover o Funcionario. Verifique o ID.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }

    
    public void atualizarFuncionario(int id, String nome, String cpf, String telefone, String cargo,String dataHora) {
       
        
        String query = "UPDATE funcionario SET nome=?, cpf=?, telefone=?, cargo=?, datahora=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, nome);
            statement.setString(2, cpf);
            statement.setString(3, telefone);
            statement.setString(4, cargo);           
            statement.setString(5, dataHora);
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Lide com a exceção conforme necessário
            e.printStackTrace();
        }
    }
    
    public boolean autenticarFuncionario(String login, String senha) {
    try {
        conectarFuncionario();

        String query = "SELECT * FROM funcionario WHERE login = ? AND senha = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, login);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();

            return rs.next(); // Se houver uma correspondência, retorna true
        }
    } catch (SQLException ex) {
        System.out.println("Erro na autenticação: " + ex.getMessage());
        return false;
    } finally {
        desconectarFuncionario();
    }
}

    
    public String getNomeUsuario(String login) {
        String nome = null;
        try {
            // Conectar ao banco de dados e executar consulta SQL para obter o nome do usuário
            // Exemplo:
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT nome FROM funcionario WHERE login = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nome;
    }

    public String getCargoUsuario(String login) {
        String cargo = null;
        try {
            // Conectar ao banco de dados e executar consulta SQL para obter o cargo do usuário
            // Exemplo:
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT cargo FROM funcionario WHERE login = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cargo = rs.getString("cargo");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cargo;
    }
 
    
     public ResultSet obterFuncionarioPorNome(String nome) {
    try {
        String query = "SELECT * FROM funcionario WHERE nome LIKE ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, "%" + nome + "%"); // Use LIKE para permitir correspondências parciais
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        return null;
    }
}
    

    

    
    
}

