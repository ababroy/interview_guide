package com.dsa.basics;

public class Palindrome
{
    public static void main ( String[] args )
    {
        String input = "abccccccccccccccccccccccccccba"; // "ababa" // abba // aba // abccccccccccccccccccccccccccba

        isPalindromeUsingReverse( input );
        isPalindromeUsingMidPoint( input );
        isPalindromeUsingStartEndCrossPoint( input );

    }

    private static void isPalindromeUsingReverse ( String input )
    {
        char[] arr = input.toCharArray();
        int length = arr.length-1;
        String reverseString = new String("");
        while( length >= 0 )
        {
            reverseString = reverseString + arr[length] ;
            length--;
        }
        if( reverseString.equals( input ))
        {
            System.out.println( "It's a palindrome" );
        }
        else
        {
            System.out.println( "It's not a palindrome" );
        }
        
    }

    private static void isPalindromeUsingStartEndCrossPoint ( String input )
    {
        int start = 0;
        char[] charArray = input.toCharArray();
        int length = charArray.length;
        boolean flag = false;
        if ( length % 2 == 0 )
        {
            while ( start <= length )
            {
                if ( charArray[ start ] == charArray[ length - 1 ] )
                {
                    start++;
                    length--;
                    continue;
                }
                else
                {
                    flag = true;
                    break;
                }
            }
            if ( flag == true )
            {
                System.out.println( "It's not a palindrome" );
            }
            else
            {
                System.out.println( "It's a palindrome" );
            }
        }
        else
        {
            while ( start < length )
            {
                if ( charArray[ start ] == charArray[ length - 1 ] )
                {
                    start++;
                    length--;
                    continue;
                }
                else
                {
                    flag = true;
                    break;
                }
            }
            if ( flag == true )
            {
                System.out.println( "It's not a palindrome" );
            }
            else
            {
                System.out.println( "It's a palindrome" );
            }
        }

    }

    private static void isPalindromeUsingMidPoint ( String input )
    {
        char[] charArray = input.toCharArray();
        int length = charArray.length;
        int mid = 0;
        boolean flag = false;
        if ( length % 2 == 0 )
        {
            mid = length / 2;
            for ( int i = 0; i < mid; i++ )
            {
                if ( charArray[ i ] == charArray[ length - 1 ] )
                {
                    length--;
                    continue;
                }
                else
                {
                    flag = true;
                }
            }
            if ( flag == true )
            {
                System.out.println( "It's not a palindrome" );
            }
            else
            {
                System.out.println( "It's a palindrome" );
            }
        }
        else
        {
            mid = length / 2;
            for ( int i = 0; i <= mid; i++ )
            {
                if ( charArray[ i ] == charArray[ length - 1 ] )
                {
                    length--;
                    continue;
                }
                else
                {
                    flag = true;
                }
            }
            if ( flag == true )
            {
                System.out.println( "It's not a palindrome" );
            }
            else
            {
                System.out.println( "It's a palindrome" );
            }
        }
    }
}
