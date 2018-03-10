package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс MatrixCommand предназначен для получения новой команды с сообщением типа int[][] и
 * передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class MatrixCommand implements Command {
    private int[][] matrixMessage;
    private String result;
    private boolean readyFlush;

    public MatrixCommand(int[][] message) {
        matrixMessage = message;
    }

    public int[][] getMatrixMessage() {
        return matrixMessage;
    }

    public String getResult() {
        return result;
    }

    private void buildArrayString(){
        result = ArrayUtils.arrayToString(matrixMessage);
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof MatrixCommand){
            matrixMessage = ((MatrixCommand)command).getMatrixMessage();
            buildArrayString();
            readyFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result = formatVisitor.formatMatrix(this);
    }

    @Override
    public void flush() {
        readyFlush = false;
    }

    @Override
    public boolean isReadyFlush() {
        return readyFlush;
    }

    @Override
    public String toString(){
        return result;
    }

}
