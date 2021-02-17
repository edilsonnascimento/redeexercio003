package redeexercio003;

import java.io.*;
import java.net.*;

/**
 *
 * @author Edilson do Nascimento
 */
public class Servidor extends Thread{
    
    private static Socket socket;
  
    public Servidor(Socket conexao) {
        this.socket = conexao;
    }
    
    @Override
    public void run(){

        try {         
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            Pessoa p = (Pessoa) entrada.readObject(); 
            
            System.out.println("Nome: " + p.getNome() + " Idade: " + p.getIdade());
            
            saida.writeUTF("Dados recebidos corretamente!");
            
            socket.close();
            
        } catch(Exception e) {
            System.out.println("Não foi possível subir o servidor...");
        }
    }
    
    public static void main(String[] args){
        
        try{
            ServerSocket server = new ServerSocket(50000);
            System.out.println("Servidor iniciado...");
            
            while(true){
                Socket conexao = server.accept();
                System.out.println("Uma nova conexão...");
                Servidor thread = new Servidor(conexao);
                thread.start();
            }
        }catch(IOException e){
            System.out.println("Erro ao conectar no servidor ....");
            e.printStackTrace();
        }
    }      
}
