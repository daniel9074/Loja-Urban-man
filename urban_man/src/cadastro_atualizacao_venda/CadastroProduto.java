package cadastro_atualizacao_venda;

import Dao.SessaoLogin;
import javax.swing.JOptionPane;
import central.Produtos;
import java.io.FileWriter;
import central.Produtos;
import Dao.daoProduto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastroProduto extends javax.swing.JFrame {

   

    public CadastroProduto() {
        initComponents();

    }

   private void cadastrarNoBancoDeDados() {
 
     // Obtenha os dados dos campos de texto
    String nome = campoNome.getText();
    String marca = campoMarca.getText();
    Double valor = Double.parseDouble(campoValor.getText());
    String tamanho = campoQuantidadre.getText();
    int quantidade = Integer.parseInt(campoQuantidadre.getText());
    
    // Obtenha a data e hora atuais
    LocalDateTime dataHoraAtual = LocalDateTime.now();
    
    // Formate a data e hora atual no formato correto para o MySQL
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dataHoraFormatada = dataHoraAtual.format(formatter);
    
    // Formate a data e hora atual para exibição
    String dataHoraFormatadaParaExibicao = formatarDataHora(dataHoraFormatada);

    // Realize a operação de inserção no banco de dados
    daoProduto bd = new daoProduto();

    if (bd.conectarProduto()) {
        // Execute a inserção
        bd.inserirProdutoComDataHora(nome, marca, valor, tamanho, dataHoraFormatada,quantidade);
        
        // Limpe os campos após a inserção
        campoNome.setText("");
        campoMarca.setText("");
        campoValor.setText("");
        campoTamanho1.setText("");
        campoQuantidadre.setText("");
        
        // Desconecte do banco de dados
        bd.desconectarProduto();
        
        // Exiba a data formatada
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!!!");
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







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoMarca = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoValor = new javax.swing.JTextField();
        botaoSair = new javax.swing.JButton();
        campoQuantidadre = new javax.swing.JTextField();
        botaoCadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoTamanho1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Marca :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Valor :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Produto :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tam/Med :");

        campoMarca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMarcaActionPerformed(evt);
            }
        });

        campoNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        campoValor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorActionPerformed(evt);
            }
        });

        botaoSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        campoQuantidadre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoQuantidadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQuantidadreActionPerformed(evt);
            }
        });

        botaoCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCadastrar.setText("cadastrar");
        botaoCadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade :");

        campoTamanho1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoTamanho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTamanho1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTamanho1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(campoValor)
                    .addComponent(campoMarca)
                    .addComponent(campoNome)
                    .addComponent(campoQuantidadre))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTamanho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 93, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCadastrar)
                            .addComponent(botaoSair))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoQuantidadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
     
    }//GEN-LAST:event_campoNomeActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed

        Produtos p = new Produtos();
        p.setVisible(true);
        p.setTitle("tela de produtos");
        p.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed

      // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();
    
        // Se o cargo do funcionário for "gerente", "estoquista" ou "repositor", permitir o cadastro do produto
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "estoquista".equalsIgnoreCase(cargoFuncionario) || "repositor".equalsIgnoreCase(cargoFuncionario)) {
            cadastrarNoBancoDeDados();
        } else {
            // Se o cargo do funcionário não for "gerente", "estoquista" ou "repositor", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar produtos.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }
             
        
      

    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void campoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMarcaActionPerformed
       
    }//GEN-LAST:event_campoMarcaActionPerformed

    private void campoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorActionPerformed
       
    }//GEN-LAST:event_campoValorActionPerformed

    private void campoQuantidadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQuantidadreActionPerformed
    
    }//GEN-LAST:event_campoQuantidadreActionPerformed

    private void campoTamanho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTamanho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTamanho1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

   


    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoQuantidadre;
    private javax.swing.JTextField campoTamanho1;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
