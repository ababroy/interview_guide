package com.dsa.linkedlist;

import java.util.Iterator;
import java.util.Stack;

/**
 * Utility class
 * 
 * @author AROY
 *
 */
public final class Utility
{
    private Utility ()
    {
    }

    enum Position
    {
        START, MIDDLE, END;
    }

    public static int linkedListSize ( Node head )
    {
        int count = 0;
        if ( head == null )
        {
            return count;
        }
        Node temp = head;
        while ( temp != null )
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void printLinkedList ( Node head )
    {
        if ( head != null )
        {
            Node temp = head;
            do
            {
                System.out.print( "[" + temp.data + "] -> " );
                temp = temp.next;
            }
            while ( temp != null );

            System.out.println( "[NULL]" );
        }
        else
        {
            System.out.println( "Oops! it's empty" );
        }
    }

    public static void updateLinkedList ( String operationName, Node head )
    {
        System.out.println( operationName );
        Utility.printLinkedList( head );
        System.out.println( "Linked List Size: " + Utility.linkedListSize( head ) );
        System.out.println();
    }

    public static void printReverseLinkedList ( Node head )
    {
        // long start = calculateExecutionTime();
        // System.out.println( "Execution Start time: " + start );
        // reverseMethod1( head ); // using stack
        // reverseMethod2( head ); // using array
        // reverseMethod3( head ); // moving head to end then print
        reverseMethod4( head ); //
        // System.out.println();
        // long end = calculateExecutionTime();
        // System.out.println( "Execution End time: " + end );
        // System.out.println( "Execution time: " + ( end - start ) );
    }

    /**
     * (Recursive way)
     * 
     * @param head
     */
    private static void reverseMethod4 ( Node head )
    {
        Node prev = null;
        Node current = head;
        Node startNode = recursiveWay( prev, current );
        printLinkedList( startNode );
    }

    private static Node recursiveWay ( Node prev, Node current )
    {
        Node currentNext = current.next;
        current.next = prev;
        prev = current;
        current = currentNext;
        if ( current != null )
        {
            return recursiveWay( prev, currentNext );
        }
        return prev;
    }

    /**
     * (Iterative way) - Moving head to end then print
     * 
     * @param head
     */
    private static void reverseMethod3 ( Node head )
    {
        if ( head != null )
        {
            Node temp = head;
            Node prev = null;
            Node tempNext = null;

            while ( temp != null )
            {
                tempNext = temp.next;
                temp.next = prev;
                prev = temp;
                temp = tempNext;
            }
            printLinkedList( prev );
        }
        else
        {
            System.out.println( "Oops! it's empty" );
        }
    }

    /**
     * Method-2 (using array)
     * 
     * @param head
     */
    private static void reverseMethod2 ( Node head )
    {

        int size = linkedListSize( head );
        int arr[] = new int[ size ];

        if ( head != null )
        {
            Node temp = head;
            int count = 0;
            do
            {
                arr[ count ] = temp.data;
                count++;
                temp = temp.next;
            }
            while ( temp != null );

            for ( int i = arr.length - 1; i >= 0; i-- )
            {
                if ( i == 0 )
                {
                    System.out.print( arr[ i ] + " -> NULL" );
                }
                else
                {
                    System.out.print( arr[ i ] + " -> " );
                }
            }
        }
        else
        {
            System.out.println( "Oops! it's empty" );
        }

    }

    /**
     * Method-1 - using Stack
     */
    private static void reverseMethod1 ( Node head )
    {

        Stack< Integer > stack = new Stack<>();
        if ( head != null )
        {
            Node temp = head;
            do
            {
                stack.push( temp.data );
                temp = temp.next;
            }
            while ( temp != null );

            while ( !stack.isEmpty() )
            {
                if ( stack.size() == 1 )
                {
                    System.out.print( "[" + stack.pop() + "] -> NULL" );
                }
                else
                {
                    System.out.print( "[" + stack.pop() + "] -> " );
                }
            }

        }
        else
        {
            System.out.println( "Oops! it's empty" );
        }

    }

    private static long calculateExecutionTime ()
    {
        return System.currentTimeMillis();
    }

}
