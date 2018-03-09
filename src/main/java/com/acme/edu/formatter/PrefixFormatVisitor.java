package com.acme.edu.formatter;

import com.acme.edu.commander.*;

/**
 * @author MishaAndEugen
 * класс PrefixFormatVisitor отвечает за возможность изменения стиля вывода
 */
public class PrefixFormatVisitor implements FormatVisitor {

    @Override
    public String formatInteger(IntegerCommand integerCommand) {
        return "primitive: "+integerCommand.getBuffer();
    }

    @Override
    public String formatString(StringCommand stringCommand) {
        return "string: "+stringCommand.getFullStr();
    }

    @Override
    public String formatByte(ByteCommand byteCommand) {
        return "primitive: "+byteCommand.getBuffer();
    }

    @Override
    public String formatChar(CharCommand charCommand) {
        return "char: "+charCommand.getCharMessage();
    }

    @Override
    public String formatBoolean(BooleanCommand booleanCommand) {
        return "primitive: "+booleanCommand.getBooleanMessage();
    }

    @Override
    public String formatArray(ArrayCommand arrayCommand) {
        return "primitives array: "+arrayCommand.getForPrint();
    }

    @Override
    public String formatMatrix(MatrixCommand matrixCommand) {
        return "primitives matrix: "+matrixCommand.getForPrint();
    }

    @Override
    public String formatObject(ObjectCommand objectCommand) {
        return "reference: @"+objectCommand.getObjectMessage();
    }
}
