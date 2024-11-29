/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos.classes;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.enums.Estado;
import modelos.enums.RegiaoGeografica;
import modelos.interfaces.Ibanco;
import persistencia.PersistenciaDeDados;

/**
 *
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @data 25/11/2024
 * @brief Class CarregarTabela
 */
public class CarregarTabela {
    private Ibanco bd = null;
    private List<Municipio> listaDeMuni = null;
    private String caminhoCsv = null;
    private Municipio municipio = null;
    private Estado estado = null;
    private RegiaoGeografica regiao = null;

    public CarregarTabela(Ibanco bd, List<Municipio> listaDeMuni, String caminhoCsv) {
        this.bd = bd;
        this.listaDeMuni = listaDeMuni;
        this.caminhoCsv = caminhoCsv;
    }

    public void carregarDados(DefaultTableModel model) throws Exception {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        if (bd.verificarSeExisteDadosNoBanco()) {
            // Carregar dados do banco de dados
            ResultSet rs = bd.visualizar();
            model.setRowCount(0); // Limpa as linhas

            while (rs.next()) {
                String[] linha = new String[22];
                linha[0] = rs.getString("CodigoIBGE");
                linha[1] = rs.getString("Municipios");
                linha[2] = rs.getString("Microrregiao");
                linha[3] = rs.getString("Estado");
                linha[4] = rs.getString("Regiao_Geografica");
                linha[5] = df.format(rs.getDouble("AreaKm2"));
                linha[6] = rs.getString("Populacao");
                linha[7] = df.format(rs.getDouble("Domicilios"));
                linha[8] = df.format(rs.getDouble("Pib_Total"));
                linha[9] = rs.getString("IDH");
                linha[10] = df.format(rs.getDouble("Renda_Media"));
                linha[11] = df.format(rs.getDouble("Renda_Nominal"));
                linha[12] = rs.getString("Pea_Dia");
                linha[13] = rs.getString("IDH_Educacao");
                linha[14] = rs.getString("IDH_Longevidade");
                linha[15] = df.format(rs.getDouble("Densidade_Demografica"));
                linha[16] = rs.getString("Pib_CT");
                linha[17] = rs.getString("IDH_Class");
                linha[18] = rs.getString("IDH_Educacao_Class");
                linha[19] = rs.getString("IDH_Longevidade_Class");
                linha[20] = rs.getString("DataT");
                linha[21] = rs.getString("Hora"); 

                model.addRow(linha);
                estado = Estado.valueOf(rs.getString("Estado").toUpperCase());
                regiao = RegiaoGeografica.fromString(rs.getString("Regiao_Geografica"));

                   municipio = new Municipio(
                    rs.getString("CodigoIBGE"),
                    rs.getString("Municipios"),
                    rs.getString("Microrregiao"),
                    estado,
                    regiao,
                    rs.getString("AreaKm2"),
                    rs.getString("Populacao"),
                    rs.getString("Domicilios"),
                    rs.getString("Pib_Total"),
                    rs.getString("IDH"),
                    rs.getString("Renda_Media"),
                    rs.getString("Renda_Nominal"),
                    rs.getString("Pea_Dia"),
                    rs.getString("IDH_Educacao"),
                    rs.getString("IDH_Longevidade")
                );
            listaDeMuni.add(municipio);
            }
            rs.close();
        } else {
            // Carregar dados do CSV se o banco estiver vazio
            PersistenciaDeDados arquivo = new PersistenciaDeDados(caminhoCsv);
            listaDeMuni = arquivo.listaDeMunicipio();
            model.setRowCount(0);

            for (Municipio obj : listaDeMuni) {
                String[] coluna = new String[20];
                coluna[0] = obj.getCodigoIBGE();
                coluna[1] = obj.getMunicipios();
                coluna[2] = obj.getMicrorregiao();
                coluna[3] = String.valueOf(obj.getEstado());
                coluna[4] = String.valueOf(obj.getRegiaoGeografica());
                coluna[5] = obj.getAreaKm2();
                coluna[6] = obj.getPopulacao();
                coluna[7] = obj.getDomicilios();
                coluna[8] = obj.getPibTotal();
                coluna[9] = obj.getIdh();
                coluna[10] = obj.getRendaMedia();
                coluna[11] = obj.getRendaNominal();
                coluna[12] = obj.getPeaDia();
                coluna[13] = obj.getIdhEducacao();
                coluna[14] = obj.getIdhLongevidade();
                coluna[15] = obj.getDensidadeDemografica();
                coluna[16] = obj.getPibCT();
                coluna[17] = obj.getIdhClass();
                coluna[18] = obj.getIdhEducacaoClass();
                coluna[19] = obj.getIdhLongevidadeClass();

                model.addRow(coluna);
            }
        }
    }

    public List<Municipio> getListaDeMuni() throws Exception {
        return listaDeMuni;
    }
}
