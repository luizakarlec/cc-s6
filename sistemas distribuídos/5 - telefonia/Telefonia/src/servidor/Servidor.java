package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    String HOST_URL = "rmi://localhost/GerarEmail";
    
    public Servidor(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            JFrameServidor objetoRemoto = new JFrameServidor();
            Naming.bind(HOST_URL, objetoRemoto);
            System.out.println("Servidor online e no aguardo....");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void main(String args[]) {
        new Servidor();
    }
}
