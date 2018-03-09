package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class MatrixCommand implements Command {
    private int[][] matrixMessage;
    private String forPrint;
    private boolean isFlush;

    public MatrixCommand(int[][] message) {
        matrixMessage = message;
    }

    public int[][] getMatrixMessage() {
        return matrixMessage;
    }

    public String getForPrint() {
        return forPrint;
    }

    private void buildArrayString(){
        forPrint = ArrayUtils.arrayToString(matrixMessage);
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof MatrixCommand){
            matrixMessage = ((MatrixCommand)command).getMatrixMessage();
            buildArrayString();
            isFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatMatrix(this);
    }

    @Override
    public void flush() {
        isFlush = false;
    }

    @Override
    public boolean isFlush() {
        return isFlush;
    }

    @Override
    public String toString(){
        return forPrint;
    }

}
