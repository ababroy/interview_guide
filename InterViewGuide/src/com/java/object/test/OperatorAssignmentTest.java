package com.java.object.test;

import org.junit.Test;

import com.java.object.OperatorAssignment;

public class OperatorAssignmentTest
{
    @Test
    public void test()
    {
        OperatorAssignment oa = new OperatorAssignment();
        oa.printCharWithIncrement('A', 100);
        
        oa.printByteWithIncrement((byte)10);
        
        oa.printNumberDivisionByZero(10.0d);
        oa.printNumberDivisionByZero(0.0);
        
        oa.plusOperatorWithStringOrNumber();
    }
}
