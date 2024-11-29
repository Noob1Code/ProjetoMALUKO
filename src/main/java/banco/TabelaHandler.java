/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.classes.Calculo;
import modelos.classes.Municipio;
import modelos.interfaces.Ibanco;

/**
 *
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @date 25/11/2024
 * @brief Class TabelaHandler
 */
public class TabelaHandler {

    private List<Municipio> listaDeMuni = null;
    private Calculo calculo = null;
    private Ibanco bd= null;

    public TabelaHandler(List<Municipio> listaDeMuni, Calculo calculos, Ibanco bd) {
        this.listaDeMuni = listaDeMuni;
        this.calculo = calculos;
        this.bd = bd;
    }

    public void configurarTabela(DefaultTableModel model) {
        // Remover todos os listeners existentes
        for (javax.swing.event.TableModelListener listener : model.getTableModelListeners()) {
            model.removeTableModelListener(listener);
        }

        model.addTableModelListener(this::processarAlteracaoTabela);
    }

    private void processarAlteracaoTabela(TableModelEvent e) {
            if (listaDeMuni == null) {
                Logger.getLogger(TabelaHandler.class.getName()).log(Level.SEVERE, "listaDeMuni está nula.");
                return;
            }
            
        int row = e.getFirstRow();
        int column = e.getColumn();

        // Verificar índices válidos
        DefaultTableModel model = (DefaultTableModel) e.getSource();
        if (row < 0 || column < 0 || row >= model.getRowCount() || column >= model.getColumnCount()) {
            return;
        }

        String novoValor = model.getValueAt(row, column).toString();
        novoValor = novoValor.replace(".", "").replace(",", ".");

        String codigoIBGE = model.getValueAt(row, 0).toString();

        try {
            String[] colunasAtualizadas = null;
            String[] valoresAtualizados = null;

            for (Municipio municipio : listaDeMuni) {
                if (municipio.getCodigoIBGE().equals(codigoIBGE)) {
                    switch (column) {
                        case 6: // População
                            municipio.setPopulacao(novoValor);
                            String novaDensidade = calculo.DensidadeDemografica(municipio.getPopulacao(), municipio.getAreaKm2());
                            String novaPibCT = calculo.PibPerCapitaTotal(municipio.getPibTotal(), municipio.getPopulacao());
                            municipio.setDensidadeDemografica(novaDensidade);
                            municipio.setPibCT(novaPibCT);

                            colunasAtualizadas = new String[]{"Populacao", "Densidade_Demografica","Pib_CT"};
                            valoresAtualizados = new String[]{novoValor, novaDensidade.replace(",", "."),novaPibCT.replace(",", ".")};
                            break;
                        case 7: // Domicilios
                            municipio.setDomicilios(novoValor);
                            
                            colunasAtualizadas = new String[]{"Domicilios"};
                            valoresAtualizados = new String[]{novoValor};
                            break;
                        case 8: // Pib Total
                            municipio.setPibTotal(novoValor.replace(",", "."));
                            
                            String novaPibCT1 = calculo.PibPerCapitaTotal(municipio.getPibTotal(), municipio.getPopulacao());
                            colunasAtualizadas = new String[]{"Pib_Total","Pib_CT"};
                            valoresAtualizados = new String[]{novoValor.replace(",", "."), novaPibCT1.replace(",", ".")};
                            municipio.setPibCT(novaPibCT1);
                            break;

                        case 9: // IDH
                            municipio.setIdh(novoValor.replace(",", "."));
                            String novaClassificacaoIdh = calculo.ClassificacaoIDH(novoValor);
                            municipio.setIdhClass(novaClassificacaoIdh);

                            colunasAtualizadas = new String[]{"IDH", "IDH_Class"};
                            valoresAtualizados = new String[]{novoValor.replace(",", "."), novaClassificacaoIdh};
                            break;
                        case 10: // Renda Média
                            municipio.setRendaMedia(novoValor.replace(",", "."));
                            colunasAtualizadas = new String[]{"Renda_Media"};
                            valoresAtualizados = new String[]{novoValor.replace(",", ".")};
                            break;
                        case 11: // Renda nominal
                            municipio.setRendaNominal(novoValor.replace(",", "."));
                            colunasAtualizadas = new String[]{"Renda_Nominal"};
                            valoresAtualizados = new String[]{novoValor.replace(",", ".")};
                            break;
                        case 12: // Pea dia
                            municipio.setPeaDia(novoValor.replace(",", "."));
                            colunasAtualizadas = new String[]{"Pea_Dia"};
                            valoresAtualizados = new String[]{novoValor.replace(",", ".")};
                            break;

                        case 13: // IDH Educação
                            municipio.setIdhEducacao(novoValor.replace(",", "."));
                            String novaClassificacaoIdhEducacao = calculo.ClassificacaoIDH(novoValor);
                            municipio.setIdhEducacaoClass(novaClassificacaoIdhEducacao);

                            colunasAtualizadas = new String[]{"IDH_Educacao", "IDH_Educacao_Class"};
                            valoresAtualizados = new String[]{novoValor.replace(",", "."), novaClassificacaoIdhEducacao};
                            break;
                        case 14: // IDH longividade
                            municipio.setIdhLongevidade(novoValor.replace(",", "."));
                            String novaClassificacaoIdhLongividade = calculo.ClassificacaoIDH(novoValor);
                            municipio.setIdhEducacaoClass(novaClassificacaoIdhLongividade);

                            colunasAtualizadas = new String[]{"IDH_Longevidade", "IDH_Longevidade_Class"};
                            valoresAtualizados = new String[]{novoValor.replace(",", "."), novaClassificacaoIdhLongividade};
                            break;
                    }
                    break;
                }
            }

            if (colunasAtualizadas != null && valoresAtualizados != null) {
                bd = new bancoDados();
                bd.getConexao();
                bd.atualizarBanco(codigoIBGE, colunasAtualizadas, valoresAtualizados);
                bd.fecharConexao();
            }
        } catch (Exception ex) {
            Logger.getLogger(TabelaHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}