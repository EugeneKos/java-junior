package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
    private String address;
    private int port;

    public Connector(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void send(Object object) {
        try (Socket connection = getConnection();
             ObjectOutputStream os = new ObjectOutputStream(connection.getOutputStream());
             ObjectInputStream is = new ObjectInputStream(connection.getInputStream())) {

            System.out.println("ready to send");
            os.writeObject(object);
            System.out.println((String) is.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    private Socket getConnection() throws IOException {
        return new Socket(InetAddress.getByName(address), port);
    }


}
