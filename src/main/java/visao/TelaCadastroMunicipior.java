/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import banco.bancoDados;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import modelos.classes.Municipio;
import modelos.classes.Ultilidades;
import static modelos.constants.Constraints.setTextFieldDouble;
import static modelos.constants.Constraints.setTextFieldDoubleBetweenZeroAndOne;
import static modelos.constants.Constraints.setTextFieldInteger;
import static modelos.constants.Constraints.setTextFieldLettersAndSpaces;
import modelos.enums.Estado;
import modelos.enums.RegiaoGeografica;
import modelos.interfaces.Ibanco;

public class TelaCadastroMunicipior extends javax.swing.JFrame {
    private List<Municipio> listaMunicipios = null;
    private Ultilidades ultilidades = null;
    private Ibanco bd = null;
    //private TelaTabela tela = new TelaTabela();
        
    public TelaCadastroMunicipior() {
        initComponents();
        init(); 
    }
    
    public void setlist(List<Municipio> listaMunicipios){
        this.listaMunicipios = listaMunicipios;
    }
    
    public void init(){
        ultilidades = new Ultilidades();
        ultilidades.usuarioLogado(jLabel_NomeUsuario);
        
        ultilidades.escParaFechar(this);
        
        ultilidades.padraoTextFild(jTextField_IDH);
        setTextFieldDoubleBetweenZeroAndOne(jTextField_IDH);
        ultilidades.padraoTextFild(jTextField_IDHEducacao);
        setTextFieldDoubleBetweenZeroAndOne(jTextField_IDHEducacao);
        ultilidades.padraoTextFild(jTextField_IDHLogividade);
        setTextFieldDoubleBetweenZeroAndOne(jTextField_IDHLogividade);
        ultilidades.padraoTextFild(jTextField_AreaKM);
        setTextFieldInteger(jTextField_AreaKM);
        ultilidades.padraoTextFild(jTextField_CodigoIBGE);
        setTextFieldInteger(jTextField_CodigoIBGE);
        ultilidades.padraoTextFild(jTextField_Domicilio);
        setTextFieldInteger(jTextField_Domicilio);
        ultilidades.padraoTextFild(jTextField_Micro_Região);
        setTextFieldLettersAndSpaces(jTextField_Micro_Região);
        ultilidades.padraoTextFild(jTextField_Municipio);
        setTextFieldLettersAndSpaces(jTextField_Municipio);
        ultilidades.padraoTextFild(jTextField_PEADia);
        setTextFieldInteger(jTextField_PEADia);
        ultilidades.padraoTextFild(jTextField_PIB);
        setTextFieldDouble(jTextField_PIB);
        ultilidades.padraoTextFild(jTextField_Populacao);
        setTextFieldInteger(jTextField_Populacao);
        ultilidades.padraoTextFild(jTextField_RendaMedia);
        setTextFieldDouble(jTextField_RendaMedia);
        ultilidades.padraoTextFild(jTextField_RendaNominal);
        setTextFieldDouble(jTextField_RendaNominal);
        
        jButton_Salvar.setBorder(new EmptyBorder(5, 25, 5, 25));
        jButton_Salvar.setBackground(new Color(7, 164, 121));
        jButton_Salvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jButton_Voltar.setBorder(new EmptyBorder(5, 25, 5, 25));
        jButton_Voltar.setBackground(new Color(7, 164, 121));
        jButton_Voltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ultilidades.padraoButaoMenu(jButton_Sair);
        ultilidades.padraoButaoMenu(jButton_Dashboard);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_CodigoIBGE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Municipio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton_Voltar = new javax.swing.JButton();
        jButton_Salvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton_Dashboard = new javax.swing.JButton();
        jLabel_NomeUsuario = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Micro_Região = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_AreaKM = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_Populacao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_Domicilio = new javax.swing.JTextField();
        jTextField_PIB = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField_IDH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField_RendaMedia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField_RendaNominal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField_PEADia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_IDHEducacao = new javax.swing.JTextField();
        jTextField_IDHLogividade = new javax.swing.JTextField();
        jComboBox1_Estado = new javax.swing.JComboBox<>();
        jComboBox1_Geo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(7, 164, 121));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 164, 121));
        jLabel1.setText("NOVO MUNICIPIO");

        jTextField_CodigoIBGE.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_CodigoIBGE.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_CodigoIBGE.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(7, 164, 121));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 164, 121));
        jLabel7.setText("Código IBGE");

        jLabel8.setBackground(new java.awt.Color(7, 164, 121));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 164, 121));
        jLabel8.setText("Estado");

        jLabel9.setBackground(new java.awt.Color(7, 164, 121));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(7, 164, 121));
        jLabel9.setText("Município");

        jTextField_Municipio.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Municipio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_Municipio.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(7, 164, 121));

        jLabel2.setBackground(new java.awt.Color(7, 164, 121));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("URBANINFO - @2024");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton_Voltar.setBackground(new java.awt.Color(7, 164, 121));
        jButton_Voltar.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton_Voltar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-voltar-20.png"))); // NOI18N
        jButton_Voltar.setText("VOLTAR");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        jButton_Salvar.setBackground(new java.awt.Color(7, 164, 121));
        jButton_Salvar.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton_Salvar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-ok-20.png"))); // NOI18N
        jButton_Salvar.setText("SALVAR");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Salvar)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Voltar)
                    .addComponent(jButton_Salvar))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(7, 164, 121));

        jButton_Dashboard.setText("DashBoard");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Dashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jButton_Sair))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel10.setBackground(new java.awt.Color(7, 164, 121));
        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(7, 164, 121));
        jLabel10.setText("Micro-Região");

        jTextField_Micro_Região.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Micro_Região.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_Micro_Região.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(7, 164, 121));
        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(7, 164, 121));
        jLabel11.setText("Região Geográfica");

        jTextField_AreaKM.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_AreaKM.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_AreaKM.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setBackground(new java.awt.Color(7, 164, 121));
        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(7, 164, 121));
        jLabel12.setText("Área KM²");

        jTextField_Populacao.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Populacao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_Populacao.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setBackground(new java.awt.Color(7, 164, 121));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(7, 164, 121));
        jLabel13.setText("População");

        jLabel14.setBackground(new java.awt.Color(7, 164, 121));
        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(7, 164, 121));
        jLabel14.setText("Domicílios");

        jTextField_Domicilio.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Domicilio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_Domicilio.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_PIB.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_PIB.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_PIB.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setBackground(new java.awt.Color(7, 164, 121));
        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(7, 164, 121));
        jLabel15.setText("PIB Total (R$ mil)");

        jTextField_IDH.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_IDH.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_IDH.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setBackground(new java.awt.Color(7, 164, 121));
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(7, 164, 121));
        jLabel16.setText("IDH");

        jTextField_RendaMedia.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_RendaMedia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_RendaMedia.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setBackground(new java.awt.Color(7, 164, 121));
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(7, 164, 121));
        jLabel17.setText("Renda Média");

        jTextField_RendaNominal.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_RendaNominal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_RendaNominal.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setBackground(new java.awt.Color(7, 164, 121));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(7, 164, 121));
        jLabel18.setText("Renda Nomina");

        jTextField_PEADia.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_PEADia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_PEADia.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setBackground(new java.awt.Color(7, 164, 121));
        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(7, 164, 121));
        jLabel19.setText("PEA Dia");

        jLabel20.setBackground(new java.awt.Color(7, 164, 121));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(7, 164, 121));
        jLabel20.setText("IDH-Educação");

        jLabel21.setBackground(new java.awt.Color(7, 164, 121));
        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(7, 164, 121));
        jLabel21.setText("IDH-Longevidade");

        jTextField_IDHEducacao.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_IDHEducacao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_IDHEducacao.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_IDHLogividade.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_IDHLogividade.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField_IDHLogividade.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox1_Estado.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "GO" }));

        jComboBox1_Geo.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1_Geo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro-Oeste" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Micro_Região, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jComboBox1_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1_Geo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_CodigoIBGE, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_AreaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Populacao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_PIB, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_IDH, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_IDHEducacao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_IDHLogividade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_RendaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_RendaNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PEADia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_CodigoIBGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_Municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(43, 43, 43))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox1_Geo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Micro_Região, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField_AreaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField_Populacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField_Domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_PIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(0, 0, 0)
                            .addComponent(jTextField_RendaNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField_RendaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(0, 0, 0)
                            .addComponent(jTextField_PEADia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_IDHLogividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_IDHEducacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField_IDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
         try {
        // Capturar os dados do usuário diretamente dos campos de texto
        String codigoIBGE = jTextField_CodigoIBGE.getText();
        String municipio = jTextField_Municipio.getText();
        String microrregiao = jTextField_Micro_Região.getText();
        String estadoStr = jComboBox1_Estado.getSelectedItem().toString();
        String regiaoGeograficaStr = jComboBox1_Geo.getSelectedItem().toString();
        String areaKm2 = jTextField_AreaKM.getText();
        String populacao = jTextField_Populacao.getText();
        String domicilios = jTextField_Domicilio.getText();
        String pibTotal = jTextField_PIB.getText();
        String idh = jTextField_IDH.getText();
        String rendaMedia = jTextField_RendaMedia.getText();
        String rendaNominal = jTextField_RendaNominal.getText();
        String peaDia = jTextField_PEADia.getText();
        String idhEducacao = jTextField_IDHEducacao.getText();
        String idhLongevidade = jTextField_IDHLogividade.getText();

        // Validações: Verificar campos obrigatórios
        if (codigoIBGE == null || codigoIBGE.isEmpty() || municipio == null || municipio.isEmpty() ||
            microrregiao == null || microrregiao.isEmpty() || estadoStr == null || estadoStr.isEmpty() ||
            regiaoGeograficaStr == null || regiaoGeograficaStr.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.");
            return;
        }

        // Validação e conversão de enums
        Estado estado = null;
        RegiaoGeografica regiaoGeografica = null;

        try {
            estado = Estado.valueOf(estadoStr.toUpperCase()); // Conversão do estado para enum
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Estado inválido! Use uma sigla válida.");
            return;
        }

        try {
            regiaoGeografica = RegiaoGeografica.fromString(regiaoGeograficaStr); // Conversão da região para enum
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Região Geográfica inválida! Insira um valor válido.");
            return;
        }

        // Criar o objeto Município com os dados fornecidos
        Municipio novoMunicipio = new Municipio(
            codigoIBGE, municipio, microrregiao, estado, regiaoGeografica, 
            areaKm2, populacao, domicilios, pibTotal, idh, rendaMedia, 
            rendaNominal, peaDia, idhEducacao, idhLongevidade
        );

        // Criar lista para armazenamento
        listaMunicipios.add(novoMunicipio);
        
        
        // Inserir no banco
        bd = new bancoDados();
        bd.getConexao(); // Abre conexão
        bd.adicionarNoBanco(novoMunicipio); // Insere a lista
        bd.fecharConexao(); // Fecha conexão

        // Exibe mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Município inserido com sucesso!");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao adicionar município: " + ex.getMessage());
        ex.printStackTrace();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage());
        ex.printStackTrace();
    }

    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        ultilidades.proximaTela("Tabela", this);
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jButton_DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DashboardActionPerformed
        ultilidades.proximaTela("Dashboard", this);
    }//GEN-LAST:event_jButton_DashboardActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        ultilidades.proximaTela("Login", this);
    }//GEN-LAST:event_jButton_SairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroMunicipior.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMunicipior.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMunicipior.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMunicipior.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroMunicipior().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Dashboard;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JComboBox<String> jComboBox1_Estado;
    private javax.swing.JComboBox<String> jComboBox1_Geo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_NomeUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField_AreaKM;
    private javax.swing.JTextField jTextField_CodigoIBGE;
    private javax.swing.JTextField jTextField_Domicilio;
    private javax.swing.JTextField jTextField_IDH;
    private javax.swing.JTextField jTextField_IDHEducacao;
    private javax.swing.JTextField jTextField_IDHLogividade;
    private javax.swing.JTextField jTextField_Micro_Região;
    private javax.swing.JTextField jTextField_Municipio;
    private javax.swing.JTextField jTextField_PEADia;
    private javax.swing.JTextField jTextField_PIB;
    private javax.swing.JTextField jTextField_Populacao;
    private javax.swing.JTextField jTextField_RendaMedia;
    private javax.swing.JTextField jTextField_RendaNominal;
    // End of variables declaration//GEN-END:variables
}
