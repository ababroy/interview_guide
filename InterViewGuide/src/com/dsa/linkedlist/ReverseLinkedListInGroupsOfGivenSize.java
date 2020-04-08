package com.dsa.linkedlist;

/**
 * Reverse a Linked List in groups of given size
 * 
 * @author royabhix
 *
 */
public final class ReverseLinkedListInGroupsOfGivenSize
{
    private ReverseLinkedListInGroupsOfGivenSize ()
    {
    }

    /**
     * Input : 1 2 3 4 5 6 7 8
     * 
     * Output: 4 3 2 1 8 7 6 5
     * 
     * @param head
     * @param rotatePoint
     */
    public static void reverseLinkedListInGroupsOfGivenSize ( Node head, int rotatePoint )
    {

        if ( head != null )
        {
            int count = 1;
            Node current = head;
            Node prev = null;
            Node preGroupStart = null;
            Node preGroupEnd = null;
            Node temp = null;
            Node start = head;

            while ( current != null )
            {
                if ( count == rotatePoint )
                {
                    preGroupStart = current;
                    preGroupEnd = start;

                    System.out.println( "PreGroup Start : " + preGroupStart.data );
                    count = 1;
                }
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count++;
            }

            Utility.printLinkedList( prev );
        }
        else
        {
            System.out.println( "It's an Empty Linked list" );
        }

    }

    /**
     * reverseLinkedListInGivenSize
     * 
     * @param head
     * @param rotatePoint
     */
    public static void reverseLinkedListInGivenSize ( Node head, int rotatePoint )
    {
        if ( head != null )
        {
            int size = Utility.linkedListSize( head );
            if ( size > rotatePoint )
            {
                Node start = head;
                Node midStart = null;
                Node midEnd = null;
                int count = 0;
                while ( head.next != null )
                {
                    if ( count == rotatePoint - 1 )
                    {
                        midStart = head;
                    }

                    head = head.next;
                    count++;
                }

                midEnd = midStart.next;
                head.next = start;
                head = midEnd;
                midStart.next = null;
                System.out.println( "MidStart.data = " + midStart.data + " MidEnd.data = " + midEnd.data );
                System.out.println( "Head.data = " + head.data );
                System.out.println( "Start.data = " + start.data );
            }
            else
            {
                System.out.println( "Rotate not possible!" );
                return;
            }
        }
        else
        {
            System.out.println( "It's an Empty Linked list" );
        }
        // Utility.printLinkedList( head );
        Utility.printReverseLinkedList( head );
    }
}
