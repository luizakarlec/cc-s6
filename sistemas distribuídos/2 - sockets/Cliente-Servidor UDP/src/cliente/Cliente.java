package cliente;
import java.io.*; 
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import util.ComunicadorUDP;

public class Cliente {
    DatagramSocket socket;
    String resposta; //do servidor

    public Cliente(Pessoa p) throws IOException {
        criaClientSocket();
        DatagramPacket pacote;
                
        pacote = ComunicadorUDP.montaMensagem(p.toString(), "localhost", 1234);
        ComunicadorUDP.enviaMensagem(socket, pacote);
        
        DatagramPacket pacoteResposta = ComunicadorUDP.recebeMensagem(socket);
        if (pacoteResposta != null) {
            resposta = new String(pacoteResposta.getData(), 0, pacoteResposta.getLength());
        } else {
            resposta = "Sem resposta do servidor";
        }
        
        socket.close();
    }
    
    public String getResposta() {
        return resposta;
    }

    private void criaClientSocket() {
        try {
            //Cria um socket datagrama para enviar dados
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
