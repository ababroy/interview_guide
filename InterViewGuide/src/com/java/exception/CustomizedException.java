package com.java.exception;

/**
 *      https://www.youtube.com/watch?v=zMTsTZH_EhU
 *      
 * @author AROY
 *
 */
public class CustomizedException
{
    public static void main ( String[] args ) throws Throwable 
    {
        int age = Integer.parseInt( args[0] );
        if(age < 18)
        {
            throw new AgeException(" You are not adult");
        }
        else if( age > 60)
        {
            throw new AgeException( "You are retired" );
        }
        else
        {
            System.out.println( "You are Adult" );
        }
    }
}

class AgeException
    extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public AgeException ( String msg ) throws Exception
    {
        super( msg );
    }
}
