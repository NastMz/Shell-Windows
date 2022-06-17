
import com.osproject.shell.client.components.LoginFrame;
import com.osproject.shell.client.utils.ConsoleColors;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShellClient {

    public Socket initConnection() {

        int port = 2704;
        InetAddress IP;
        Socket socket = null;

        while (socket == null) {
            try {
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.CYAN + "Establishing connection to server..." + ConsoleColors.RESET);
                IP = InetAddress.getLocalHost();
                socket = new Socket(IP, port);
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.GREEN + "Connection to server established" + ConsoleColors.RESET);
            } catch (UnknownHostException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.RED + "Could not connect to server" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "client@windows~$ " + ConsoleColors.PURPLE + "Trying to connect again..." + ConsoleColors.RESET);
            }

        }

        return socket;
    }

    public static void main(String[] args) {
        new LoginFrame(new ShellClient().initConnection()).setVisible(true);
    }
}
