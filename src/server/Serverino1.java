/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martoccia.lorenzo
 */
public class Serverino1 implements Runnable {
    
    private Socket clientSocket;
    
    public Serverino1(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream In = new ObjectInputStream(clientSocket.getInputStream());
            char[] lista = (char[]) In.readObject();
            In.close();
            for (int i = 0; i < lista.length; i++) {
                System.out.print(lista[i] + ", ");
            }
            System.out.println("");
            System.out.println("FINE");
        } catch (IOException ex) {
            Logger.getLogger(Serverino1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serverino1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
