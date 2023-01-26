package codes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    
    public static void main(String[] args) throws IOException {

    int port=3000;

    ServerSocket serSoc = new ServerSocket(port);
    System.out.println("Waiting for client connection...");

    Socket soc = serSoc.accept();
    System.out.println("Client is connected!!!!");

    clientHandler han = new clientHandler(soc);
    han.handle();
    
    serSoc.close();

}
}
