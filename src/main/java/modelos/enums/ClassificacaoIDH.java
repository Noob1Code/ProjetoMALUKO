/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.enums;

/**
 *
 * @author aluno
 */
public enum ClassificacaoIDH {
    Muito_Alto("Muito Alto"),
    Alto("Alto"),
    Medio("Médio"),
    Baixo("Baixo");

    private final String descricao;

    // Construtor
    ClassificacaoIDH(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    // Getter
    public String getDescricao() {
        return descricao;
    }
    
}
