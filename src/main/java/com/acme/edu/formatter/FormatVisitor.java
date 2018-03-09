package com.acme.edu.formatter;

import com.acme.edu.commander.*;

/**
 * @author MishaAndEugen
 * класс дизайн отвечает за стиль вывода
 */
public interface FormatVisitor {
    default void visit(Command command){
        command.accept(this);
    }
    String formatInteger(IntegerCommand integerCommand);
    String formatString(StringCommand stringCommand);
    String formatByte(ByteCommand byteCommand);
    String formatChar(CharCommand charCommand);
    String formatBoolean(BooleanCommand booleanCommand);
    String formatArray(ArrayCommand arrayCommand);
    String formatMatrix(MatrixCommand matrixCommand);
    String formatObject(ObjectCommand objectCommand);

}
