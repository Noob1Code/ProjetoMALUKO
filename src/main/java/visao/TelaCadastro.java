/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import banco.bancoDados;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import modelos.classes.Ultilidades;
import modelos.classes.Usuario;
import modelos.classes.Validacao;
import static modelos.constants.Constraints.setTextFieldInteger;
import static modelos.constants.Constraints.setTextFieldMaxLength;
import modelos.interfaces.IValidacao;
import modelos.interfaces.Ibanco;

public class TelaCadastro extends javax.swing.JFrame {

    private Ultilidades ultilidades = null;
    private Ibanco bd = null;
    private IValidacao validar = null;

    public TelaCadastro() {
        initComponents();
        init();
    }

    public void init() {
        ultilidades = new Ultilidades();
        ultilidades.escParaFechar(this);
        ultilidades.padraoTextFild(jTextField_Nome);
        ultilidades.padraoTextFild(jTextField_CPF);
        setTextFieldMaxLength(jTextField_CPF, 11);
        ultilidades.padraoPasswordField(jPasswordField_Senha);
        setTextFieldInteger(jPasswordField_Senha);
        ultilidades.padraoPasswordField(jPasswordField_ConfirmarSenha);
        setTextFieldInteger(jPasswordField_ConfirmarSenha);

        jComboBox_Sexo.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 3, 0));
        jComboBox_Sexo.setBackground(new Color(230, 245, 241));
        jComboBox_Sexo.setForeground(Color.decode("#7A8C8D"));
        jComboBox_Sexo.setFont(new java.awt.Font("sansserif", 0, 13));

        jButton1.setBorder(new EmptyBorder(5, 25, 5, 25));
        jButton1.setBackground(new Color(7, 164, 121));
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jButton2.setBorder(new EmptyBorder(5, 25, 5, 25));
        jButton2.setBackground(new Color(7, 164, 121));
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Nome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_CPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField_Senha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField_ConfirmarSenha = new javax.swing.JPasswordField();
        jComboBox_Sexo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(7, 164, 121));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 164, 121));
        jLabel1.setText("BEM-VINDO AO URBANINFO");

        jTextField_Nome.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Nome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_Nome.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(7, 164, 121));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-ok-20.png"))); // NOI18N
        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(7, 164, 121));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 164, 121));
        jLabel4.setText("Sexo");

        jLabel7.setBackground(new java.awt.Color(7, 164, 121));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 164, 121));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-usuário-15.png"))); // NOI18N
        jLabel7.setText("Nome Completo");

        jButton2.setBackground(new java.awt.Color(7, 164, 121));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-voltar-20.png"))); // NOI18N
        jButton2.setText("VOLTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(7, 164, 121));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 164, 121));
        jLabel2.setText("URBANINFO - @2024");

        jLabel8.setBackground(new java.awt.Color(7, 164, 121));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 164, 121));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-reticências-15 (1).png"))); // NOI18N
        jLabel8.setText("CPF");

        jTextField_CPF.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_CPF.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_CPF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(7, 164, 121));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 164, 121));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-senha-15.png"))); // NOI18N
        jLabel5.setText("Senha");

        jPasswordField_Senha.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField_Senha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPasswordField_Senha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(7, 164, 121));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(7, 164, 121));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-senha-15.png"))); // NOI18N
        jLabel6.setText("Confirma Senha");

        jPasswordField_ConfirmarSenha.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField_ConfirmarSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPasswordField_ConfirmarSenha.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox_Sexo.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox_Sexo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "Masculino", "Feminino", "Anormal" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 306, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_CPF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_Nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField_ConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(jTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(jPasswordField_ConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            validar = new Validacao();
            String nome = jTextField_Nome.getText();
            String sexo = jComboBox_Sexo.getSelectedItem().toString();
            String cpf = jTextField_CPF.getText();
            String senha = new String(jPasswordField_Senha.getPassword());
            String confirmarSenha = new String(jPasswordField_ConfirmarSenha.getPassword());

            // Validações
            if (!nome.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "O nome deve conter apenas letras e espaços.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!validar.validarCPF(cpf)) {
                JOptionPane.showMessageDialog(this, "O CPF invalido", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!senha.equals(confirmarSenha)) {
                JOptionPane.showMessageDialog(this, "As senhas não coincidem.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar objeto de usuário
            Usuario novoUser = new Usuario(nome, sexo, cpf, senha, confirmarSenha);

            // Criar lista para armazenamento
            List<Usuario> listaUsuario = new LinkedList<>();
            listaUsuario.add(novoUser);

            // Inserir no banco
            bd = new bancoDados();
            bd.getConexao(); // Abre conexão

            try {
                bd.inserirUsuario(listaUsuario); // Tenta inserir o usuário no banco
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                ultilidades.proximaTela("Login", this);
            } catch (SQLException ex) {
                // Se o CPF já existir, exibe mensagem personalizada
                if (ex.getMessage().contains("O CPF")) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                bd.fecharConexao(); // Fecha a conexão com o banco de dados
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ultilidades.proximaTela("Login", this);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_Sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_ConfirmarSenha;
    private javax.swing.JPasswordField jPasswordField_Senha;
    private javax.swing.JTextField jTextField_CPF;
    private javax.swing.JTextField jTextField_Nome;
    // End of variables declaration//GEN-END:variables
}
