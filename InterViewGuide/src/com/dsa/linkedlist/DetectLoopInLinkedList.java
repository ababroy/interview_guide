package com.dsa.linkedlist;

public final class DetectLoopInLinkedList
{
    private DetectLoopInLinkedList ()
    {
    }

    public static void detectLoopInLinkedList ( Node head )
    {
        if ( head != null )
        {
            Node slow = head;
            Node fast = slow.next;

            while ( fast != null )
            {
                slow = slow.next;
                fast = fast.next;
            }
            
            System.out.println( "Middle element " + slow.data );
        }
        else
        {
            System.out.println( "It's an empty linked list" );
        }
    }
}
