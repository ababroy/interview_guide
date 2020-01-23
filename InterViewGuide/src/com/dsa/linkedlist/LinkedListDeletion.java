package com.dsa.linkedlist;

public final class LinkedListDeletion
{
    private LinkedListDeletion ()
    {
    }

    public static void deleteLinkedList ( Node head )
    {
        if ( head != null )
        {
            head = null;
        }
        else
        {
            System.out.println( "Linked list is already empty" );
        }
        Utility.printLinkedList( head );
    }
}
