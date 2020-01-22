package com.dsa.linkedlist;

public final class Utility
{

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
                System.out.print( "["+temp.data + "] -> " );
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
}
