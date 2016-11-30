/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totalordermulticast;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * @author Simone
 */
public class ClientHandler implements Runnable {
     private int port;


    private Forwarder forwarder;
    private Message message;

    private Message msg;
 
    private HashSet<Integer> connection;

    public ClientHandler(int port,HashSet<Integer> connection) {
        this.port=port;
    
        this.connection=connection;
       
        System.out.println("Sono il lato client del peer "+port+"i miei vicini sono ");
        for(int vicino: connection){
            System.out.println(vicino);
        }
        
        //E' la parte client del peer che chiede i vicini??
        
    }

    public int getPort() {
        return port;
    }

  


    public Forwarder getForwarder() {
        return forwarder;
    }

    public void setPort(int port) {
        this.port = port;
    }

  


    public void setForwarder(Forwarder forwarder) {
        this.forwarder = forwarder;
    }
    
  
       // this.forwarder=new Forwarder(link); //faccio conoscere i miei vicini al mio forwarder
        
 
   
    public void beginAlgorithm() throws IOException{

        
        
    }

    


    @Override
    public void run() {
        System.out.println(" sono il client :"+port);
        
    }
    
    
}
