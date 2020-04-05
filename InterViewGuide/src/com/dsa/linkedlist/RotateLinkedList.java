package com.dsa.linkedlist;

public final class RotateLinkedList
{
    public static Node rotate ( Node head, int k )
    {
        Node start = head;
        // add code here.
        if ( head != null )
        {
            Node rStart = null, rEnd = null;

            Node current = head;
            int count = 1;
            while ( count < k && current != null )
            {
                if ( current.next == null && count == k - 1 )
                {
                    return start;
                }
                current = current.next;
                count++;
            }
            rStart = current;
            if ( current != null )
                rEnd = current.next;
            if ( rStart != null )
                rStart.next = null;

            current = rEnd;
            Node prev = null;
            while ( current != null )
            {
                prev = current;
                current = current.next;
            }
            if ( prev != null )
                prev.next = start;

            return rEnd != null ? rEnd : start;
        }
        return start;

    }
}
