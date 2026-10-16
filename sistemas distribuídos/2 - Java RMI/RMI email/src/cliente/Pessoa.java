/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.io.Serializable;

/**
 *
 * @author laboratorio
 */
public class Pessoa implements Serializable {
    String nome;
    String email;

    public Pessoa(String nome) {
        this.nome = nome.trim();
        this.email = gerarEmail();
    }
    
    public Pessoa() {
    }
    
    private String gerarEmail() {
        String palavras[];
        palavras = this.nome.split((" "));
        String email = palavras[0] + "." + palavras[palavras.length-1] + "@ufn.edu.br";
        email = email.toLowerCase();
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + '}';
    }
    
}
