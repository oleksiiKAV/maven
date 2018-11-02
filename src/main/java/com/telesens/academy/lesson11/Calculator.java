package com.telesens.academy.lesson11;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.NumberFormatException;

public class Calculator implements ArithmeticOperations{
    private static final int SCALE = 5;

    @Override
    public BigDecimal div(BigDecimal x1, BigDecimal x2) throws DivisionByZero, NumberFormatException {
        if (x2.compareTo(BigDecimal.ZERO) == 0)
            throw new DivisionByZero();

        return x1.divide(x2, SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal mult(BigDecimal x1, BigDecimal x2) throws NumberFormatException {

            return x1.multiply(x2);

        }

    @Override
    public BigDecimal added(BigDecimal x1, BigDecimal x2) throws NumberFormatException {
        return x1.add(x2);
    }

    @Override
    public BigDecimal minus(BigDecimal x1, BigDecimal x2) throws NumberFormatException {
        return x1.subtract(x2);
    }


}



