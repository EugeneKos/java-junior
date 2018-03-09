package com.acme.edu.formatter;

import com.acme.edu.commander.*;

public class PostfixFormatter implements FormatVisitor {

    @Override
    public String formatInteger(IntegerCommand integerCommand) {
        return integerCommand.getBuffer()+" postfix";
    }

    @Override
    public String formatString(StringCommand stringCommand) {
        return null;
    }

    @Override
    public String formatByte(ByteCommand byteCommand) {
        return null;
    }

    @Override
    public String formatChar(CharCommand charCommand) {
        return null;
    }

    @Override
    public String formatBoolean(BooleanCommand booleanCommand) {
        return null;
    }

    @Override
    public String formatArray(ArrayCommand arrayCommand) {
        return null;
    }

    @Override
    public String formatMatrix(MatrixCommand matrixCommand) {
        return null;
    }

    @Override
    public String formatObject(ObjectCommand objectCommand) {
        return null;
    }
}
