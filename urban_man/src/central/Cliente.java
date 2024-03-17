package central;

import Dao.SessaoLogin;
import cadastro_atualizacao_venda.CadastroProduto;
import javax.swing.table.DefaultTableModel;
import Dao.daoCliente;
import Dao.daoFuncionario;
import cadastro_atualizacao_venda.AtualizarCliente;
import cadastro_atualizacao_venda.cadastroCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Cliente extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;
    private daoCliente bancoDeDados;

    public Cliente() {

        initComponents();
        bancoDeDados = new daoCliente();
        bancoDeDados.conectarCliente();
        modeloTabela = montarTabela();
        tabelaCliente.setModel(modeloTabela);
        carregarCliente();
        dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cadastrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        pesquisa = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        tabelaCliente.setModel(montarTabela());
        jScrollPane1.setViewportView(tabelaCliente);

        pesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pesquisa.setText("Pesquisar Cliente por :");

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente", permitir o cadastro de funcionários
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "atendente".equalsIgnoreCase(cargoFuncionario)) {

            cadastroCliente cd = new cadastroCliente();
            cd.setVisible(true);
            cd.setTitle("cadastro de Cliente");
            cd.setLocationRelativeTo(null);
            dispose();
        } else {
            // Se o cargo do funcionário não for "gerente", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para cadastrar clientes.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_cadastrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente" ou "atendente", permitir a atualização do cliente
        if ("gerente".equalsIgnoreCase(cargoFuncionario) || "atendente".equalsIgnoreCase(cargoFuncionario)) {
            int linhaSelecionada = tabelaCliente.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um Cliente para atualizar.");
            } else {
                int idCliente = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
                dispose();

                AtualizarCliente telaAtualizacao = new AtualizarCliente();
                telaAtualizacao.setVisible(true);
                telaAtualizacao.setTitle("Atualização de Cliente");
                telaAtualizacao.setLocationRelativeTo(null);

                telaAtualizacao.setCampoNomeText((String) modeloTabela.getValueAt(linhaSelecionada, 1));
                telaAtualizacao.setCampoCpfText((String) modeloTabela.getValueAt(linhaSelecionada, 2));
                telaAtualizacao.setCampoTelefoneText(String.valueOf(modeloTabela.getValueAt(linhaSelecionada, 3)));
                telaAtualizacao.setCampoEmailText((String) modeloTabela.getValueAt(linhaSelecionada, 4));
                telaAtualizacao.setCampoEnderecoText((String) modeloTabela.getValueAt(linhaSelecionada, 5));

                telaAtualizacao.adicionarActionListenerAoBotaoAtualizar(new java.awt.event.ActionListener() {
                   
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String novoNome = telaAtualizacao.getCampoNomeText();
                        String novoCpf = telaAtualizacao.getCampoCpfText();
                        String novoTelefone = telaAtualizacao.getCampoTelefoneText();
                        String novoEmail = telaAtualizacao.getCampoEmailText();
                        String novoEndereco = telaAtualizacao.getCampoEnderecoText();
                        String novaDataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // Obter a data e hora atuais

                        bancoDeDados.atualizarCliente(idCliente, novoNome, novoCpf, novoTelefone, novoEmail, novoEndereco, novaDataHora); // Atualizar cliente com a nova data e hora
                    }
                });
            }
        } else {
            // Se o cargo do funcionário não for "gerente" ou "atendente", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para atualizar clientes.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        // Verificar o cargo do funcionário
        SessaoLogin sessao = SessaoLogin.getInstance();
        String cargoFuncionario = sessao.getCargoFuncionario();

        // Se o cargo do funcionário for "gerente", permitir a exclusão do cliente
        if ("gerente".equalsIgnoreCase(cargoFuncionario)) {
            int linhaSelecionada = tabelaCliente.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.");
            } else {
                int idCliente = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

                // Remova a linha diretamente do modelo da tabela
                modeloTabela.removeRow(linhaSelecionada);

                // Atualize a tabela após a remoção (opcional)
                tabelaCliente.setModel(modeloTabela);

                // Remova o cliente do banco de dados
                bancoDeDados.removerCliente(idCliente);
            }
        } else {
            // Se o cargo do funcionário não for "gerente", exibir uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Você não tem permissão para excluir clientes.", "Acesso negado", JOptionPane.ERROR_MESSAGE);
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
    String termoPesquisa = campoPesquisa.getText();
    String tipoPesquisa = (String) jComboBox1.getSelectedItem();

    // Verificar se o campo de pesquisa está vazio
    if (termoPesquisa.isEmpty()) {
        // Se estiver vazio, recarregar todos os clientes
        carregarCliente();
    } else {
        // Se não estiver vazio, buscar clientes conforme o tipo de pesquisa selecionado
        try {
            // Limpar todas as linhas existentes na tabela
            while (modeloTabela.getRowCount() > 0) {
                modeloTabela.removeRow(0);
            }

            // Realizar a pesquisa de acordo com o tipo selecionado
            ResultSet rs = null;
            if ("Nome".equalsIgnoreCase(tipoPesquisa)) {
                // Pesquisar pelo nome do cliente
                rs = bancoDeDados.obterClientePorNome(termoPesquisa);
            } else if ("CPF".equalsIgnoreCase(tipoPesquisa)) {
                // Pesquisar pelo CPF do cliente
                rs = bancoDeDados.obterClientePorCpf(termoPesquisa);
            }

            // Preencher a tabela com os resultados da pesquisa
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String telefone = rs.getString("telefone");
                    String email = rs.getString("email");
                    String endereco = rs.getString("endereco");
                    String dataHora = rs.getString("datahora");
                    String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição

                    modeloTabela.addRow(new Object[]{id, nome, cpf, telefone, email, endereco, dataHoraFormatada});
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar a consulta SQL " + ex.getMessage());
        }
    }
       
    }//GEN-LAST:event_pesquisarActionPerformed

    private DefaultTableModel montarTabela() {

        String[] coluna = {"ID", "Nome", "CPF", "Telefone", "Email", "Endereço", "Data/Hora"};
        DefaultTableModel tabela = new DefaultTableModel(coluna, 0);

        return tabela;
    }

    private void carregarCliente() {
        // Limpar todas as linhas existentes na tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Carregar os produtos do daoProduto de dados e adicionar à tabela
        // Este é um exemplo, você pode precisar ajustar de acordo com o seu daoProduto de dados
        try {
            ResultSet rs = bancoDeDados.obterCliente();

            while (rs.next()) {

                int id = rs.getInt("ID");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String dataHora = rs.getString("datahora");
                String dataHoraFormatada = formatarDataHora(dataHora); // Formate a data para exibição

                modeloTabela.addRow(new Object[]{id, nome, cpf, telefone, email, endereco, dataHoraFormatada});
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables

    public String formatarDataHora(String dataHoraDoBanco) {
        // Formate a data e hora do banco de dados no formato desejado
        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHoraDoBanco, formatterEntrada);
        return dataHoraFormatada.format(formatterSaida);
    }
    
    
    
    
}

