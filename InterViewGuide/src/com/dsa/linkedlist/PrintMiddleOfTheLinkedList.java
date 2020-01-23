package com.dsa.linkedlist;

import static com.dsa.linkedlist.Utility.linkedListSize;

public final class PrintMiddleOfTheLinkedList
{
    private PrintMiddleOfTheLinkedList ()
    {
    }

    public static void printMiddleNodeOfLinkedList ( Node head )
    {
        // int mid = method1( head );
        int mid = method2( head );
        System.out.println( "LinkedList middle element is " + mid );
    }

    private static int method2 ( Node head )
    {
        if ( head != null )
        {
            if ( head.next == null )
            {
                return head.data;
            }
            Node slow = head;
            Node fast = slow.next;
            while ( fast != null )
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
        else
        {
            System.out.println( "Empty LinkedList" );
        }
        return -1;
    }

    private static int method1 ( Node head )
    {
        if ( head != null )
        {
            Node temp = head;
            int size = linkedListSize( temp );
            int mid = size / 2;
            for ( int i = 0; i < mid; i++ )
            {
                temp = temp.next;
            }

            return temp.data;
        }
        else
        {
            System.out.println( "Empty LinkedList" );
        }

        return -1;
    }
}
