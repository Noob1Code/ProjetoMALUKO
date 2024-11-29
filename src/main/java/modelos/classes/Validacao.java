/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import modelos.interfaces.IValidacao;

/**
 *
 * @author aluno
 */
public class Validacao implements IValidacao {

    @Override
    public boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos do CPF, como pontos e traços
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return false; // CPF inválido se não tiver 11 dígitos
        }

        // Verifica se todos os dígitos do CPF são iguais (ex.: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false; // CPF inválido se todos os dígitos forem iguais
        }

        // Calcula o primeiro dígito verificador
        int primeiroDigito = calcularDigito(cpf, 9, 10);
        // Compara o primeiro dígito calculado com o 10º dígito do CPF
        if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
            return false; // CPF inválido se o primeiro dígito verificador não for igual
        }

        // Calcula o segundo dígito verificador
        int segundoDigito = calcularDigito(cpf, 10, 11);
        // Compara o segundo dígito calculado com o 11º dígito do CPF
        if (segundoDigito != Character.getNumericValue(cpf.charAt(10))) {
            return false; // CPF inválido se o segundo dígito verificador não for igual
        }

        // Se todas as validações passaram, o CPF é válido
        return true;
    }

    private int calcularDigito(String cpf, int tamanho, int pesoInicial) {
        int soma = 0;

        // Para cada dígito do CPF até o tamanho especificado:
        for (int i = 0; i < tamanho; i++) {
            // Multiplica o dígito pelo peso (pesoInicial) e acumula na soma
            soma += Character.getNumericValue(cpf.charAt(i)) * pesoInicial--;
        }

        // Calcula o resto da divisão da soma por 11
        int resto = soma % 11;

        // Se o resto for menor que 2, o dígito verificador é 0
        // Caso contrário, o dígito verificador é 11 menos o resto
        return (resto < 2) ? 0 : 11 - resto;
    }

}
