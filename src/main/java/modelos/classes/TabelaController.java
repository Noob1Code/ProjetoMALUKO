/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos.classes;
import banco.TabelaHandler;
import banco.bancoDados;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.interfaces.Ibanco;
/**
 *
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @data 29/11/2024
 * @brief Class TabelaController
 */
public class TabelaController {
    private List<Municipio> listaDeMuni;
    private Ibanco bd;
    private CarregarTabela carregadorTabela;
    private Calculo calculos = null;

    public TabelaController() {
        this.listaDeMuni = new LinkedList<>();
        calculos = new Calculo();
    }

    /**
     * Carrega os dados do banco de dados ou CSV para a tabela.
     */
    
    public void carregarTabela(DefaultTableModel modeloTabela) {
        try {
            bd = new bancoDados();
            carregadorTabela = new CarregarTabela(bd, listaDeMuni, "./src/main/java/dados/CSV Normalizado.csv");
            carregadorTabela.carregarDados(modeloTabela);
            listaDeMuni = carregadorTabela.getListaDeMuni();
            
            TabelaHandler tabelaHandler = new TabelaHandler(listaDeMuni, calculos, bd);
            tabelaHandler.configurarTabela(modeloTabela);

            if (listaDeMuni.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum dado carregado.");
            }
            bd.fecharConexao();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela: " + erro.getMessage());
        }
    }

    /**
     * Envia os dados carregados para o banco de dados.
     */
    public void enviarDadosParaBanco() {
        try {
            if (carregadorTabela == null) {
                JOptionPane.showMessageDialog(null, "Nenhuma tabela foi carregada. Use o botão 'Ler' antes de enviar.");
                return;
            }

            bd = new bancoDados();
            listaDeMuni = carregadorTabela.getListaDeMuni();

            if (!listaDeMuni.isEmpty()) {
                bd.inserirMunicipiosNoBanco(listaDeMuni);
                JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado para enviar.");
            }
            bd.fecharConexao();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar dados: " + erro.getMessage());
        }
    }

    /**
     * Remove um registro selecionado da tabela e do banco de dados.
     */
    public void deletarRegistro(DefaultTableModel modeloTabela, int linhaSelecionada) {
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um registro para deletar.");
            return;
        }

        String codigoIBGE = modeloTabela.getValueAt(linhaSelecionada, 0).toString();

        try {
            bd = new bancoDados();
            bd.deletar(codigoIBGE);
            bd.fecharConexao();
            modeloTabela.removeRow(linhaSelecionada);
            JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o registro: " + erro.getMessage());
        }
    }

    /**
     * Realiza uma busca na tabela com base no texto inserido.
     */
    public void buscarNaTabela(DefaultTableModel modeloTabela, String textoBusca) {
        if (textoBusca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite algo para buscar.");
            return;
        }

        try {
            bd = new bancoDados();
            List<Municipio> resultados = textoBusca.matches("\\d+")
                ? bd.Buscar(Integer.parseInt(textoBusca))  // Busca por código IBGE
                : bd.Buscar(textoBusca);                  // Busca por nome

            modeloTabela.setRowCount(0); // Limpa a tabela

            for (Municipio municipio : resultados) {
                modeloTabela.addRow(criarLinhaTabela(municipio));
            }
            
            TabelaHandler tabelaHandler = new TabelaHandler(listaDeMuni, calculos, bd);
            tabelaHandler.configurarTabela(modeloTabela);
            
            bd.fecharConexao();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar na tabela: " + erro.getMessage());
        }
    }

    /**
     * Cria uma linha para exibição na tabela com base nos dados de um município.
     */
    private String[] criarLinhaTabela(Municipio municipio) {
        return new String[]{
            municipio.getCodigoIBGE(),
            municipio.getMunicipios(),
            municipio.getMicrorregiao(),
            municipio.getEstado().toString(),
            municipio.getRegiaoGeografica(),
            municipio.getAreaKm2(),
            municipio.getPopulacao(),
            municipio.getDomicilios(),
            municipio.getPibTotal(),
            municipio.getIdh(),
            municipio.getRendaMedia(),
            municipio.getRendaNominal(),
            municipio.getPeaDia(),
            municipio.getIdhEducacao(),
            municipio.getIdhLongevidade(),
            municipio.getDensidadeDemografica(),
            municipio.getPibCT(),
            municipio.getIdhClass(),
            municipio.getIdhEducacaoClass(),
            municipio.getIdhLongevidadeClass()
        };
    }
    
    public void carregardadosDashBord(DefaultTableModel modeloTabela){
        modeloTabela.setRowCount(0); // Limpa a tabela antes de adicionar os dados

        try {
            bd = new bancoDados();

            if (bd.verificarSeExisteDadosNoBanco()) {
                List<Municipio> dados = bd.ordenarPibCT(); // Chama o método que retorna os dados em formato de lista de arrays

                for (Municipio linha : dados) {
                    String[] coluna = new String[23];
                    coluna[0] = linha.getPosicao();
                    for (int i = 1; i <= linha.criarLinhaTabela().length; i++) {
                        coluna[i] = linha.criarLinhaTabela()[i - 1];
                    }
                    modeloTabela.addRow(coluna);
 }
            }

            bd.fecharConexao();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados na tabela: " + erro.getMessage());
        }
    }
}
