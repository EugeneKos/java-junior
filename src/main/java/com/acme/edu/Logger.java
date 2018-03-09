package com.acme.edu;

import com.acme.edu.commander.*;
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
    private static LoggerController loggerController = new LoggerController(message -> System.out.println(message));
    private static Printer printer = new ConsolePrinter();

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

    public static void main(String[] args) {
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();

        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();

        Logger.log('a');
        Logger.flush();
        Logger.log('b');
        Logger.flush();

        Logger.log("test string 1");
        Logger.flush();
        Logger.log("other str");
        Logger.flush();

        Logger.log(true);
        Logger.flush();
        Logger.log(false);
        Logger.flush();

        Logger.log(new Object());
        Logger.flush();

        System.out.println("/////////////////////////////////////");

        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        Logger.log("str 1");
        Logger.log(10);
        Logger.log(10);
        Logger.log(10);
        Logger.log(10);
        Logger.log(10);
        Logger.log(10);
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flush();

        System.out.println("///////////////////////////");

        Logger.log(new int[] {-1, 0, 1});
        Logger.flush();

        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.flush();
    }

}