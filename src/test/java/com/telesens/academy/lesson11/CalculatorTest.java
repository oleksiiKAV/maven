package com.telesens.academy.lesson11;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.*;

public class CalculatorTest {
//NumberFormatException because we can get data from any sources
    @Test
    public void testDiv() {

        try {
            BigDecimal d1=new BigDecimal("5.0");
            BigDecimal d2=new BigDecimal("1");
            Calculator calc = new Calculator();
            BigDecimal d3 = BigDecimal.ZERO;
            d3= calc.div(d1,d2);
            System.out.println(d3);
        } catch (DivisionByZero divisionByZero) {
            //divisionByZero.printStackTrace();
            System.out.println("Second argument is ZERO");
        } catch (NumberFormatException ex){
            //ex.printStackTrace();
            System.out.println("Wrong Arguments");
        }
    }

    @Test
    public void testMult() {
        try {
            BigDecimal d1=new BigDecimal("5.0");
            BigDecimal d2=new BigDecimal("A");
            BigDecimal d3 = BigDecimal.ZERO;
            Calculator calc = new Calculator();
            d3=calc.mult(d1,d2);;
            System.out.println(d3);
        }
        catch (NumberFormatException ex){
            //ex.printStackTrace();
            System.out.println("Wrong Arguments");
        }
    }

    @Test
    public void testAdded() {
        try {
            BigDecimal d1=new BigDecimal("C.0");
            BigDecimal d2=new BigDecimal("1");
            BigDecimal d3 = BigDecimal.ZERO;
            Calculator calc = new Calculator();
            d3=calc.added(d1,d2);;
            System.out.println(d3);
        }
        catch (NumberFormatException ex){
            //ex.printStackTrace();
            System.out.println("Wrong Arguments");
        }
    }

    @Test
    public void testMinus() {
        try {
            BigDecimal d1=new BigDecimal("5.0");
            BigDecimal d2=new BigDecimal("A");
            BigDecimal d3 = BigDecimal.ZERO;
            Calculator calc = new Calculator();
            d3=calc.minus(d1,d2);;
            System.out.println(d3);
        }
        catch (NumberFormatException ex){
            //ex.printStackTrace();
            System.out.println("Wrong Arguments");
        }
    }
}