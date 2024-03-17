package central;

import Dao.SessaoLogin;
import cadastro_atualizacao_venda.AtualizarProduto;
import cadastro_atualizacao_venda.CadastroProduto;
import javax.swing.table.DefaultTableModel;
import Dao.daoProduto;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Produtos extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;
    private daoProduto bancoDeDados;

    public Produtos() {

        initComponents();
        bancoDeDados = new daoProduto();
        bancoDeDados.conectarProduto();
        modeloTabela = montarTabela();
        tabelaProduto.setModel(modeloTabela);
        carregarProdutos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabela = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        campoPesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        jComboBoxNome = new javax.swing.JComboBox<>();
        jComboBoxTam = new javax.swing.JComboBox<>();
        campoPesquisa2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaProduto.setModel(montarTabela());
        tabela.setViewportView(tabelaProduto);

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

        jComboBoxNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Marca" }));

        jComboBoxTam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tam/Med", "Quantidade" }));
        jComboBoxTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTamActionPerformed(evt);
            }
        });

        campoPesquisa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabela)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jComboBoxTam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar)
                    .addComponent(campoPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNome)
                    .addComponent(jComboBoxTam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar)
                    .addComponent(sair)
                    .addComponent(atualizar)
                    .addComponent(excluir))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        // Se o cargo do funcionário for "gerente", "estoquista" ou "repositor", permitir a cadastro do produto
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "estoquista".equalsIgnoreCase(cargoFuncionario) || "repositor".equalsIgnoreCase(cargoFuncionario)) {

            CadastroProduto tl = new CadastroProduto();
            tl.setVisible(true);
            tl.setTitle("tela de Cadastro");
            tl.setLocationRelativeTo(null);
            dispose();

        } else {
            // Se o cargo do funcionário não for "gerente", "estoquista" ou "repositor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar produtos.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_cadastrarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente" ou "estoquista", permitir a exclusão do produto
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "estoquista".equalsIgnoreCase(cargoFuncionario)) {
            int linhaSelecionada = tabelaProduto.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.");
            } else {
                // Obtenha o ID (ou índice) do produto na linha selecionada
                int idProduto = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

                // Remova a linha diretamente do modelo da tabela
                modeloTabela.removeRow(linhaSelecionada);

                // Atualize a tabela após a remoção (opcional)
                tabelaProduto.setModel(modeloTabela);

                // Remova o produto do daoProduto de dados
                bancoDeDados.removerProduto(idProduto);
            }
        } else {
            // Se o cargo do funcionário não for "gerente" ou "estoquista", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para excluir produtos.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_excluirActionPerformed


    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente", "estoquista" ou "repositor", permitir a atualização do produto
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "estoquista".equalsIgnoreCase(cargoFuncionario) || "repositor".equalsIgnoreCase(cargoFuncionario)) {
            int linhaSelecionada = tabelaProduto.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um produto para atualizar.");
            } else {
                int idProduto = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

                dispose();

                // Chama o método para abrir a tela de atualização
                AtualizarProduto telaAtualizacao = new AtualizarProduto();
                telaAtualizacao.setVisible(true);
                telaAtualizacao.setTitle("Atualização de Produto");
                telaAtualizacao.setLocationRelativeTo(null);

                // Preenche os campos na tela de atualização com os dados do produto selecionado
                telaAtualizacao.setCampoNomeText((String) modeloTabela.getValueAt(linhaSelecionada, 1));
                telaAtualizacao.setCampoMarcaText((String) modeloTabela.getValueAt(linhaSelecionada, 2));
                telaAtualizacao.setCampoValorText(String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 3)));
                telaAtualizacao.setCampoTamanhoText((String) modeloTabela.getValueAt(linhaSelecionada, 4));
                telaAtualizacao.setCampoQuantidade(String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 5)));

                // Adiciona um ActionListener ao botão de atualização na tela de atualização
                telaAtualizacao.adicionarActionListenerAoBotaoAtualizar(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        // Chama o método atualizarProduto no bancoDeDados

                        bancoDeDados.atualizarProduto(idProduto, telaAtualizacao.getCampoNomeText(),
                                telaAtualizacao.getCampoMarcaText(), Double.parseDouble(telaAtualizacao.getCampoValorText()),
                                telaAtualizacao.getCampoTamanhoText(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                Integer.parseInt(telaAtualizacao.getCampoQuantidade())); // Atualiza a quantidade

                        // Atualiza a tabela após a atualização
                        carregarProdutos();

                        // Fecha a tela de atualização após a conclusão
                        telaAtualizacao.dispose();
                    }
                });
            }
        } else {
            // Se o cargo do funcionário não for "gerente", "estoquista" ou "repositor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para atualizar produtos.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_atualizarActionPerformed

    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
     String termoPesquisa1 = campoPesquisa.getText();
String termoPesquisa2 = campoPesquisa2.getText();
String tipoPesquisa1 = (String) jComboBoxNome.getSelectedItem();
String tipoPesquisa2 = (String) jComboBoxTam.getSelectedItem();

// Verificar se pelo menos um dos campos de pesquisa não está vazio
if (!termoPesquisa1.isEmpty() || !termoPesquisa2.isEmpty()) {
    try {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Realizar a pesquisa de acordo com os tipos selecionados
        ResultSet rs = null;
        if (!termoPesquisa1.isEmpty() && !termoPesquisa2.isEmpty()) {
            // Pesquisar por ambos os critérios
            if ("Nome".equalsIgnoreCase(tipoPesquisa1) && "Tam/Med".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorNomeETamanho(termoPesquisa1, termoPesquisa2);
            } else if ("Nome".equalsIgnoreCase(tipoPesquisa1) && "Quantidade".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorNomeEQuantidade(termoPesquisa1, Integer.parseInt(termoPesquisa2));
            } else if ("Marca".equalsIgnoreCase(tipoPesquisa1) && "Tam/Med".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorMarcaETamanho(termoPesquisa1, termoPesquisa2);
            } else if ("Marca".equalsIgnoreCase(tipoPesquisa1) && "Quantidade".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorMarcaEQuantidade(termoPesquisa1, Integer.parseInt(termoPesquisa2));
            }
        } else if (!termoPesquisa1.isEmpty()) {
            // Pesquisar apenas pelo primeiro critério
            if ("Nome".equalsIgnoreCase(tipoPesquisa1)) {
                rs = bancoDeDados.obterProdutosPorNome(termoPesquisa1);
            } else if ("Marca".equalsIgnoreCase(tipoPesquisa1)) {
                rs = bancoDeDados.obterProdutosPorMarca(termoPesquisa1);
            }
        } else if (!termoPesquisa2.isEmpty()) {
            // Pesquisar apenas pelo segundo critério
            if ("Tam/Med".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorTam(termoPesquisa2);
            } else if ("Quantidade".equalsIgnoreCase(tipoPesquisa2)) {
                rs = bancoDeDados.obterProdutosPorQuant(termoPesquisa2);
            }
        }

        // Preencher a tabela com os resultados da pesquisa
        if (rs != null) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String tamanho = rs.getString("tamanho");
                int quantidade = rs.getInt("quantidade");
                String dataHora = rs.getString("datahora");

                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição
                modeloTabela.addRow(new Object[]{id, nome, marca, valor, tamanho, quantidade, dataHoraFormatada});
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
} else {
    // Se ambos os campos de pesquisa estiverem vazios, exibir todos os produtos do estoque
    try {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Obter todos os produtos do estoque
        ResultSet rs = bancoDeDados.obterProdutos();

        // Preencher a tabela com os resultados da pesquisa
        if (rs != null) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String tamanho = rs.getString("tamanho");
                int quantidade = rs.getInt("quantidade");
                String dataHora = rs.getString("datahora");

                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição
                modeloTabela.addRow(new Object[]{id, nome, marca, valor, tamanho, quantidade, dataHoraFormatada});
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
    }
}



    }//GEN-LAST:event_pesquisarActionPerformed

    private void jComboBoxTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTamActionPerformed

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
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    private DefaultTableModel montarTabela() {

        String[] coluna = {"ID", "Produto", "Marca", "Valor", "Tamanho/Medida", "Quantidade", "Data/Hora"};
        DefaultTableModel tabela = new DefaultTableModel(coluna, 0);

        return tabela;
    }

    private void carregarProdutos() {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Carregar os produtos do banco de dados e adicionar à tabela
        // Este é um exemplo, você pode precisar ajustar de acordo com o seu banco de dados
        try {
            ResultSet rs = bancoDeDados.obterProdutos();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String tamanho = rs.getString("tamanho");
                int quantidade = rs.getInt("quantidade");
                String dataHora = rs.getString("datahora");

                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição
                Object[] rowData = new Object[]{id, nome, marca, valor, tamanho, quantidade, dataHoraFormatada};

                // Adicione a linha ao modelo da tabela
                modeloTabela.addRow(rowData);

                configurarRenderizadorQuantidade();

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }

    public String formatarDataHora(String dataHoraDoBanco) {
        // Formate a data e hora do banco de dados no formato desejado
        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHoraDoBanco, formatterEntrada);
        return dataHoraFormatada.format(formatterSaida);
    }

    private void configurarRenderizadorQuantidade() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Obtém o valor da quantidade na coluna
                int quantidade = Integer.parseInt(table.getValueAt(row, 5).toString());

                // Verifica se a quantidade é zero
                if (quantidade == 0) {
                    // Define a cor de fundo da linha como vermelho
                    c.setBackground(Color.RED);
                } else {
                    // Define a cor de fundo padrão da tabela
                    c.setBackground(table.getBackground());
                }
                return c;
            }
        };

        // Define o renderizador personalizado para todas as colunas
        for (int i = 0; i < tabelaProduto.getColumnCount(); i++) {
            tabelaProduto.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JTextField campoPesquisa2;
    private javax.swing.JButton excluir;
    private javax.swing.JComboBox<String> jComboBoxNome;
    private javax.swing.JComboBox<String> jComboBoxTam;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
