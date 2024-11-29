/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

import java.io.IOException;
import modelos.enums.Sexo;

/**
 *
 * @author aluno
 */
public class Usuario {
    private String nome = null;
    private String senha = null;
    private Sexo sexo = null;
    private String cpf = null;
    

    public Usuario(String nome, String sexo, String cpf, String senha, String confirmarSenha) throws Exception {
        
        if(estaVazio(nome)) throw new Exception("O Nome nao Pode estar VAZIO!");
        if(estaVazio(sexo)) throw new Exception("O Sexo nao Pode estar VAZIO!");
        if(estaVazio(cpf)) throw new Exception("O CPF nao Pode estar VAZIO!");
        if(estaVazio(senha)) throw new Exception("O Senha nao Pode estar VAZIO!");
        if(estaVazio(confirmarSenha)) throw new Exception("O Confirmar Senha nao Pode estar VAZIO!");
        
        if(!senha.equals(confirmarSenha)) throw new Exception("As senhas não coincidem");
        if(validarNome(nome)) throw new Exception("Nome Invalido!!");
        
        this.nome = nome;
        this.sexo = Sexo.valueOf(sexo);
        this.cpf = cpf;
        this.senha = senha;
    }
    
    private boolean estaVazio(String valor){
        return valor.trim() == null || valor.trim().equals("");
    }
    
    private boolean validarNome(String nome){
        return nome.charAt(0) == nome.charAt(1) && nome.charAt(0) == nome.charAt(2);
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    
    
}
