/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import javax.swing.JOptionPane;
import servidor.IGerarEmail;
import servidor.Pessoa;

public class Client {

    public static void main(String[] args) {
        try {
            IGerarEmail c = (IGerarEmail) Naming.lookup("rmi://localhost/GerarEmail");
            String nome = JOptionPane.showInputDialog("Digite um nome completo: ");
            Pessoa p = c.gerarEmail(nome);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
