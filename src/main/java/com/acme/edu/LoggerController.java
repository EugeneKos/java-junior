package com.acme.edu;

import com.acme.edu.handler.DefaultHandler;
import com.acme.edu.handler.Handler;
import com.acme.edu.handler.StringHandler;

public class LoggerController {

    //private Printer printer = new ConsolePrinter();
    private Handler currentHandler = new DefaultHandler();

    public void execute(Handler handler){
        if(handler.getClass().equals(currentHandler.getClass())){
            handler.setBuffer(currentHandler.getBuffer());
        } else {
            flush();
        }
        handler.handle();
        currentHandler = handler;
    }


    public void flush(){
        currentHandler.flush();
    }

}
