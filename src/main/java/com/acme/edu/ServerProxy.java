package com.acme.edu;

public class ServerProxy {
    public static void log(Object message){
        if(message instanceof Integer){
            Logger.log((int)message);
        }
        else if(message instanceof Byte){
            Logger.log((byte)message);
        }
        else if(message instanceof String){
            Logger.log((String)message);
        }
        else if(message instanceof Character){
            Logger.log((char)message);
        }
        else if(message instanceof Boolean){
            Logger.log((boolean)message);
        }
        else if(message instanceof int[]){
            Logger.log((int[]) message);
        }
        else if(message instanceof int[][]){
            Logger.log((int[][]) message);
        }
        else{
            Logger.log(message);
        }
    }
}
