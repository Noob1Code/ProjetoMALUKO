/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.classes.Calculo;
import modelos.classes.Municipio;
import modelos.classes.TabelaController;
import modelos.classes.Ultilidades;

/**
 *
 * @author aluno
 */
public class TelaTabela extends javax.swing.JFrame {
    private TabelaController tabelaController;
    private List<Municipio> listaDeMuni = null;
    private Ultilidades ultilidades = null;
   

    /**
     * Creates new form Tabela
     */
    public TelaTabela() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializarComponentesCustomizados();
        tabelaController = new TabelaController();
    }

    private void inicializarComponentesCustomizados() {
       ultilidades = new Ultilidades();
       ultilidades.usuarioLogado(jLabel_NomeUsuario); // Exibe o usuário logado
       configurarEstiloComponentes(); // Aplica o estilo visual aos componentes
   }
    
    private void configurarEstiloComponentes() {
    ultilidades.padraoButaoMenu(jButton_Enviar);
    ultilidades.padraoButaoMenu(jButton_Dashboard);
    ultilidades.padraoButaoMenu(jButton_Deletar);
    ultilidades.padraoButaoMenu(jButton_Inserir);
    ultilidades.padraoButaoMenu(jButton_Ler);
    ultilidades.padraoButaoMenu(jButton_Sair);
    ultilidades.padraoButaoMenu(jButton_Buscar);
    ultilidades.padraoScroll(jScrollPane_Tabela);
    ultilidades.padraoTextFild(jTextField_Buscar);
    ultilidades.escParaFechar(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane_Tabela = new javax.swing.JScrollPane();
        jTable_Tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton_Dashboard = new javax.swing.JButton();
        jLabel_NomeUsuario = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jButton_Enviar = new javax.swing.JButton();
        jButton_Ler = new javax.swing.JButton();
        jButton_Inserir = new javax.swing.JButton();
        jButton_Deletar = new javax.swing.JButton();
        jTextField_Buscar = new javax.swing.JTextField();
        jButton_Buscar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código IBGE", "Municípios", "Microrregião", "Estado", "Região Geográfica", "Área Km2", "População", "Domicílios", "PIB Total", "IDH", "Renda Média", "Renda Nominal", "PEA Dia", "IDH Dimensão Educação", "IDH Dimensão Longevidade", "Densidade Demográfica", "Pib Per Capital", "IDH Class", "IDH Dimensão Educação Class", "IDH Dimensão Longevidade Class", "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable_Tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane_Tabela.setViewportView(jTable_Tabela);

        jPanel4.setBackground(new java.awt.Color(7, 164, 121));

        jButton_Dashboard.setText("Dashboard");
        jButton_Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DashboardActionPerformed(evt);
            }
        });

        jLabel_NomeUsuario.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel_NomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NomeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-usuário-15 black.png"))); // NOI18N
        jLabel_NomeUsuario.setText("felipeborges");
        jLabel_NomeUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButton_Sair.setText("SAIR");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jButton_Enviar.setText("Enviar para o banco");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jButton_Ler.setText("Ler");
        jButton_Ler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LerActionPerformed(evt);
            }
        });

        jButton_Inserir.setText("Inserir ");
        jButton_Inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InserirActionPerformed(evt);
            }
        });

        jButton_Deletar.setText("Deletar");
        jButton_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletarActionPerformed(evt);
            }
        });

        jButton_Buscar.setText("Buscar");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Dashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Ler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Deletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Inserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Enviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Buscar)
                .addGap(18, 18, 18)
                .addComponent(jLabel_NomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Sair)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Dashboard)
                    .addComponent(jLabel_NomeUsuario)
                    .addComponent(jButton_Sair)
                    .addComponent(jButton_Ler)
                    .addComponent(jButton_Deletar)
                    .addComponent(jButton_Inserir)
                    .addComponent(jButton_Enviar)
                    .addComponent(jButton_Buscar)
                    .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(7, 164, 121));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("URBANINFO - © 2024");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_Tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane_Tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void jButton_LerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LerActionPerformed
            DefaultTableModel modeloTabela = (DefaultTableModel) jTable_Tabela.getModel();
            tabelaController.carregarTabela(modeloTabela);
    }//GEN-LAST:event_jButton_LerActionPerformed

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
         tabelaController.enviarDadosParaBanco();
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jButton_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletarActionPerformed
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable_Tabela.getModel();
        int linhaSelecionada = jTable_Tabela.getSelectedRow();
        tabelaController.deletarRegistro(modeloTabela, linhaSelecionada);
    }//GEN-LAST:event_jButton_DeletarActionPerformed

    private void jButton_InserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InserirActionPerformed
        ultilidades.proximaTela("CasdastrarMunicipio", this, listaDeMuni);
    }//GEN-LAST:event_jButton_InserirActionPerformed

    private void jButton_DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DashboardActionPerformed
        ultilidades.proximaTela("Dashboard", this);
    }//GEN-LAST:event_jButton_DashboardActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        ultilidades.proximaTela("Login", this);
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable_Tabela.getModel();
        String textoBusca = jTextField_Buscar.getText().trim();
        tabelaController.buscarNaTabela(modeloTabela, textoBusca);
    }//GEN-LAST:event_jButton_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTabela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Dashboard;
    private javax.swing.JButton jButton_Deletar;
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Inserir;
    private javax.swing.JButton jButton_Ler;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_NomeUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane_Tabela;
    private javax.swing.JTable jTable_Tabela;
    private javax.swing.JTextField jTextField_Buscar;
    // End of variables declaration//GEN-END:variables
}
