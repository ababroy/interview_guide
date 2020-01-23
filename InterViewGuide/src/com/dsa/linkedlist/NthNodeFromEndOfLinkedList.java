package com.dsa.linkedlist;

public final class NthNodeFromEndOfLinkedList
{
    private NthNodeFromEndOfLinkedList ()
    {
    }

    public static int printNthNodeFromEndOfLinkedList ( Node head, int nTh )
    {
        if ( head != null )
        {
            int size = Utility.linkedListSize( head );
            if ( size >= nTh )
            {
                Node targetNode = head;
                Node forwardNode = head;
                int count = 1;
                while( nTh > count)
                {
                    forwardNode = forwardNode.next;
                    count++;
                }
                while ( forwardNode.next != null )
                {
                    targetNode = targetNode.next;
                    forwardNode = forwardNode.next;
                }
                return targetNode.data;
            }
            else
            {
                return -1;
            }

        }
        else
        {
            return -1;
        }
    }
}
