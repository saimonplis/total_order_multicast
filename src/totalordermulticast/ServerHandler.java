/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totalordermulticast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simone
 */
public class ServerHandler implements Runnable  {
        private Socket client;
    private int port;
    private HashSet<Integer> link;
    
   
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private static int nm;
    private Forwarder forward;
    public ServerHandler(Socket client,Integer port,HashSet<Integer> link) throws IOException {
        this.client=client;
        this.port=port;
        this.link=link;
    
        in=new ObjectInputStream(client.getInputStream());
        out=new ObjectOutputStream(client.getOutputStream());
        forward=new Forwarder(link);
    }
    public void processMessage(Message message) throws IOException{
        
       
 
    }
                                                                                
       


    @Override
    public void run() {
        try {
            processMessage((Message)in.readObject());
      //      recordState();
        //    forwardMessage();
            
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
