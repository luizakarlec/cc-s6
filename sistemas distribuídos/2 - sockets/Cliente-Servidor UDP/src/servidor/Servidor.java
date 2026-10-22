/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.UUID;
import util.ComunicadorUDP;

/**
 *
 * @author luiza
 */
public class Servidor {
    static final long VALIDADE = 60000; // 60 segundos
    
    DatagramSocket socket;
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Servidor() throws IOException {
        criaServerSocket();
        System.out.println("Servidor ati    vo à espera do cliente/enviador");
        DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);//aguarda um pacote datagrama chegar de um cliente pela porta 1234
        String mensagem, resposta;    
                
        while (pacote != null) {
            // pacote recebido
            mensagem = new String(pacote.getData(), 0, pacote.getLength());
            System.out.println("Recebi " + mensagem);
            System.out.println("De: " + pacote.getAddress().getHostName() + ":" + pacote.getPort());

            // processa o que foi recebido
            resposta = cadastra(mensagem);

            // responde para quem enviou
            DatagramPacket pacoteResposta = ComunicadorUDP.montaMensagem(
                    resposta, pacote.getAddress().getHostAddress(), pacote.getPort());
            ComunicadorUDP.enviaMensagem(socket, pacoteResposta);

            // espera o próximo
            pacote = ComunicadorUDP.recebeMensagem(socket);
        }
    }
    
    private String cadastra(String mensagem) {
        // formato esperado: Pessoa{nome=XXX, email=YYY}
        int iNome = mensagem.indexOf("nome=");
        int iEmail = mensagem.indexOf(", email=");
        int fim = mensagem.lastIndexOf("}");

        if (iNome == -1 || iEmail == -1 || fim == -1) {
            System.out.println("ERRO: mensagem inválida");
            return "ERRO: mensagem inválida";
        }

        String nome = mensagem.substring(iNome + 5, iEmail);
        String email = mensagem.substring(iEmail + 8, fim);
        Pessoa nova = new Pessoa(nome, email);

        //cuidando de duplicados
        Pessoa pessoa = null;
        for (Pessoa p : pessoas) {
            if (p.getEmail().equalsIgnoreCase(nova.getEmail())) {
                pessoa = p;   // já existe: usa a que está na lista
                break;
            }
        }

        String situacao = "Já cadastrado(a)";
        if (pessoa == null) {   // não existe: cadastra
            pessoas.add(nova);
            pessoa = nova;
            situacao = "Cadastrado(a)";
            System.out.println("Cadastrados: " + pessoas);
        }

        long agora = System.currentTimeMillis();
        if (pessoa.getToken() == null || agora - pessoa.getHoraToken() >= VALIDADE) {
            pessoa.setToken(geraToken());
            pessoa.setHoraToken(agora);
        }

        long restante = (VALIDADE - (agora - pessoa.getHoraToken())) / 1000;
        return situacao + " | TOKEN: " + pessoa.getToken() + " (válido por " + restante + "s)";
    }
    
    private String geraToken() {
        int n = (int) (Math.random() * 1000000);
        return String.format("%06d", n);
    }

    private void criaServerSocket() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws IOException {
        Servidor receptor = new Servidor();
    }
}