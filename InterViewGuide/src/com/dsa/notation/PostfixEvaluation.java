package com.dsa.notation;

import java.util.Stack;

public class PostfixEvaluation
{

    public static boolean operatorValue ( String string )
    {
        switch ( string )
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                return true;
        }
        return false;
    }

    private static int performPostfixEvaluation ( String exp )
    {
        Stack< Integer > stack = new Stack<>();
        if ( !exp.trim().equals( "" ) || exp != null )
        {
            String[] strings = exp.split( "," );
            for ( int i = 0; i < strings.length; i++ )
            {
                String str = strings[ i ];
                if ( str == " " || str == "," )
                    continue;
                boolean isOperator = operatorValue( str );
                if ( isOperator == true )
                {
                    int oparand1 = stack.pop();
                    int oparand2 = stack.pop();
                    String operator = str;
                    int result = calculate( oparand1, oparand2, operator );
                    stack.push( result );
                }
                else
                {
                    int data = Integer.parseInt(str);
                    stack.push( data );
                }
            }
        }

        return stack.pop();
    }

    private static int calculate ( int oparand1, int oparand2, String operator )
    {
        int result = 0;
        switch ( operator )
        {
            case "+":
                result = oparand1 + oparand2;
                break;
            case "-":
                result = oparand1 - oparand2;
                break;
            case "*":
                result = oparand1 * oparand2;
                break;
            case "/":
                result = oparand1 / oparand2;
                break;
        }
        return result;
    }

    public static void main ( String[] args )
    {
        String exp = "02,3,*,5,4,*,+,29,-";

        int result = performPostfixEvaluation( exp );

        System.out.println( result );
    }
}
