package central;

import Dao.SessaoLogin;
import Dao.daoVenda;
import cadastro_atualizacao_venda.AtualizarVenda;
import cadastro_atualizacao_venda.cadastroVenda;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Venda extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;
    private daoVenda bancoDeDados;

    public Venda() {
        initComponents();
        bancoDeDados = new daoVenda();
        bancoDeDados.conectarVenda();
        modeloTabela = montarTabela();
        tabelaVenda.setModel(modeloTabela);
        carregarVenda();

        // Carregar o valor total das vendas e exibir na label do saldo do caixa
        double valorTotalVendas = bancoDeDados.calcularValorTotalVendas();
        String saldoCaixa = "Saldo do Caixa: R$ " + valorTotalVendas;
        jLabel1.setText(saldoCaixa);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pesquisa = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        excluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        excluir.setText("Excluir");
        excluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
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

        sair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sair.setText("Sair");
        sair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        tabelaVenda.setModel(montarTabela());
        tabelaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabelaVenda);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Saldo do Caixa : ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pesquisa.setText("Pesquisar Venda por :");

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Funcionario", "Produto", "Marca" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizar)
                    .addComponent(excluir)
                    .addComponent(sair)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        
        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();
        
         if ("gerente".equalsIgnoreCase(cargoFuncionario)){
        
        
        int linhaSelecionada = tabelaVenda.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma venda para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int idVenda = (int) tabelaVenda.getValueAt(linhaSelecionada, 0);
            bancoDeDados.excluirVenda(idVenda);

            // Carregar o valor total das vendas e exibir na label do saldo do caixa
            double valorTotalVendas = bancoDeDados.calcularValorTotalVendas();
            String saldoCaixa = "Saldo do Caixa: R$ " + valorTotalVendas;
            jLabel1.setText(saldoCaixa);
            carregarVenda();
        }

         }else {
            // Se o cargo do funcionário não for "gerente" ou "vendedor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar vendas.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();
        
         if ("gerente".equalsIgnoreCase(cargoFuncionario)){
        
        // Verificar se uma linha foi selecionada na tabela
        int linhaSelecionada = tabelaVenda.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma venda para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obter o ID da venda selecionada na tabela
            int idVenda = (int) tabelaVenda.getValueAt(linhaSelecionada, 0);

            // Excluir a venda do banco de dados
            bancoDeDados.atualizarVenda(idVenda);

            // Ir para a próxima tela (tela de atualização da venda)
            AtualizarVenda atualizarVenda = new AtualizarVenda();
            atualizarVenda.setVisible(true);
            atualizarVenda.setTitle("Atualizar Venda");
            atualizarVenda.setLocationRelativeTo(null);
            dispose();
        }
         }else {
            // Se o cargo do funcionário não for "gerente" ou "vendedor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar vendas.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

        opcao tl = new opcao();
        tl.setVisible(true);
        tl.setTitle("tela de opções");
        tl.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_sairActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente" ou "vendedor", permitir o cadastro de venda
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "caixa".equalsIgnoreCase(cargoFuncionario)) {
            cadastroVenda vd = new cadastroVenda();
            vd.setVisible(true);
            vd.setTitle("cadastrar_Venda");
            vd.setLocationRelativeTo(null);
            dispose();

            // Obtenha os dados da venda da cadastroVenda
            String[] dadosVenda = vd.obterDadosVenda();
        } else {
            // Se o cargo do funcionário não for "gerente" ou "vendedor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar vendas.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_cadastrarActionPerformed

    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed

    // Obter o texto digitado no campo de pesquisa
    String termoPesquisa = campoPesquisa.getText();
    String tipoPesquisa = (String) jComboBox1.getSelectedItem();

    // Verificar se o campo de pesquisa está vazio
    if (termoPesquisa.isEmpty()) {
        // Se estiver vazio, recarregar todas as vendas
        carregarVenda();
    } else {
        // Se não estiver vazio, buscar vendas conforme o tipo de pesquisa selecionado
        try {
            // Limpar todas as linhas existentes na tabela
            while (modeloTabela.getRowCount() > 0) {
                modeloTabela.removeRow(0);
            }

            // Realizar a pesquisa de acordo com o tipo selecionado
            ResultSet rs = null;
            if ("Cliente".equalsIgnoreCase(tipoPesquisa)) {
                // Pesquisar pelo nome do cliente
                rs = bancoDeDados.obterVendasPorNomeCliente(termoPesquisa);
            } else if ("Produto".equalsIgnoreCase(tipoPesquisa)) {
                // Pesquisar pelo nome do produto
                rs = bancoDeDados.obterVendasPorNomeProduto(termoPesquisa);
            } else if ("Funcionario".equalsIgnoreCase(tipoPesquisa)){
                // pesquisar pelo nome do Funcionario
                rs = bancoDeDados.obterVendasPorNomeFuncionario(termoPesquisa);
            }else if ("Marca".equalsIgnoreCase(tipoPesquisa)){
                // pesquisar pelo nome do Funcionario
                rs = bancoDeDados.obterVendasPorMarca(termoPesquisa);
            }

            // Preencher a tabela com os resultados da pesquisa
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nomeProduto = rs.getString("produto");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String tamanho = rs.getString("tamanho");
                String cliente = rs.getString("cliente");
                String cpf = rs.getString("cpf");
                String funcionario = rs.getString("funcionario");
                String dataHora = rs.getString("datahora");

                // Formate a data/hora antes de adicionar à tabela
                dataHora = formatarDataHora(dataHora);

                modeloTabela.addRow(new Object[]{id, nomeProduto, marca, valor, tamanho, cliente, cpf, funcionario, dataHora});
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
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda().setVisible(true);
            }
        });
    }

    private DefaultTableModel montarTabela() {

        String[] coluna = {"ID", "Produto", "Marca", "Valor", "Tamanho/Medida", "Cliente", "CPF", "Funcionario","Data/Hora"};
        DefaultTableModel tabela = new DefaultTableModel(coluna, 0);

        return tabela;
    }

    private void carregarVenda() {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Carregar os produtos do daoVenda de dados e adicionar à tabela
        try {
            ResultSet rs = bancoDeDados.obterVenda();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("produto");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String tamanho = rs.getString("tamanho");
                String cliente = rs.getString("cliente");
                String cpf = rs.getString("cpf");               
                String funcionario = rs.getString("funcionario");               
                String dataHora =rs.getString("datahora");
               
                // Formate a data/hora antes de adicionar à tabela
            dataHora = formatarDataHora(dataHora);
                
                
                modeloTabela.addRow(new Object[]{id, nome, marca, valor, tamanho, cliente, cpf, funcionario, dataHora});
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }

    private String formatarDataHora(String dataHora) {
    // Converta a String para LocalDateTime
    LocalDateTime dateTime = LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // Defina o formato desejado para a data e hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    // Formate a data e hora no formato especificado
    return dateTime.format(formatter);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton excluir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabelaVenda;
    // End of variables declaration//GEN-END:variables
}
