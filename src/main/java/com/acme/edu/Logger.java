package com.acme.edu;

import com.acme.edu.commander.*;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

/**
 * Главный класс Логирования.
 * @author MishaAndEugene
 */
public class Logger {
    private static LoggerController loggerController = new LoggerController(message -> System.out.println(message));

    public static void log(int message) {
        //region output
        Command command = new IntegerCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(byte message) {
        //region output
        Command command = new ByteCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(char message) {
        //region output
        Command command = new CharCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(String message) {
        //region output
        Command command = new StringCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(boolean message) {
        //region output
        Command command = new BooleanCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(Object message) {
        //region output
        Command command = new ObjectCommand(message);
        loggerController.execute(command);
        //endregion
    }

    public static void log(int[] array){
        Command command = new ArrayCommand(array);
        loggerController.execute(command);
    }

    public static void log(int[][] matrix){
        Command command = new MatrixCommand(matrix);
        loggerController.execute(command);
    }

    public static void flush(){
        loggerController.flush();
    }

}