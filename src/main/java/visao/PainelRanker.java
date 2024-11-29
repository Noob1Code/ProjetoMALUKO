/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.table.DefaultTableModel;


import modelos.classes.DadosRanker;
import modelos.classes.Ultilidades;


public class PainelRanker extends javax.swing.JPanel {
    private List<DadosRanker> model;
    private String titulo;
    
    public PainelRanker() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
        init();
        
    }
    
    public void init(){
        Ultilidades ultilidade = new Ultilidades();
        ultilidade.padraoScroll(jScrollPane2);
    }
    
    public void setModel(List<DadosRanker> model, String titulo) {
        this.model = model;
        initData();
        this.titulo = titulo;
        jPanel_Titulo.add(new TituloGrafico(titulo));
    }
    
    public List<DadosRanker> getModel() {
        return model;
    }
    
    private void initData() {
        DefaultTableModel defaultmodel = (DefaultTableModel) jTable1.getModel();
        defaultmodel.setRowCount(0);
        for (DadosRanker data : model) {
            String[] linha = new String[4];
                linha[0] = String.valueOf(data.getClassificacao());
                linha[1] = String.valueOf(data.getCodigoIBGE());
                linha[2] = data.getMunicipio();
                linha[3] = String.valueOf(data.getValor());
                defaultmodel.addRow(linha);
        }
        jTable1.setModel(defaultmodel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Titulo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(187, 306));
        setRequestFocusEnabled(false);

        jPanel_Titulo.setOpaque(false);
        jPanel_Titulo.setLayout(new javax.swing.BoxLayout(jPanel_Titulo, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane2.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Posição ", "CodigoIBGE", "Municipio", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jPanel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel_Titulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
