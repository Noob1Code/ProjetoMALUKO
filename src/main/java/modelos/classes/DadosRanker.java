/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

/**
 *
 * @author NOTE FELIPE
 */
public class DadosRanker {
    
    private int classificacao = 0;
    private int codigoIBGE = 0;
    private String municipio =null;
    private double valor = 0;

    public DadosRanker(int classificacao, int codigoIBGE, String municipio, double valor) {
        this.classificacao = classificacao;
        this.codigoIBGE = codigoIBGE;
        this.municipio = municipio;
        this.valor = valor;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public int getCodigoIBGE() {
        return codigoIBGE;
    }

    public String getMunicipio() {
        return municipio;
    }

    public double getValor() {
        return valor;
    }
    
    
}
