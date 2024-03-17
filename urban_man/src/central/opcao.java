package central;

import Dao.SessaoLogin;
import javax.swing.JOptionPane;

public class opcao extends javax.swing.JFrame {

    public opcao() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        produto = new javax.swing.JButton();
        venda = new javax.swing.JButton();
        funcionario = new javax.swing.JButton();
        cliente = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        produto.setBackground(new java.awt.Color(204, 204, 204));
        produto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        produto.setForeground(new java.awt.Color(0, 0, 0));
        produto.setText("Consultar Produtos");
        produto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        produto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoActionPerformed(evt);
            }
        });

        venda.setBackground(new java.awt.Color(204, 204, 204));
        venda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        venda.setForeground(new java.awt.Color(0, 0, 0));
        venda.setText("Consultar Venda");
        venda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        venda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaActionPerformed(evt);
            }
        });

        funcionario.setBackground(new java.awt.Color(204, 204, 204));
        funcionario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        funcionario.setForeground(new java.awt.Color(0, 0, 0));
        funcionario.setText("Gerente/Funcionario");
        funcionario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        funcionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioActionPerformed(evt);
            }
        });

        cliente.setBackground(new java.awt.Color(204, 204, 204));
        cliente.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cliente.setForeground(new java.awt.Color(0, 0, 0));
        cliente.setText("Consultar Cliente");
        cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });

        sair.setBackground(new java.awt.Color(204, 204, 204));
        sair.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sair.setForeground(new java.awt.Color(0, 0, 0));
        sair.setText("Sair");
        sair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione uma opção :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(funcionario)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(venda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(cliente)
                .addGap(28, 28, 28)
                .addComponent(produto)
                .addGap(32, 32, 32)
                .addComponent(funcionario)
                .addGap(40, 40, 40)
                .addComponent(sair)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed

        Produtos p = new Produtos();
        p.setVisible(true);
        p.setTitle("tela de produtos");
        p.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_produtoActionPerformed

    private void vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaActionPerformed

        Venda v = new Venda();
        v.setVisible(true);
        v.setTitle("Venda");
        v.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_vendaActionPerformed

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente", permitir o cadastro de funcionários
        if ("gerente".equalsIgnoreCase(cargoFuncionario)) {
            Funcionario f = new Funcionario();
            f.setVisible(true);
            f.setTitle("Gerente/Funcionario");
            f.setLocationRelativeTo(null);
            dispose();
        } else {
            // Se o cargo do funcionário não for "gerente", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Somente Administradores.", "Acesso Restrito", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_funcionarioActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed

        Cliente c = new Cliente();
        c.setVisible(true);
        c.setTitle("Tela do cliente");
        c.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_clienteActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
        tela_login tl = new tela_login();
        tl.setVisible(true);
        tl.setTitle("tela de login");
        tl.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_sairActionPerformed

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
            java.util.logging.Logger.getLogger(opcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opcao().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cliente;
    private javax.swing.JButton funcionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton produto;
    private javax.swing.JButton sair;
    private javax.swing.JButton venda;
    // End of variables declaration//GEN-END:variables

}
