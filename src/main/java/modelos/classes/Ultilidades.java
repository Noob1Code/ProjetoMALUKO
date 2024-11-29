/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import banco.bancoDados;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import modelos.interfaces.Ibanco;
import visao.TelaCadastro;
import visao.TelaCadastroMunicipior;
import visao.TelaDashboard;
import visao.TelaLogin;
import visao.TelaTabela;

/**
 *
 * @author NOTE FELIPE
 */
public class Ultilidades {
    
    private TelaCadastro telaC = null;
    private TelaLogin telaL = null;
    private TelaDashboard telaD = null;
    private TelaTabela telaT = null;
    private TelaCadastroMunicipior telaM = null; 
    
    private Ibanco bd = null;
    
    private String nome = "";
    
    private List<DadosGrafico> listIDH = new ArrayList<>();
    private List<DadosGrafico> listIDHEdu = new ArrayList<>();
    private List<DadosGrafico> listIDHLon = new ArrayList<>();
    
    public Ultilidades(){    
    }

    public void proximaTela(String proximatela, JFrame anteriotela){
        if(proximatela.equals("Login")){
        TelaLogin tela = new TelaLogin();
        anteriotela.dispose();
        tela.setVisible(true);
        return;
        }
        if(proximatela.equals("Cadastro")){
        TelaCadastro tela = new TelaCadastro();
        anteriotela.dispose();
        tela.setVisible(true);
        return;
        }
        if(proximatela.equals("Dashboard")){
        TelaDashboard tela = new TelaDashboard();
        anteriotela.dispose();
        tela.setVisible(true);
        return;
        }
        if(proximatela.equals("Tabela")){
        TelaTabela tela = new TelaTabela();
        anteriotela.dispose();
        tela.setVisible(true);
        return;
        }
    }
    
    public void proximaTela(String proximatela, JFrame anteriotela, List<Municipio> listaDeMuni){
        if(proximatela.equals("CasdastrarMunicipio")){
        TelaCadastroMunicipior tela = new TelaCadastroMunicipior();
        tela.setlist(listaDeMuni);
        anteriotela.dispose();
        tela.setVisible(true);
        return;
        }
    }
    
    public void padraoTextFild(JTextField text){
        text.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text.setBackground(new Color(230, 245, 241));
        text.setForeground(Color.decode("#7A8C8D"));
        text.setFont(new java.awt.Font("sansserif", 0, 13));
        text.setSelectionColor(new Color(75, 175, 152));
    }
    
    public void padraoPasswordField(JPasswordField text){
        text.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text.setBackground(new Color(230, 245, 241));
        text.setForeground(Color.decode("#7A8C8D"));
        text.setFont(new java.awt.Font("sansserif", 0, 13));
        text.setSelectionColor(new Color(75, 175, 152));
    }

    public void usuarioLogado(JLabel text){
        text.setText(nome);
        text.setFont(new java.awt.Font("sansserif", 0, 13));
    }
    
    public void padraoButaoMenu(JButton button){
        button.setBorder(new EmptyBorder(5, 25, 5, 25));
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.decode("#7A8C8D"));
        button.setFont(new java.awt.Font("sansserif", 0, 15));
        button.setForeground(new Color(7,164,121));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void carregarIDH(String idh) throws Exception{
        bd = new bancoDados();
        
        List<String> list = bd.pesquisaIDH(idh);
        
        int muitoalto = 0;
        int alto = 0;
        int Medio = 0;
        int baixo = 0;
               
        for(String a:list){
            if(a.equals("Muito Alto"))muitoalto++;
            if(a.equals("Alto"))alto++;
            if(a.equals("Médio"))Medio++;
            if(a.equals("Baixo"))baixo++;
        }
        
        if(idh.contains("IDH_Class")){ 
        listIDH.add(new DadosGrafico("Muito Alto", muitoalto, Color.GREEN));
        listIDH.add(new DadosGrafico("Alto", alto, Color.BLUE));
        listIDH.add(new DadosGrafico("Médio", Medio, Color.RED));
        listIDH.add(new DadosGrafico("Baixo", baixo, Color.YELLOW));
        return;
        }
        if(idh.contains("IDH_Educacao_Class")){ 
        listIDHEdu.add(new DadosGrafico("Muito Alto", muitoalto, Color.GREEN));
        listIDHEdu.add(new DadosGrafico("Alto", alto, Color.BLUE));
        listIDHEdu.add(new DadosGrafico("Médio", Medio, Color.RED));
        listIDHEdu.add(new DadosGrafico("Baixo", baixo, Color.YELLOW));
        return;
        }
        if(idh.contains("IDH_Longevidade_Class")){ 
        listIDHLon.add(new DadosGrafico("Muito Alto", muitoalto, Color.GREEN));
        listIDHLon.add(new DadosGrafico("Alto", alto, Color.BLUE));
        listIDHLon.add(new DadosGrafico("Médio", Medio, Color.RED));
        listIDHLon.add(new DadosGrafico("Baixo", baixo, Color.YELLOW));
        return;
        }
    }
    
    public void padraoScroll(JScrollPane jScrollPane1){
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        // Personaliza a barra de rolagem vertical
        JScrollBar verticalBar = jScrollPane1.getVerticalScrollBar();
        verticalBar.setUI(new BasicScrollBarUI() {
            
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setComposite(AlphaComposite.SrcOver);
                g2.fill(new Rectangle2D.Double(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height));
                g2.dispose();
            }

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0, 0, 0, 128); // 50% transparente para o polegar
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createInvisibleButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createInvisibleButton();
            }

            private JButton createInvisibleButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
        
        JScrollBar horizontalBar = jScrollPane1.getHorizontalScrollBar();
        horizontalBar.setUI(new BasicScrollBarUI() {
            
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setComposite(AlphaComposite.SrcOver);
                g2.fill(new Rectangle2D.Double(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height));
                g2.dispose();
            }

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0, 0, 0, 128); // 50% transparente para o polegar
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createInvisibleButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createInvisibleButton();
            }

            private JButton createInvisibleButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
    }

    public List<DadosGrafico> getListIDH() {
        return listIDH;
    }

    public List<DadosGrafico> getListIDHEdu() {
        return listIDHEdu;
    }

    public List<DadosGrafico> getListIDHLon() {
        return listIDHLon;
    }
    
    public void escParaFechar(JFrame frame){
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Não utilizado
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    //JOptionPane.showMessageDialog(, "Tecla ESC pressionada. Fechando...");
                    frame.dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Não utilizado
            }
        });

        // Tornar o JFrame focável
        frame.setFocusable(true);
    }
    
}
