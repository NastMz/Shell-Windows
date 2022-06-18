package com.osproject.shell.client.core;

import com.osproject.shell.client.utils.ConsoleColors;
import com.osproject.shell.client.utils.Hasher;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    private boolean loginStatus;

    public Login() {
        this.loginStatus = false;
    }

    public boolean isLogin() {
        return loginStatus;
    }

    public void login(Socket socket, String userName, String password) {
        try {
            Hasher hasher = new Hasher();

            String hashedPassword = hasher.hash(password);
            String request = "1::" + userName + ":" + hashedPassword;

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            outputStream.writeUTF(request);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            this.loginStatus = inputStream.readBoolean();

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.RED + "Failed to execute login request" + ConsoleColors.RESET);
        }
    }
}
