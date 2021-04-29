/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alampi.adrian
 */
public class Clientino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket SocketServer = new Socket("127.0.0.1", 5000);
            ObjectOutputStream OS = new ObjectOutputStream(SocketServer.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(SocketServer.getInputStream()));
            String s = "";
            while (!s.equals("exit")) {
                char[] lista = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
                for (int i = 0; i < lista.length; i++) {
                    lista[i] = lista[(int) (Math.random() * 10)];
                    System.out.println("lista " + lista[i]);
                    OS.writeObject(lista);
                }
                break;
            }
            in.close();
            SocketServer.close();
        } catch (IOException ex) {
            Logger.getLogger(Clientino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
