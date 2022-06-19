/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.osproject.shell.client.core;

import com.osproject.shell.client.components.LoginFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ksmar
 */
public class Shell extends Thread {

    private final LoginFrame loginFrame;

    public Shell(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public String executeCommand(String command) {
        String response = "No se pudo ejecutar el comando";
        try {
            this.loginFrame.getDataOutputStream().writeUTF("2::" + command);
            response = this.loginFrame.getDataInputStream().readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
