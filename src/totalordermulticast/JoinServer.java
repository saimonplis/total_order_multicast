/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totalordermulticast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author Simone
 */
public class JoinServer {
     private int port;
     private ServerSocket serverSocket;
      private TreeMap<Integer,HashSet<Integer>> tp;
     private HashSet<Integer> hs;
     private Socket client;
    public JoinServer(int port) throws FileNotFoundException, IOException {
        this.port=port;
        tp=new TreeMap<>();
        serverSocket=new ServerSocket(port);
        String text;
        BufferedReader br=new BufferedReader(new FileReader("C:/structure.txt"));
        Scanner s=null;
        
        while((text=br.readLine())!=null){
           
              s=new Scanner(text);
              int myport=s.nextInt(); 
              hs=new HashSet<>();
              while(s.hasNext()){
                  Integer element;
                  element=s.nextInt();
                  hs.add(element);
                  System.out.println("Sto aggiungendo a "+myport+" l'elemento "+element );
              }
              tp.put(myport, hs);
              
             
           
              
              

        }
       
    }
    public void execute() throws IOException{
        System.out.println("Server is listening at "+port);
        Executor executor= Executors.newFixedThreadPool(1000);
        while(true){
                   client=serverSocket.accept();
                   executor.execute(new JServerHandler(client,tp));
        }
    }
 /* for(Map.Entry<Integer, HashSet<Integer>> entry : tp.entrySet()) {
  Integer key = entry.getKey();
  System.out.println("Sono il peer "+key+"I miei vicini sono: ");
  Iterator it=entry.getValue(key).iterator();
  for(;it.hasNext();){
     System.out.println((Integer)it.next());
      
  }

}*/
        
    
    public static void main(String args[]) throws IOException{
        JoinServer js;
         try {
             js=new JoinServer(1099);
             js.execute();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(JoinServer.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    
}
