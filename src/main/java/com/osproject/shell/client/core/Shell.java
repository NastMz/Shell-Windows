/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.osproject.shell.client.core;

import com.osproject.shell.client.components.LoginFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ksmar
 */
public class Shell extends Thread {

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private LoginFrame loginFrame;

    public Shell(LoginFrame loginFrame) {
        try {
            this.loginFrame = loginFrame;
            this.dataInputStream = new DataInputStream(this.loginFrame.getSocket().getInputStream());
            this.dataOutputStream = new DataOutputStream(this.loginFrame.getSocket().getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String executeCommand(String command) {
        try {
            dataOutputStream.writeUTF(command);
            System.out.println(Arrays.toString(dataInputStream.readAllBytes()));
            InetAddress IP = this.loginFrame.getSocket().getInetAddress();
            int port = this.loginFrame.getSocket().getPort();
            this.loginFrame.getSocket().close();
            this.loginFrame.setSocket(new Socket(IP, port));

        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Comando ejecutado";
    }

}
