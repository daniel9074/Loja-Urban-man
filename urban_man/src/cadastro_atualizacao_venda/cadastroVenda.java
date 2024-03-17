package cadastro_atualizacao_venda;

import Dao.daoCliente;
import Dao.daoFuncionario;
import Dao.daoProduto;
import Dao.daoVenda;
import central.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class cadastroVenda extends javax.swing.JFrame {

    private daoProduto dao;

    public cadastroVenda() {

        initComponents();
        daoProduto dao = new daoProduto();
        daoCliente dao1 = new daoCliente();
        daoFuncionario dao3 = new daoFuncionario();
        dao.conectarProduto();
        dao1.conectarCliente();
        dao3.conectarFuncionario();

        if (dao.conectarProduto()) {
            try {
                ResultSet rsIdsProdutos = dao.obterIdsProdutos();

                while (rsIdsProdutos.next()) {
                    int id = rsIdsProdutos.getInt("id");
                    int quantidade = dao.obterQuantidadeProduto(id);

                    jComboBoxProdutos1.addItem(String.valueOf(id));

                }
            } catch (SQLException ex) {
                System.out.println("Erro ao preencher o JComboBox com os IDs dos produtos: " + ex.getMessage());
            } finally {
                dao.desconectarProduto(); // Certifique-se de desconectar o banco de dados após obter os IDs
            }
        } else {
            System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
        }

        jComboBoxProdutos1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame um método para exibir as informações do produto selecionado
                exibirInformacoesProdutoSelecionado();

            }
        });

        if (dao1.conectarCliente()) {

            ResultSet rsIdsProdutos = dao1.obterIdsCliente();

            try {
                while (rsIdsProdutos.next()) {

                    jComboBoxCliente.addItem(String.valueOf(rsIdsProdutos.getInt("id")));
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao preencher o JComboBox com os IDs dos produtos: " + ex.getMessage());
            } finally {
                dao1.desconectarCliente(); // Certifique-se de desconectar o banco de dados após obter os IDs
            }
        } else {
            System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
        }

        jComboBoxCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame um método para exibir as informações do produto selecionado
                exibirInformacoesClienteSelecionado();
            }
        });

        if (dao3.conectarFuncionario()) {
            ResultSet rsIdsFuncionario = dao3.obterIdsFuncionario();

            try {
                while (rsIdsFuncionario.next()) {
                    jComboBoxFuncionario.addItem(String.valueOf(rsIdsFuncionario.getInt("id")));
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao preencher o JComboBox com os IDs dos produtos: " + ex.getMessage());
            } finally {
                dao.desconectarProduto(); // Certifique-se de desconectar o banco de dados após obter os IDs
            }
        } else {
            System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
        }

        jComboBoxFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame um método para exibir as informações do produto selecionado
                exibirInformacoesFuncionarioSelecionado();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sair = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        jComboBoxFuncionario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProdutos1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        campoQuantidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelProduto = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        funcionario = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        cpfFunc = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelTamanho = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("escolha um Produto :");

        sair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        continuar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        continuar.setText("Continuar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        jComboBoxFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione uma opção" }));
        jComboBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFuncionarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Dados do Cliente :");

        jComboBoxProdutos1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxProdutos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione uma opção" }));
        jComboBoxProdutos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutos1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Dados do Funcionario :");

        jComboBoxCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione uma opção" }));
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Quantidade :");

        campoQuantidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQuantidadeActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelProduto.setText("Produto :");

        jLabelMarca.setText("Marca:");

        jLabelValor.setText("Valor:");

        jLabelCliente.setText("Cliente :");

        jLabelTelefone.setText("Telefone :");

        jLabelCpf.setText("CPF :");

        funcionario.setText("Funcionario :");

        cargo.setText("Cargo : ");

        cpfFunc.setText("CPF :");

        jLabelEmail.setText("Email :");

        jLabelTamanho.setText("Tamanho:");

        jLabelEndereco.setText("Endereço :");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Dados Cadastrais :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(funcionario, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(cpfFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(jLabelValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcionario))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarca)
                    .addComponent(jLabelCpf)
                    .addComponent(cpfFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jLabelTelefone)
                    .addComponent(cargo))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelTamanho))
                .addGap(34, 34, 34)
                .addComponent(jLabelEndereco)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continuar)
                    .addComponent(sair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

        Venda v = new Venda();
        v.setVisible(true);
        v.setTitle("Venda");
        v.setLocationRelativeTo(null);
        dispose();


    }//GEN-LAST:event_sairActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed

        if (jComboBoxProdutos1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto.", "Produto não selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (jComboBoxCliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente.", "Cliente não selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (jComboBoxFuncionario.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um funcionário.", "Funcionário não selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String quantidadeTexto = campoQuantidade.getText().trim();
        if (quantidadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida.", "Quantidade não especificada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int quantidadeVendida;
       
        try {
            quantidadeVendida = Integer.parseInt(quantidadeTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A quantidade deve ser um número inteiro válido.", "Quantidade inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (quantidadeVendida <= 0) {
            JOptionPane.showMessageDialog(this, "A quantidade do produto deve ser maior que zero.", "Quantidade inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String produtoVendido = (String) jComboBoxProdutos1.getSelectedItem();
        int idProdutoVendido = Integer.parseInt(produtoVendido);

// Verifica se a quantidade disponível em estoque é suficiente
        daoProduto daoProduto = new daoProduto();
        daoProduto.conectarProduto();
       
        int quantidadeAtual = daoProduto.obterQuantidadeProduto(idProdutoVendido);

        if (quantidadeAtual < quantidadeVendida) {
            JOptionPane.showMessageDialog(this, "A quantidade do produto é insuficiente.\nQuantidade em estoque: "+quantidadeAtual, "Quantidade insuficiente", JOptionPane.WARNING_MESSAGE);
            daoProduto.desconectarProduto();
            return;
        }

// Se a quantidade em estoque for suficiente, proceda com a venda
// Obtém os dados da venda da classe cadastroVenda
        String[] dadosVenda = obterDadosVenda();

        daoVenda dao = new daoVenda();
        dao.conectarVenda();

        double valorTotal = Double.parseDouble(dadosVenda[2]) * quantidadeVendida;

        dao.inserirDadosVenda(
                dadosVenda[0], dadosVenda[1], valorTotal, dadosVenda[3],
                dadosVenda[4], dadosVenda[5], dadosVenda[6], dadosVenda[7],
                dadosVenda[8], dadosVenda[9], dadosVenda[10], dadosVenda[11],
                dadosVenda[12], quantidadeVendida
        );

// Remover a quantidade especificada do produto vendido do banco de dados
        daoProduto.removerQuantidadeProduto(idProdutoVendido, quantidadeVendida);

// Atualiza a quantidade restante após a remoção
        int quantidadeRestante = quantidadeAtual - quantidadeVendida;

// Remover o produto da combobox se a quantidade for zero ou menor
        if (quantidadeRestante <= 0) {
            ((DefaultComboBoxModel) jComboBoxProdutos1.getModel()).removeElement(produtoVendido);
        }

        daoProduto.desconectarProduto();

        JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_continuarActionPerformed

    private void jComboBoxProdutos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutos1ActionPerformed


    }//GEN-LAST:event_jComboBoxProdutos1ActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jComboBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFuncionarioActionPerformed


    }//GEN-LAST:event_jComboBoxFuncionarioActionPerformed

    private void campoQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoQuantidadeActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroVenda().setVisible(true);
            }
        });
    }

    private void exibirInformacoesProdutoSelecionado() {
        daoProduto dao = new daoProduto();

        try {
            if (dao.conectarProduto()) {
                String selectedOption = (String) jComboBoxProdutos1.getSelectedItem();

                // Verifique se a opção selecionada não é "selecione uma opção"
                if (!selectedOption.equals("selecione uma opção")) {
                    int idSelecionado = Integer.parseInt(selectedOption);

                    // Use um método na sua classe daoProduto para obter as informações do produto
                    ResultSet rsProduto = dao.obterInformacoesProduto(idSelecionado);

                    if (rsProduto.next()) {
                        // Atualize as labels com as informações obtidas do ResultSet
                        jLabelProduto.setText("Produto: " + rsProduto.getString("nome"));
                        jLabelMarca.setText("Marca: " + rsProduto.getString("marca"));
                        jLabelValor.setText("Valor: " + rsProduto.getDouble("valor"));
                        jLabelTamanho.setText("Tamanho: " + rsProduto.getString("tamanho"));

                    }
                } else {
                    // Caso "selecione uma opção" seja escolhido, limpe as labels
                    jLabelProduto.setText("Produto: ");
                    jLabelMarca.setText("Marca: ");
                    jLabelValor.setText("Valor: ");
                    jLabelTamanho.setText("Tamanho: ");
                }
            } else {
                System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Erro ao exibir informações do produto: " + ex.getMessage());
        } finally {
            dao.desconectarProduto(); // Certifique-se de desconectar o banco de dados após obter as informações
        }
    }

    private void exibirInformacoesClienteSelecionado() {
        daoCliente dao = new daoCliente();

        try {
            if (dao.conectarCliente()) {
                String selectedOption = (String) jComboBoxCliente.getSelectedItem();

                // Verifique se a opção selecionada não é "selecione uma opção"
                if (!selectedOption.equals("selecione uma opção")) {
                    int idSelecionado = Integer.parseInt(selectedOption);

                    // Use um método na sua classe daoCliente para obter as informações do cliente
                    ResultSet rsCliente = dao.obterInformacoesCliente(idSelecionado);

                    if (rsCliente.next()) {
                        // Atualize as labels com as informações obtidas do ResultSet
                        jLabelCliente.setText("Cliente: " + rsCliente.getString("nome"));
                        jLabelCpf.setText("CPF: " + rsCliente.getString("cpf"));
                        jLabelTelefone.setText("Telefone: " + rsCliente.getString("telefone"));
                        jLabelEmail.setText("Email: " + rsCliente.getString("email"));
                        jLabelEndereco.setText("Endereço: " + rsCliente.getString("endereco"));
                    }
                } else {
                    // Caso "selecione uma opção" seja escolhido, limpe as labels
                    jLabelCliente.setText("Cliente: ");
                    jLabelCpf.setText("CPF: ");
                    jLabelTelefone.setText("Telefone: ");
                    jLabelEmail.setText("Email: ");
                    jLabelEndereco.setText("Endereço: ");
                }
            } else {
                System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Erro ao exibir informações do cliente: " + ex.getMessage());
        } finally {
            dao.desconectarCliente();// Certifique-se de desconectar o banco de dados após obter as informações
        }
    }

    private void exibirInformacoesFuncionarioSelecionado() {
        daoFuncionario dao = new daoFuncionario();

        try {
            if (dao.conectarFuncionario()) {
                String selectedOption = (String) jComboBoxFuncionario.getSelectedItem();

                // Verifique se a opção selecionada não é "selecione uma opção"
                if (!selectedOption.equals("selecione uma opção")) {
                    int idSelecionado = Integer.parseInt(selectedOption);

                    // Use um método na sua classe daoCliente para obter as informações do cliente
                    ResultSet rsFuncionario = dao.obterInformacoesFuncionario(idSelecionado);

                    if (rsFuncionario.next()) {
                        // Atualize as labels com as informações obtidas do ResultSet
                        funcionario.setText("Funcionario: " + rsFuncionario.getString("nome"));
                        cpfFunc.setText("CPF: " + rsFuncionario.getString("cpf"));
                        cargo.setText("Cargo: " + rsFuncionario.getString("cargo"));

                    }
                } else {
                    // Caso "selecione uma opção" seja escolhido, limpe as labels                   
                    funcionario.setText("Funcionario: ");
                    cpfFunc.setText("CPF: ");
                    cargo.setText("Cargo: ");
                }
            } else {
                System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Erro ao exibir informações do cliente: " + ex.getMessage());
        } finally {
            dao.desconectarFuncionario();// Certifique-se de desconectar o banco de dados após obter as informações
        }
    }

    public String[] obterDadosVenda() {
        String[] dados = new String[14];
        dados[0] = jLabelProduto.getText().replace("Produto: ", "");
        dados[1] = jLabelMarca.getText().replace("Marca: ", "");
        dados[2] = jLabelValor.getText().replace("Valor: ", "");
        dados[3] = jLabelTamanho.getText().replace("Tamanho: ", "");
        dados[4] = jLabelCliente.getText().replace("Cliente:", ""); // Preencha com os dados do cliente, CPF, telefone, etc.
        dados[5] = jLabelCpf.getText().replace("CPF:", "");
        dados[6] = jLabelTelefone.getText().replace("Telefone:", "");
        dados[7] = jLabelEmail.getText().replace("Email:", "");
        dados[8] = jLabelEndereco.getText().replace("Endereço:", "");
        dados[9] = funcionario.getText().replace("Funcionario:", "");
        dados[10] = cpfFunc.getText().replace("Cpf:", "");
        dados[11] = cargo.getText().replace("Cargo:", "");
        // Adicionar data e hora formatada para o padrão do MySQL
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);
        dados[12] = dataHoraFormatada;
        dados[13] = campoQuantidade.getText();

        return dados;
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
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JLabel cargo;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel cpfFunc;
    private javax.swing.JLabel funcionario;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxFuncionario;
    private javax.swing.JComboBox<String> jComboBoxProdutos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
