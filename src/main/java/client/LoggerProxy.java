package client;

public class LoggerProxy {
    public static void log(Object message) {
        //region output
        Connector connector = new Connector("127.0.0.1",4040);
        connector.send(message);
        //endregion
    }

}
