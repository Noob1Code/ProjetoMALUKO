/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        private Ibanco bd;
        private List<Municipio> listaDeMuni;
        private String caminhoCsv;

        public CarregarTabela(Ibanco bd, List<Municipio> listaDeMuni, String caminhoCsv) {
            this.bd = bd;
            this.listaDeMuni = listaDeMuni;
            this.caminhoCsv = caminhoCsv;
        }

        public void carregarDados(DefaultTableModel model) throws Exception {
            if (bd.verificarSeExisteDadosNoBanco()) {
                carregarDadosDoBanco(model);
            } else {
                carregarDadosDoCsv(model);
            }
        }

        private void carregarDadosDoBanco(DefaultTableModel model) throws SQLException, Exception {
            try (ResultSet rs = bd.visualizar()) {
                model.setRowCount(0);
                while (rs.next()) {
                    
                    Municipio municipio = criarMunicipio(rs);
                    municipio.setData(rs.getString("DataT"));
                    municipio.setHora(rs.getString("Hora"));
                    listaDeMuni.add(municipio);
                    model.addRow(municipio.criarLinhaTabela());
                }
            }
        }

        private void carregarDadosDoCsv(DefaultTableModel model) throws Exception {
            PersistenciaDeDados arquivo = new PersistenciaDeDados(caminhoCsv);
            listaDeMuni = arquivo.listaDeMunicipio();
            model.setRowCount(0);

            for (Municipio municipio : listaDeMuni) {
                model.addRow(municipio.criarLinhaTabela());
            }
        }

        private Municipio criarMunicipio(ResultSet rs) throws SQLException {
            return new Municipio(
                rs.getString("CodigoIBGE"),
                rs.getString("Municipios"),
                rs.getString("Microrregiao"),
                Estado.valueOf(rs.getString("Estado").toUpperCase()),
                RegiaoGeografica.fromString(rs.getString("Regiao_Geografica")),
                formatarCasa(rs.getString("AreaKm2")),
                rs.getString("Populacao"),
                formatarCasa(rs.getString("Domicilios")),
                formatarCasa(rs.getString("Pib_Total")),
                rs.getString("IDH"),
                formatarCasa(rs.getString("Renda_Media")),
                formatarCasa(rs.getString("Renda_Nominal")),
                rs.getString("Pea_Dia"),
                rs.getString("IDH_Educacao"),
                rs.getString("IDH_Longevidade")
            );
        }

        public List<Municipio> getListaDeMuni() {
            return listaDeMuni;
        }

        public String formatarCasa(String valor) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            double valorNumerico = Double.parseDouble(valor);
            return df.format(valorNumerico).replace(",", "temp").replace(".", "").replace("temp", ".");
        }
    }
