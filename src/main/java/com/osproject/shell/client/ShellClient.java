
import com.osproject.shell.client.components.LoginFrame;
import com.osproject.shell.client.utils.ConsoleColors;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShellClient {

    private Socket socket = null;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void initConnection() {

        int port = 2704;
        InetAddress IP;

        while (socket == null) {
            try {
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.CYAN + "Establishing connection to server..." + ConsoleColors.RESET);
                IP = InetAddress.getLocalHost();
                this.socket = new Socket(IP, port);
                this.dataInputStream = new DataInputStream(socket.getInputStream());
                this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.GREEN + "Connection to server established" + ConsoleColors.RESET);
            } catch (UnknownHostException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.RED + "Could not connect to server" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.PURPLE + "Trying to connect again..." + ConsoleColors.RESET);
            }

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public static void main(String[] args) {

        ShellClient shellClient = new ShellClient();
        shellClient.initConnection();
        new LoginFrame(shellClient.getSocket(), shellClient.dataOutputStream, shellClient.getDataInputStream()).setVisible(true);
    }
}
