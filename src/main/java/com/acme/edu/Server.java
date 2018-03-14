package com.acme.edu;

public class Server {
    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor();
        acceptor.start();
    }
}
