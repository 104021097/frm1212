import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread {
    private NetGameServer gFrame;
    private ServerSocket svs;
    private InetAddress inetAddress;
    private Socket socket;
    private PrintStream outputStream;
    private BufferedReader inputStream;

    public Server (NetGameServer gFrame){
        gFrame = gFrame;
        try{
            inetAddress = InetAddress.getLocalHost();
            svs = new ServerSocket(gFrame.getPort());
        }catch (UnknownHostException e1){
            JOptionPane.showMessageDialog(gFrame,"Error:" + e1.toString());


        }catch (IOException ioe){
            JOptionPane.showMessageDialog(gFrame,"Error:" + ioe.toString());
        }
    }
    public void run(){
        try{
            socket = svs.accept();
            outputStream = new PrintStream(socket.getOutputStream());
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            gFrame.enableBtns();

        }
    }
}
