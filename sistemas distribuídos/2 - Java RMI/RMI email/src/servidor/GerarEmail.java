/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author laboratorio
 */
public class GerarEmail extends UnicastRemoteObject implements IGerarEmail {
    
    public GerarEmail() throws RemoteException {
    }

    public Pessoa gerarEmail(String s) throws RemoteException {
        Pessoa p = new Pessoa(s);
        return p;
    }
}
