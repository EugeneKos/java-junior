package com.acme.edu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor {

    public void start(){
        try (ServerSocket portListener = new ServerSocket(4040)){

            while(true){
                System.out.println("listening...");
                try(Socket socket = portListener.accept();
                    ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream())) {
                    System.out.println("connection OK");
                    while(true){
                        //int temp = (int) is.readObject();
                        //Logger.log((int) is.readObject());
                        ServerProxy.log(is.readObject());
                        Logger.flush();
                        os.writeObject("logger wrote");
                    }

                } catch (IOException e){
                    //e.printStackTrace();
                    System.out.println("client terminated");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
