package com.osproject.shell.windows.main;

import com.osproject.shell.windows.components.LoginFrame;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public Socket initConnection() {

        int port = 2704;
        InetAddress IP;
        Socket socket = new Socket();

        try {
            System.out.println("client@windows~$ Establishing connection to server...");
            IP = InetAddress.getByName("192.168.100.192");
            socket = new Socket(IP, port);
            System.out.println("client@windows~$ Connection to server established");

        } catch (UnknownHostException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("client@windows~$ Could not connect to server:");
            ex.printStackTrace();
        }

        return socket;
    }

    public static void main(String[] args) {
        new LoginFrame(new Main().initConnection()).setVisible(true);
    }
}
