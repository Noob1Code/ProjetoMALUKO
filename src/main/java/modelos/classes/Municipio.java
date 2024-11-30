/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import modelos.enums.Estado;
import modelos.enums.RegiaoGeografica;

/**
 *
 * @author Gabriel Braga <ninjagamer9795286@gmail.com>
 * @date 18/11/2024
 * @brief Class IBGE
 */
public class Municipio {

    private Calculo calculo = new Calculo();
    private String posicao = null;
    private String codigoIBGE = null;
    private String municipios = null;
    private String microrregiao = null;
    private Estado estado = null;
    private String regiaoGeografica = null;
    private String areaKm2 = null;
    private String populacao = null;
    private String domicilios = null;
    private String pibTotal = null;
    private String idh = null;
    private String rendaMedia = null;
    private String rendaNominal = null;
    private String peaDia = null;
    private String idhEducacao = null;
    private String idhLongevidade = null;

    private String densidadeDemografica = null;
    private String pibCT = null;
    private String idhClass = null;
    private String idhEducacaoClass = null;
    private String idhLongevidadeClass = null;
    private String Data = null;
    private String hora = null;

    public Municipio(String codigoIBGE, String municipios, String microrregiao,
            Estado estado, RegiaoGeografica regiaoGeografica, String areaKm2, String populacao,
            String domicilios, String pibTotal, String idh, String rendaMedia,
            String rendaNominal, String peaDia, String idhEducacao, String idhLongevidade) {

        this.codigoIBGE = codigoIBGE;
        this.municipios = municipios;
        this.microrregiao = microrregiao;
        this.estado = estado;
        this.regiaoGeografica = regiaoGeografica.getDescricao();
        this.areaKm2 = areaKm2;
        this.populacao = populacao;
        this.domicilios = domicilios;
        this.pibTotal = pibTotal;
        this.idh = idh;
        this.rendaMedia = rendaMedia;
        this.rendaNominal = rendaNominal;
        this.peaDia = peaDia;
        this.idhEducacao = idhEducacao;
        this.idhLongevidade = idhLongevidade;
    }
    
    public Municipio(String posicao, String codigoIBGE, String municipios, String microrregiao,
            Estado estado, RegiaoGeografica regiaoGeografica, String areaKm2, String populacao,
            String domicilios, String pibTotal, String idh, String rendaMedia,
            String rendaNominal, String peaDia, String idhEducacao, String idhLongevidade) {

        this.posicao = posicao;
        this.codigoIBGE = codigoIBGE;
        this.municipios = municipios;
        this.microrregiao = microrregiao;
        this.estado = estado;
        this.regiaoGeografica = regiaoGeografica.getDescricao();
        this.areaKm2 = areaKm2;
        this.populacao = populacao;
        this.domicilios = domicilios;
        this.pibTotal = pibTotal;
        this.idh = idh;
        this.rendaMedia = rendaMedia;
        this.rendaNominal = rendaNominal;
        this.peaDia = peaDia;
        this.idhEducacao = idhEducacao;
        this.idhLongevidade = idhLongevidade;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public String getMunicipios() {
        return municipios;
    }

    public String getMicrorregiao() {
        return microrregiao;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public String getAreaKm2() {
        return areaKm2;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getDomicilios() {
        return domicilios;
    }

    public String getPibTotal() {
        return pibTotal;
    }

    public String getIdh() {
        return idh;
    }

    public String getRendaMedia() {
        return rendaMedia;
    }

    public String getRendaNominal() {
        return rendaNominal;
    }

    public String getPeaDia() {
        return peaDia;
    }

    public String getIdhEducacao() {
        return idhEducacao;
    }

    public String getIdhLongevidade() {
        return idhLongevidade;
    }

    public String getDensidadeDemografica() {
        densidadeDemografica = calculo.DensidadeDemografica(populacao, areaKm2);
        return densidadeDemografica;
    }
  /// teste
    public void setDensidadeDemografica(String densidadeDemografica) {
        this.densidadeDemografica = densidadeDemografica;
    }

    public void setPibCT(String pibCT) {
        this.pibCT = pibCT;
    }

    public void setIdhClass(String idhClass) {
        this.idhClass = idhClass;
    }

    public void setIdhEducacaoClass(String idhEducacaoClass) {
        this.idhEducacaoClass = idhEducacaoClass;
    }

    public void setIdhLongevidadeClass(String idhLongevidadeClass) {
        this.idhLongevidadeClass = idhLongevidadeClass;
    }
    // add os q ta acima
    

    public String getPibCT() {
        pibCT = calculo.PibPerCapitaTotal(pibTotal, populacao);
        return pibCT;
    }

    public String getIdhClass() {
        idhClass = calculo.ClassificacaoIDH(idh);
        return idhClass;
    }

    public String getIdhEducacaoClass() {
        idhEducacaoClass = calculo.ClassificacaoIDH(idhEducacao);
        return idhEducacaoClass;
    }

    public String getIdhLongevidadeClass() {
        idhLongevidadeClass = calculo.ClassificacaoIDH(idhLongevidade);
        return idhLongevidadeClass;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public void setDomicilios(String domicilios) {
        this.domicilios = domicilios;
    }

    public void setPibTotal(String pibTotal) {
        this.pibTotal = pibTotal;
    }

    public void setIdh(String idh) {
        this.idh = idh;
    }

    public void setRendaMedia(String rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    public void setRendaNominal(String rendaNominal) {
        this.rendaNominal = rendaNominal;
    }

    public void setPeaDia(String peaDia) {
        this.peaDia = peaDia;
    }

    public void setIdhEducacao(String idhEducacao) {
        this.idhEducacao = idhEducacao;
    }

    public void setIdhLongevidade(String idhLongevidade) {
        this.idhLongevidade = idhLongevidade;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    
    public String[] criarLinhaTabela() {
        return new String[]{
            getCodigoIBGE(),
            getMunicipios(),
            getMicrorregiao(),
            String.valueOf(getEstado()),
            String.valueOf(getRegiaoGeografica()),
            getAreaKm2(),
            getPopulacao(),
            getDomicilios(),
            getPibTotal(),
            getIdh(),
            getRendaMedia(),
            getRendaNominal(),
            getPeaDia(),
            getIdhEducacao(),
            getIdhLongevidade(),
            getDensidadeDemografica(),
            getPibCT(),
            getIdhClass(),
            getIdhEducacaoClass(),
            getIdhLongevidadeClass(),
            getData(),
            getHora()
        };
    }
}
