/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class Server {
    private int port;
    // Name, MSSV, LSH, Mark, NNumber_Error, Detecting_Error
    public static int StudentInfoNum = 6;

    public Server(int port){
        System.out.println("Hello");
        this.port = port;
        this.execute();
    }
    
    public void execute(){
         try{
            ServerSocket serverSocket = new ServerSocket(port);
 
            // Create Socket for each user
            while (true) {
                Socket socket = serverSocket.accept(); 
                System.out.println("New User");
                ClientHandler clientSock = new ClientHandler(socket);
                new Thread(clientSock).start();
            }
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        Server server = new Server(6666);
    }
    
}