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
import modelos.classes.DadosGrafico;

/**
 *
 * @author NOTE FELIPE
 */
public class PainelGrafico extends javax.swing.JPanel {
    
    private String titulo;
    private List<DadosGrafico> model;
    
    public PainelGrafico() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
    }
    
    public List<DadosGrafico> getModel() {
        return model;
    }

    public void setModel(List<DadosGrafico> model, String titulo) {
        this.model = model;
        initData();
        this.titulo = titulo;
        jPanel_dados1.add(new TituloGrafico(titulo));
    }

    private void initData() {
        grafico1.removeAllData();
        if (model != null) {
            for (DadosGrafico data : model) {
                grafico1.addItem(data);
                jPanel_dados.add(new ItemGrafico(data));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grafico1 = new visao.Grafico();
        jPanel_dados = new javax.swing.JPanel();
        jPanel_dados1 = new javax.swing.JPanel();

        javax.swing.GroupLayout grafico1Layout = new javax.swing.GroupLayout(grafico1);
        grafico1.setLayout(grafico1Layout);
        grafico1Layout.setHorizontalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        grafico1Layout.setVerticalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        jPanel_dados.setOpaque(false);
        jPanel_dados.setLayout(new javax.swing.BoxLayout(jPanel_dados, javax.swing.BoxLayout.Y_AXIS));

        jPanel_dados1.setOpaque(false);
        jPanel_dados1.setLayout(new javax.swing.BoxLayout(jPanel_dados1, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grafico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_dados1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_dados1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private visao.Grafico grafico1;
    private javax.swing.JPanel jPanel_dados;
    private javax.swing.JPanel jPanel_dados1;
    // End of variables declaration//GEN-END:variables
}
