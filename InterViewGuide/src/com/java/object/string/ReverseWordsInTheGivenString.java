package com.java.object.string;

public class ReverseWordsInTheGivenString
{
    public static void main ( String[] args )
    {
        String str = "i.like.this.program.very.much";

        String[] arr = str.split( "\\." );

        try
        {
            for ( int i = arr.length - 1; i >= 0; i-- )
            {
                if ( i == 0 )
                {
                    System.out.print( arr[ i ] );
                }
                else
                {
                    System.out.print( arr[ i ] + "." );
                }
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
