/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import modelos.classes.Municipio;
import modelos.enums.Estado;
import modelos.enums.RegiaoGeografica;

/**
 *
 * @author Gabriel Braga <ninjagamer9795286@gmail.com>
 * @date 18/11/2024
 * @brief Class PersistenciaDeDados
 */
public class PersistenciaDeDados {

    //Atributos
    private String nomeArquivoNoDisco;
    

    public PersistenciaDeDados(String nomeArquivoNoDisco) {
        this.nomeArquivoNoDisco = nomeArquivoNoDisco;
    }

    public List<Municipio> listaDeMunicipio() throws Exception {
        try {

            List<Municipio> lista = new ArrayList<>();

            FileReader fr = new FileReader(nomeArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] vetor = linha.split(";");
                if (vetor.length < 15) {
                    throw new Exception("Linha inválida no arquivo: " + linha);
                }

                String codigoIBGE = Replace(vetor[0]);
                String municipios = Replace(vetor[1]);
                String microrregiao = Replace(vetor[2]);
                Estado estado = Estado.valueOf(Replace(vetor[3]));
                RegiaoGeografica regiaoGeografica = RegiaoGeografica.fromString(Replace(vetor[4].trim()));
                String areaKm2 = Replace(vetor[5]);
                String populacao = Replace(vetor[6].replaceAll(".?0+$", ""));
                String domicilios = Replace(vetor[7]);
                String pibTotal = Replace(vetor[8]);
                String idh = Replace(vetor[9]);
                String rendaMedia = Replace(vetor[10]);
                String rendaNominal = Replace(vetor[11]);
                String peaDia = Replace(vetor[12].replaceAll(".?0+$", ""));
                String idhEducacao = Replace(vetor[13]);
                String idhLongevidade = Replace(vetor[14]);

                Municipio muni = new Municipio(codigoIBGE, municipios, microrregiao,
                        estado, regiaoGeografica, areaKm2, populacao,
                        domicilios, pibTotal, idh, rendaMedia,
                        rendaNominal, peaDia, idhEducacao, idhLongevidade);

                lista.add(muni);
            }

            br.close();
            fr.close();

            return lista;

        } catch (Exception erro) {
            throw new Exception("Erro ao processar o arquivo: " + erro.getMessage(), erro);
        }
    }
     
    public String Replace(String valor){
        return valor.replace("\"", "");
    }
}
