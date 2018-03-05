package com.acme.edu;

import com.acme.edu.disign.Design;
import com.acme.edu.handler.*;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

/**
 * Logs messages.
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {
    private static LoggerController loggerController = new LoggerController();
    private static Printer printer = new ConsolePrinter();

    public static void log(int message) {
        //region output
        Handler handler = new IntegerHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(byte message) {
        //region output
        Handler handler = new ByteHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(char message) {
        //region output
        Handler handler = new CharHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(String message) {
        //region output
        Handler handler = new StringHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(boolean message) {
        //region output
        Handler handler = new BooleanHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(Object message) {
        //region output
        Handler handler = new ObjectHandler(message,printer);
        loggerController.execute(handler);
        //endregion
    }

    public static void log(int[] array){
        Handler handler = new ArrayHandler(array,printer);
        loggerController.execute(handler);
    }

    public static void log(int[][] matrix){
        Handler handler = new MatrixHandler(matrix,printer);
        loggerController.execute(handler);
    }

    public static void flush(){
        loggerController.flush();
    }

}