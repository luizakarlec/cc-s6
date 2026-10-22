/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.util.Objects;

/**
 *
 * @author luiza
 */
public class Pessoa {
    String nome;
    String email;
    String token;
    long horaToken; //momento que o token foi gerado

    public Pessoa(String nome, String email) {
        this.nome = nome.trim();
        this.email = email;
    }
    
    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getHoraToken() {
        return horaToken;
    }

    public void setHoraToken(long horaToken) {
        this.horaToken = horaToken;
    }
    
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }    
}
