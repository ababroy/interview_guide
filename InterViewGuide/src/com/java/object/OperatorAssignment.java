package com.java.object;

/**
 * This class is meant for Operator assignment
 * 
 * @author AROY
 *
 */
public class OperatorAssignment implements Runnable
{
    
    public void run()
    {
        
    }
    public OperatorAssignment()
    {
        System.out.println( "OperatorAssignment no-args constructor" );
    }

    public void printByteWithIncrement ( byte a )
    {
        /**
         * max( int, byte of a, byte of b) => int [reason: byte < int]
         * 
         * Scenario: 1 byte add = a + 1; <= error bcz byte add can't hold the int value of (a+1)
         * 
         * Scenario: 2 byte add = a + b; <= error bcz byte add can't hold the int value of (a+b)
         * 
         * To overcome this problem, casting is required. that means
         * 
         * byte add = (byte) ( a+b );
         * 
         * 
         * 
         * Scenario: 3 byte add = a++; // here (type of a) followed by (a+1) that's why we won't get any error here
         */

        //
        byte b1 = 10;
        byte b2 = 20;
        System.out.println( b1 + b2 ); // this is valid bcz no assignment is required

        System.out.println( "byte add " + ( a++ ) );

    }

    /**
     * Char operator increment functionality
     * 
     * @param startingChar
     * @param range
     */
    public void printCharWithIncrement ( char startingChar, int range )
    {
        char ch = startingChar;
        int count = 0;
        while ( count < range )
        {
            count++;
            System.out.print( ch++ + " " );
        }
        System.out.println();
    }

    /**
     * division by zero
     * 
     * 
     */

    public void printNumberDivisionByZero ( double num )
    {
        /**
         * For Intergral(byte,short,int,long) number, you can't divide any number with zero
         * 
         * But for floating point number, you can divide any number with zero, since there is a way to represent the infinity(+ and -)
         * 
         * 10/0 => Arithmetic exception 10.0/0 = > Infinity
         * 
         * 0/0 = > Arithmetic Exception 0.0/0 => NaN
         * 
         * 
         */
        System.out.println( num + " division by zero is: " + ( num / 0 ) );

    }

    public void plusOperatorWithStringOrNumber ()
    {
        String str = "Abhijit";
        int a = 10, b = 20, c = 30;

        System.out.println( str + a + b + c );
        System.out.println( a + b + c + str );
        System.out.println( a + b + str + c );
        System.out.println( a + str + b + c );
    }
}
