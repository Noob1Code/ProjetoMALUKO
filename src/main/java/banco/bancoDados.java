/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelos.classes.DadosRanker;
import modelos.classes.Municipio;
import modelos.classes.Usuario;
import modelos.enums.Estado;
import modelos.enums.RegiaoGeografica;
import modelos.interfaces.Ibanco;

/**
 *
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @data 20/11/2024
 * @brief Class conexao
 */

public class bancoDados implements Ibanco {

    private String url = "jdbc:mysql://localhost:3306/ibge";
    private String usuarioP = "root";
    private String senhaP = "Kayque";
    private Connection conectar = null;
    private Municipio municipio = null;
    private Estado estado = null;
    private RegiaoGeografica regiao = null;

    public bancoDados() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // carrega o drive do sql
            conectar = DriverManager.getConnection(url, usuarioP, senhaP); //faz a conexao ao banco de Dados 
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver do banco de dados não encontrado.");
        } catch (SQLException e) {
            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conectar;
    }

    @Override
    public void fecharConexao() {
        if (conectar != null) {
            try {
                conectar.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    @Override
    public void inserirUsuario(List<Usuario> listaUsuario) throws SQLException {
        String sql = "INSERT INTO ibge.usuario (nome, sexo, CPF, senha)\n" +
                     "VALUES(?, ?, ?, ?)";

        try (PreparedStatement stmt = conectar.prepareStatement(sql)) {
            for (Usuario usuario : listaUsuario) {
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getSexo().toString());
                stmt.setString(3, usuario.getCpf());
                stmt.setString(4, usuario.getSenha());
                stmt.addBatch(); // Adiciona ao lote
            }
            stmt.executeBatch(); // Executa o lote
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir usuário no banco: " + ex.getMessage());
            throw ex;
        }
    } 

    @Override
    public void inserirMunicipiosNoBanco(List<Municipio> municipios) throws SQLException {
        // Definir a SQL de inserção
        String sql = "INSERT INTO ibge.tabela_ibge (CodigoIBGE, Municipios, Microrregiao, Estado, "
                + "Regiao_Geografica, AreaKm2, Populacao, Densidade_Demografica, Domicilios, Pib_Total, Pib_CT, IDH, "
                + "IDH_Class, Renda_Media, Renda_Nominal, Pea_Dia, IDH_Educacao, IDH_Educacao_Class, IDH_Longevidade, "
                + "IDH_Longevidade_Class) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conectar.prepareStatement(sql)) {
            for (Municipio muni : municipios) {
                stmt.setInt(1, Integer.parseInt(muni.getCodigoIBGE()));
                stmt.setString(2, muni.getMunicipios());
                stmt.setString(3, muni.getMicrorregiao());
                stmt.setString(4, muni.getEstado().toString());
                stmt.setString(5, muni.getRegiaoGeografica().toString());
                stmt.setDouble(6, Double.parseDouble(muni.getAreaKm2()));
                stmt.setInt(7, Integer.parseInt(muni.getPopulacao()));
                stmt.setDouble(8, Double.parseDouble(muni.getDensidadeDemografica()));
                stmt.setDouble(9, Double.parseDouble(muni.getDomicilios()));
                stmt.setDouble(10, Double.parseDouble(muni.getPibTotal()));
                stmt.setDouble(11, Double.parseDouble(muni.getPibCT()));
                stmt.setDouble(12, Double.parseDouble(muni.getIdh()));
                stmt.setString(13, muni.getIdhClass());
                stmt.setDouble(14, Double.parseDouble(muni.getRendaMedia()));
                stmt.setDouble(15, Double.parseDouble(muni.getRendaNominal()));
                stmt.setInt(16, Integer.parseInt(muni.getPeaDia()));
                stmt.setDouble(17, Double.parseDouble(muni.getIdhEducacao()));
                stmt.setString(18, muni.getIdhEducacaoClass());
                stmt.setDouble(19, Double.parseDouble(muni.getIdhLongevidade()));
                stmt.setString(20, muni.getIdhLongevidadeClass());
                stmt.addBatch();
            }
            stmt.executeBatch();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir municípios no banco: " + ex.getMessage());
            throw ex;
        } catch (NumberFormatException nfe) {
            System.err.println("Erro ao converter dados numéricos: " + nfe.getMessage());
            throw nfe;
        }
    }

    @Override
    public boolean verificarSeExisteDadosNoBanco() throws Exception {
        String sql = "SELECT COUNT(*) AS total FROM ibge.tabela_ibge";

        try (PreparedStatement stmt = conectar.prepareStatement(sql); java.sql.ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao verificar dados no banco: " + ex.getMessage());
            throw ex;
        }

        return false; // Caso ocorra algum erro ou a tabela esteja vazia
    }

   @Override
   public void atualizarBanco(String codigoIBGE, String[] colunas, String[] valores) throws Exception {
           if (colunas.length != valores.length) {
               throw new IllegalArgumentException("O número de colunas e valores deve ser igual.");
           }

           // Construir a consulta SQL dinamicamente
           StringBuilder sql = new StringBuilder("UPDATE ibge.tabela_ibge SET ");
           for (int i = 0; i < colunas.length; i++) {
               sql.append(colunas[i]).append(" = ?");
               if (i < colunas.length - 1) {
                   sql.append(", ");
               }
           }
           sql.append(" WHERE CodigoIBGE = ?");

           try (PreparedStatement stmt = conectar.prepareStatement(sql.toString())) {
               for (int i = 0; i < valores.length; i++) {
                   stmt.setString(i + 1, valores[i]);
               }
               stmt.setString(valores.length + 1, codigoIBGE);

               stmt.executeUpdate();
           } catch (SQLException ex) {
               System.err.println("Erro ao atualizar dados no banco: " + ex.getMessage());
               throw ex;
           }
    }

    @Override
    public void deletar(String codigoIBGE) throws Exception {
        String sql = "DELETE FROM ibge.tabela_ibge WHERE CodigoIBGE = ?";

        try (PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setString(1, codigoIBGE);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar registro: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ResultSet visualizar() throws Exception {
        String query = "SELECT * FROM ibge.tabela_ibge;";
        return conectar.createStatement().executeQuery(query);
    }

    @Override
    public void adicionarNoBanco(Municipio muni) throws SQLException {
        // SQL para verificar a existência do CodigoIBGE
        String verificarSql = "SELECT COUNT(*) AS total FROM ibge.tabela_ibge WHERE CodigoIBGE = ?";

        // SQL para inserção
        String sql = "INSERT INTO ibge.tabela_ibge (CodigoIBGE, Municipios, Microrregiao, Estado, "
                + "Regiao_Geografica, AreaKm2, Populacao, Densidade_Demografica, Domicilios, Pib_Total, Pib_CT, IDH, "
                + "IDH_Class, Renda_Media, Renda_Nominal, Pea_Dia, IDH_Educacao, IDH_Educacao_Class, IDH_Longevidade, "
                + "IDH_Longevidade_Class) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement verificarStmt = conectar.prepareStatement(verificarSql); PreparedStatement inserirStmt = conectar.prepareStatement(sql)) {

                verificarStmt.setString(1, muni.getCodigoIBGE());
                try (ResultSet rs = verificarStmt.executeQuery()) {
                    if (rs.next() && rs.getInt("total") > 0) {
                        System.err.println("CodigoIBGE já existe: " + muni.getCodigoIBGE() + ". Registro ignorado.");
                        //continue;
                    }
                }
                inserirStmt.setInt(1, Integer.parseInt(muni.getCodigoIBGE()));
                inserirStmt.setString(2, muni.getMunicipios());
                inserirStmt.setString(3, muni.getMicrorregiao());
                inserirStmt.setString(4, muni.getEstado().toString());
                inserirStmt.setString(5, muni.getRegiaoGeografica().toString());
                inserirStmt.setDouble(6, Double.parseDouble(muni.getAreaKm2()));
                inserirStmt.setInt(7, Integer.parseInt(muni.getPopulacao()));
                inserirStmt.setDouble(8, Double.parseDouble(muni.getDensidadeDemografica()));
                inserirStmt.setDouble(9, Double.parseDouble(muni.getDomicilios()));
                inserirStmt.setDouble(10, Double.parseDouble(muni.getPibTotal()));
                inserirStmt.setDouble(11, Double.parseDouble(muni.getPibCT()));
                inserirStmt.setDouble(12, Double.parseDouble(muni.getIdh()));
                inserirStmt.setString(13, muni.getIdhClass());
                inserirStmt.setDouble(14, Double.parseDouble(muni.getRendaMedia()));
                inserirStmt.setDouble(15, Double.parseDouble(muni.getRendaNominal()));
                inserirStmt.setInt(16, Integer.parseInt(muni.getPeaDia()));
                inserirStmt.setDouble(17, Double.parseDouble(muni.getIdhEducacao()));
                inserirStmt.setString(18, muni.getIdhEducacaoClass());
                inserirStmt.setDouble(19, Double.parseDouble(muni.getIdhLongevidade()));
                inserirStmt.setString(20, muni.getIdhLongevidadeClass());

                inserirStmt.addBatch();
            inserirStmt.executeBatch();
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar municípios no banco: " + ex.getMessage());
            throw ex;
        } catch (NumberFormatException nfe) {
            System.err.println("Erro ao converter dados numéricos: " + nfe.getMessage());
            throw nfe;
        }
    }

    @Override
    public List<DadosRanker>ordenar(String coluna) throws Exception {
            List<DadosRanker> list = new LinkedList<>();
            String query = "SELECT \n" +
                       "    ROW_NUMBER() OVER (ORDER BY "+coluna+" DESC) AS Ordem,\n" +
                       "    CodigoIBGE,\n" +
                       "    Municipios,\n" +
                       "    "+coluna+"\n" +
                       "    FROM ibge.tabela_ibge ;";

            try (
                PreparedStatement stmt = conectar.prepareStatement(query)) {

                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        DadosRanker dados = new DadosRanker(
                            resultados.getInt("Ordem"),
                            resultados.getInt("CodigoIBGE"),
                            resultados.getString("Municipios"),
                            resultados.getDouble(coluna)
                        );
                        list.add(dados);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        return list;        
    } 

    @Override
    public List<Municipio> Buscar(String valorBusca) throws Exception {
        List<Municipio> list = new LinkedList<>();
        String query = "SELECT * FROM ibge.tabela_ibge WHERE Municipios LIKE ?;";

        try (
            PreparedStatement stmt = conectar.prepareStatement(query)
        ) {
            // Define o parâmetro do código do IBGE
            stmt.setString(1,"%" +valorBusca+"%");

            try (ResultSet resultados = stmt.executeQuery()) {
                while (resultados.next()) {
                   estado = Estado.valueOf(resultados.getString("Estado").toUpperCase());
                   regiao = RegiaoGeografica.fromString(resultados.getString("Regiao_Geografica"));

                    municipio = new Municipio(
                    resultados.getString("CodigoIBGE"),
                    resultados.getString("Municipios"),
                    resultados.getString("Microrregiao"),
                    estado,
                    regiao,
                    resultados.getString("AreaKm2"),
                    resultados.getString("Populacao"),
                    resultados.getString("Domicilios"),
                    resultados.getString("Pib_Total"),
                    resultados.getString("IDH"),
                    resultados.getString("Renda_Media"),
                    resultados.getString("Renda_Nominal"),
                    resultados.getString("Pea_Dia"),
                    resultados.getString("IDH_Educacao"),
                    resultados.getString("IDH_Longevidade")
                    );          
                    municipio.setData( resultados.getString("DataT"));
                    municipio.setHora(resultados.getString("Hora")); 
                    list.add(municipio);
                    }
                }
            }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
        } 

    @Override
    public List<Municipio> Buscar(Integer valorBusca) throws Exception {
        List<Municipio> list = new ArrayList<>();
        String query = "SELECT * FROM ibge.tabela_ibge WHERE CodigoIBGE = ?;";

        try (
            PreparedStatement stmt = conectar.prepareStatement(query)
        ) {
            // Define o parâmetro do código do IBGE
            stmt.setInt(1, valorBusca);

            try (ResultSet resultados = stmt.executeQuery()) {
                while (resultados.next()) {
                   estado = Estado.valueOf(resultados.getString("Estado").toUpperCase());
                   regiao = RegiaoGeografica.fromString(resultados.getString("Regiao_Geografica"));

                    municipio = new Municipio(
                    resultados.getString("CodigoIBGE"),
                    resultados.getString("Municipios"),
                    resultados.getString("Microrregiao"),
                    estado,
                    regiao,
                    resultados.getString("AreaKm2"),
                    resultados.getString("Populacao"),
                    resultados.getString("Domicilios"),
                    resultados.getString("Pib_Total"),
                    resultados.getString("IDH"),
                    resultados.getString("Renda_Media"),
                    resultados.getString("Renda_Nominal"),
                    resultados.getString("Pea_Dia"),
                    resultados.getString("IDH_Educacao"),
                    resultados.getString("IDH_Longevidade")
                    );          
                    municipio.setData( resultados.getString("DataT"));
                    municipio.setHora(resultados.getString("Hora")); 
                    list.add(municipio);
                    }
                }
            }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
        } 

    @Override
    public List<String> pesquisaIDH(String coluna) {
        List<String> list = new ArrayList<>();
        String sql = "SELECT " + coluna + " FROM ibge.tabela_ibge";
        try (
                PreparedStatement stmt = conectar.prepareStatement(sql); ResultSet resultados = stmt.executeQuery();) {

            while (resultados.next()) {
                list.add(resultados.getString(coluna));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean verificarCredenciais(String login, String senha) throws Exception {
        String query = "SELECT CPF, senha FROM ibge.usuario WHERE CPF = ?";

        try (PreparedStatement stmt = conectar.prepareStatement(query)) {
            stmt.setString(1, login); // Substitui o parâmetro de login

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Verifica se a senha no banco é igual à senha fornecida
                    String senhaBanco = rs.getString("senha");
                    return senha.equals(senhaBanco);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao verificar credenciais: " + ex.getMessage());
            throw ex; // Relança a exceção para tratamento externo
        }
        return false; // Retorna false se não encontrou o login ou a senha não corresponde
    }

    @Override
    public List<Municipio> ordenarPibCT() throws Exception {
        List<Municipio> list = new ArrayList<>();
        String query = "SELECT \n" +
                       "ROW_NUMBER() OVER (ORDER BY ta.Pib_CT DESC) AS Ordem,\n" +
                       "ta.* \n" +
                       "FROM ibge.tabela_ibge as ta;";

        try (
            PreparedStatement stmt = conectar.prepareStatement(query); 
            ResultSet resultados = stmt.executeQuery()
        ) {
            while (resultados.next()) {
                estado = Estado.valueOf(resultados.getString("Estado").toUpperCase());
                regiao = RegiaoGeografica.fromString(resultados.getString("Regiao_Geografica"));

                    municipio = new Municipio(
                    resultados.getString("Ordem"),
                    resultados.getString("CodigoIBGE"),
                    resultados.getString("Municipios"),
                    resultados.getString("Microrregiao"),
                    estado,
                    regiao,
                    resultados.getString("AreaKm2"),
                    resultados.getString("Populacao"),
                    resultados.getString("Domicilios"),
                    resultados.getString("Pib_Total"),
                    resultados.getString("IDH"),
                    resultados.getString("Renda_Media"),
                    resultados.getString("Renda_Nominal"),
                    resultados.getString("Pea_Dia"),
                    resultados.getString("IDH_Educacao"),
                    resultados.getString("IDH_Longevidade")
                    );          
                    municipio.setData( resultados.getString("DataT"));
                    municipio.setHora( resultados.getString("Hora")); 
                    municipio.setPosicao(resultados.getString("Ordem")); 
                    
                    list.add(municipio);
                };
             } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return list;
            }

    @Override
    public String nomeUsuario(String CPF) throws Exception {
            String nome = null;
            String sql = "SELECT nome FROM ibge.usuario WHERE CPF = ?"; 
            try (
                PreparedStatement stmt = conectar.prepareStatement(sql)
            ) {
                stmt.setString(1, CPF);
                ResultSet resultados = stmt.executeQuery();

                if (resultados.next()) {
                    nome = resultados.getString("nome");  
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return nome;
        }
}
