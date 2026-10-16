/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cliente;

import java.rmi.RemoteException;
import servidor.*;

/**
 *
 * @author laboratorio
 */
public interface IGerarEmail {
    
    public Pessoa gerarEmail(String s) throws RemoteException; 

}
