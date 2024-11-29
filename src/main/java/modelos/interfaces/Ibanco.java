/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package modelos.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import modelos.classes.DadosRanker;
import modelos.classes.Municipio;
import modelos.classes.Usuario;

/**
 *
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @data 20/11/2024
 * @brief Class Ibanco
 */
public interface Ibanco {
    public Connection getConexao();
    public void fecharConexao();
    public void inserirMunicipiosNoBanco(List<Municipio> municipios)throws Exception;
    public boolean verificarSeExisteDadosNoBanco() throws Exception;
    public void atualizarBanco(String codigoIBGE, String[] colunas, String[] valores) throws Exception;
    public void deletar(String codigoIBGE) throws Exception;
    public ResultSet visualizar() throws Exception;
    public void adicionarNoBanco(Municipio muni) throws Exception;
    public void inserirUsuario(List<Usuario> listaUsuario) throws Exception;
    public String substituirVirgulaPorPonto(String valor);
    public List<DadosRanker> ordenar(String coluna) throws Exception;
    public List<String[]> ordenarPibCT() throws Exception;
    public List<String[]> Buscar(Integer valorBusca) throws Exception;
    public List<String[]> Buscar(String valorBusca) throws Exception; 
    public List<String> pesquisaIDH(String coluna);
    public boolean verificarCredenciais(String login, String senha) throws Exception;
    public String nomeUsuario(String CPF) throws Exception;
}
