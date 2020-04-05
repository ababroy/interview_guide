package com.java.object.string;

public class ImplementStrStr
{

    public static void main ( String[] args )
    {
        // TODO Auto-generated method stub
        int i = strstr( "abcabcabcd", "abcd" );
        System.out.println( i );
    }

    private static int strstr ( String str, String target )
    {
        // Your code here
        for ( int i = 0; i < str.length(); i++ )
        {
            if ( str.charAt( i ) == target.charAt( 0 ) )
            {
                try
                {
                    System.out.println( i + "..." + ( i + target.length() ) );
                    String val = str.substring( i, ( i + target.length() ) );
                    if ( val.equals( target ) )
                    {
                        return i;
                    }
                    else
                    {
                        continue;
                    }
                }
                catch ( Exception e )
                {
                    return -1;
                }
            }

        }
        return -1;
    }
}
