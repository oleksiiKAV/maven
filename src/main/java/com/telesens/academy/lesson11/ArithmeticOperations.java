package com.telesens.academy.lesson11;

import java.math.BigDecimal;

public interface ArithmeticOperations {
  BigDecimal div (BigDecimal x1, BigDecimal x2) throws DivisionByZero, NumberFormatException;
  BigDecimal mult (BigDecimal x1, BigDecimal x2) throws NumberFormatException;
  BigDecimal added ( BigDecimal x1, BigDecimal x2) throws NumberFormatException;
  BigDecimal minus ( BigDecimal x1, BigDecimal x2) throws NumberFormatException;
 // BigDecimal sqrt ( BigDecimal x1) throws SQRTException;


}
