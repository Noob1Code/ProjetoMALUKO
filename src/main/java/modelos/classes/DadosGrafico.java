/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import java.awt.Color;

/**
 *
 * @author NOTE FELIPE
 */
public class DadosGrafico {
    private String nome = null;  
    private int classificacao = 0;
    private Color cor = null;

    public DadosGrafico(String nome,int classificacao, Color cor) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Color getCor() {
        return cor;
    }
    
    public int getClasssificacao() {
        return classificacao;
    }
    
}
