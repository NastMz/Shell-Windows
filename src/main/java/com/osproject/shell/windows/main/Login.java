package com.osproject.shell.windows.main;

import com.osproject.shell.windows.utils.Hasher;
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

            String hashedPassword;
            String request;

            DataOutputStream outputStream;

            DataInputStream inputStream;

            hashedPassword = hasher.hash(password);
            request = userName + ":" + hashedPassword;

            outputStream = new DataOutputStream(socket.getOutputStream());

            outputStream.writeUTF(request);

            inputStream = new DataInputStream(socket.getInputStream());

            this.loginStatus = inputStream.readBoolean();

            inputStream.close();
            outputStream.close();

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("client@windows~$ Failed to execute login request:");
            ex.printStackTrace();
        }
    }
}
