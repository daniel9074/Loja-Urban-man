package central;

import Dao.SessaoLogin;
import Dao.daoFuncionario;
import cadastro_atualizacao_venda.AtualizarFuncionario;
import cadastro_atualizacao_venda.cadastroFuncionario;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Funcionario extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;
    private daoFuncionario bancoDeDados;

    public Funcionario() {

        initComponents();
        bancoDeDados = new daoFuncionario();
        bancoDeDados.conectarFuncionario();
        modeloTabela = montarTabela();
        tabelaFuncionario.setModel(modeloTabela);
        carregarFuncionario();
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabela = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cadastrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        pesquisa = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaFuncionario.setModel(montarTabela());
        tabela.setViewportView(tabelaFuncionario);

        cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        atualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        excluir.setText("Excluir");
        excluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        sair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sair.setText("Sair");
        sair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair)
                    .addComponent(excluir)
                    .addComponent(atualizar)
                    .addComponent(cadastrar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pesquisa.setText("Pesquisar Funcionario por Nome :");

        campoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaActionPerformed(evt);
            }
        });

        pesquisar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabela)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

       
    
   
        cadastroFuncionario cd = new cadastroFuncionario();
        cd.setVisible(true);
        cd.setTitle("cadastro de Funcionario");
        cd.setLocationRelativeTo(null);
        dispose();
    

    }//GEN-LAST:event_cadastrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        
        
      // Verificar o cargo do funcionário
    SessaoLogin sessao = SessaoLogin.getInstance();
    String cargoFuncionario = sessao.getCargoFuncionario();
    
    // Se o cargo do funcionário for "gerente", permitir a atualização de funcionários
    if ("gerente".equalsIgnoreCase(cargoFuncionario)) {
        int linhaSelecionada = tabelaFuncionario.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um Funcionário para atualizar.");
        } else {
            int idFuncionario = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
            dispose();

            AtualizarFuncionario telaAtualizacao = new AtualizarFuncionario();
            telaAtualizacao.setVisible(true);
            telaAtualizacao.setTitle("Atualização de Funcionário");
            telaAtualizacao.setLocationRelativeTo(null);

            telaAtualizacao.setCampoNomeText((String) modeloTabela.getValueAt(linhaSelecionada, 1));
            telaAtualizacao.setCampoCpfText((String) modeloTabela.getValueAt(linhaSelecionada, 2));
            telaAtualizacao.setCampoTelefoneText(String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 3)));
            telaAtualizacao.setCampoOpcaoSelected((String) modeloTabela.getValueAt(linhaSelecionada, 4));

            // Adiciona um ActionListener ao botão de atualização na tela de atualização
            telaAtualizacao.adicionarActionListenerAoBotaoAtualizar(new java.awt.event.ActionListener() {
             
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Aqui você deve realizar a atualização do funcionário no banco de dados
                    // Usando os dados fornecidos pela telaAtualizacao (tela de atualização)
                    // Não se esqueça de recarregar a tabela após a atualização
                    bancoDeDados.atualizarFuncionario(idFuncionario, telaAtualizacao.getCampoNomeText(),
                            telaAtualizacao.getCampoCpfText(), telaAtualizacao.getCampoTelefoneText(),
                            telaAtualizacao.getCampoOpcaoSelected(),LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                    // Atualiza a tabela após a atualização
                    carregarFuncionario();

                    // Fecha a tela de atualização após a conclusão
                    telaAtualizacao.dispose();
                }
            });
        }
    } else {
        // Se o cargo do funcionário não for "gerente", exibir uma mensagem de erro
        JOptionPane.showMessageDialog(this, "Você não tem permissão para atualizar funcionários.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
  
        // Verificar o cargo do funcionário
    SessaoLogin sessao = SessaoLogin.getInstance();
    String cargoFuncionario = sessao.getCargoFuncionario();
    
    // Se o cargo do funcionário for "gerente", permitir a exclusão de funcionários
    if ("gerente".equalsIgnoreCase(cargoFuncionario)) {
        int linhaSelecionada = tabelaFuncionario.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir.");
        } else {
            // Obtenha o ID (ou índice) do funcionário na linha selecionada
            int idFuncionario = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

            // Remova a linha diretamente do modelo da tabela
            modeloTabela.removeRow(linhaSelecionada);

            // Atualize a tabela após a remoção (opcional)
            tabelaFuncionario.setModel(modeloTabela);

            // Remova o funcionário do banco de dados
            bancoDeDados.removerFuncionario(idFuncionario);
        }
    } else {
        // Se o cargo do funcionário não for "gerente", exibir uma mensagem de erro
        JOptionPane.showMessageDialog(this, "Você não tem permissão para excluir funcionários.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_excluirActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

        opcao tl = new opcao();
        tl.setVisible(true);
        tl.setTitle("tela de opções");
        tl.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
 // Obter o texto digitado no campo de pesquisa
    String nomePesquisado = campoPesquisa.getText();

    // Verificar se o campo de pesquisa está vazio
    if (nomePesquisado.isEmpty()) {
        // Se estiver vazio, recarregar todos os funcionários
        carregarFuncionario();
    } else {
        // Se não estiver vazio, buscar funcionários pelo nome
        try {
            // Limpar todas as linhas existentes na tabela
            while (modeloTabela.getRowCount() > 0) {
                modeloTabela.removeRow(0);
            }

            // Buscar funcionários pelo nome
            ResultSet rs = bancoDeDados.obterFuncionarioPorNome(nomePesquisado);

            // Preencher a tabela com os resultados da pesquisa
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String cargo = rs.getString("cargo");
                String login = rs.getString("login");
                String dataHora = rs.getString("datahora");
                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição

                modeloTabela.addRow(new Object[]{id, nome, cpf, telefone, cargo, login, dataHoraFormatada});
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }       

    }//GEN-LAST:event_pesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    private DefaultTableModel montarTabela() {

        String[] coluna = {"ID", "Nome", "CPF", "Telefone", "Cargo","login","Data/Hora"};
        DefaultTableModel tabela = new DefaultTableModel(coluna, 0);

        return tabela;
    }

    private void carregarFuncionario() {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Carregar os produtos do daoProduto de dados e adicionar à tabela
        // Este é um exemplo, você pode precisar ajustar de acordo com o seu daoProduto de dados
        try {
            ResultSet rs = bancoDeDados.obterFuncionario();

            while (rs.next()) {
              
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");               
                String cargo = rs.getString("cargo");
                String login = rs.getString("login");
                String dataHora = rs.getString("datahora");
                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição

                modeloTabela.addRow(new Object[]{id, nome, cpf, telefone, cargo,login,dataHoraFormatada});
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton excluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaFuncionario;
    // End of variables declaration//GEN-END:variables

    String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public String formatarDataHora(String dataHoraDoBanco) {
        // Formate a data e hora do banco de dados no formato desejado
        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHoraDoBanco, formatterEntrada);
        return dataHoraFormatada.format(formatterSaida);
    }
}
