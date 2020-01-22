package com.dsa.linkedlist;

import com.dsa.linkedlist.Utility.Position;

public class SinglyLinkedList
{
    static Node head = null;

    public static void main ( String[] args )
    {
        head = new Node( 10 );
        addNode( 20, Position.END );
        addNode( 30, Position.END );
        addNode( 40, Position.END );
        addNode( 50, Position.END );
        Utility.printLinkedList( head );
        int size = Utility.linkedListSize( head );
        System.out.println( "Linked List Size: " + size );

        addNode( 5, Position.START );
        Utility.printLinkedList( head );
        size = Utility.linkedListSize( head );
        System.out.println( "Linked List Size: " + size );

        addNode( 35, Position.MIDDLE );
        Utility.printLinkedList( head );
        size = Utility.linkedListSize( head );
        System.out.println( "Linked List Size: " + size );
    }

    private static void addNode ( int data, Position position )
    {
        switch ( position )
        {
            case START:
                addNodeStart( data );
                break;
            case MIDDLE:
                addNodeMiddle( data, head );
                break;
            case END:
                addNodeEnd( data, head );
                break;
        }

    }

    private static void addNodeStart ( int data )
    {
        if ( head == null )
        {
            head = new Node( data );
        }
        else
        {
            Node startNode = new Node( data );
            startNode.next = head;
            head = startNode;
        }
    }

    /**
     * 
     * @param data
     * @param head
     */

    private static void addNodeMiddle ( int data, Node head )
    {
        if ( head == null )
        {
            head = new Node( data );
        }
        /*
         * Method-1 : Count and go upto mid length
         */
        // int size = Utility.linkedListSize( head );
        // int position = size / 2;
        // Node mid = head;
        // for ( int i = 0; i < position; i++ )
        // {
        // mid = mid.next;
        // }
        // Node midNext = mid.next;
        //
        // mid.next = new Node( data );
        // mid.next.next = midNext;

        /*
         * Method-2 :: Take two variable node ( [slow Node]: go to 1 step ahead and [Fast Node]: go to 2 step ahead)
         */
        Node slowNode = head;
        Node fastNode = slowNode.next;
        while ( fastNode.next != null )
        {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        Node nextSlowNode = slowNode.next;
        slowNode.next = new Node( data );
        slowNode.next.next = nextSlowNode;

    }

    private static void addNodeEnd ( int data, Node head )
    {
        Node temp = head;
        if ( temp == null )
        {
            head = new Node( data );
        }
        while ( temp.next != null )
        {
            temp = temp.next;
        }
        if ( temp.next == null ) // double check
        {
            temp.next = new Node( data );
        }
    }

}
