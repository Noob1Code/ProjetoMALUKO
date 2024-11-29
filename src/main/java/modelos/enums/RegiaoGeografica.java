/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.enums;

/**
 *
 * @author aluno
 */
public enum RegiaoGeografica {
    Centro_Oeste("Centro-Oeste");

    private String descricao ="";

    // Construtor para associar a descrição ao enum
    RegiaoGeografica(String texto) {
        this.descricao = texto;
    }

    // Método para retornar a descrição
    public String getDescricao() {
        return descricao;
    }

    // Método para buscar o enum correspondente à string, ignorando "(a)" e diferenças de maiúsculas/minúsculas
    public static RegiaoGeografica fromString(String tituloStr) {
        // Remove "(a)" e espaços desnecessários, converte para maiúsculas
        String tituloFormatado = tituloStr.toUpperCase().trim();

        // Faz a correspondência com os valores do enum
        for (RegiaoGeografica titulo : RegiaoGeografica.values()) {
            if (titulo.descricao.toUpperCase().equals(tituloFormatado)) {
                return titulo;
            }
        }
        throw new IllegalArgumentException("Título inválido: " + tituloStr);
    }
}
