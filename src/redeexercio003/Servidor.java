package redeexercio003;

import java.io.*;
import java.net.*;

/**
 *
 * @author Edilson do Nascimento
 */
public class Servidor {
    private static Socket socket;
    private static ServerSocket server;
    
    private static ObjectInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
   
        try {
            
            server = new ServerSocket(50000);
            System.out.println("Servidor iniciado...");
            
            socket = server.accept();            
            
            entrada = new ObjectInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            Pessoa p = (Pessoa) entrada.readObject(); 
            
            System.out.println("Nome: " + p.getNome() + " Idade: " + p.getIdade());
            
            saida.writeUTF("Dados recebidos corretamente!");
            
            socket.close();
            
        } catch(Exception e) {
            System.out.println("Não foi possível subir o servidor...");
        }
        
    }  
    
    
}
