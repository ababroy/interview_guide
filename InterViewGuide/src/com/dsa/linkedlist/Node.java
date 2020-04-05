package com.dsa.linkedlist;

public class Node
{
    Node next;

    int data;

    Node ( int data )
    {
        this.data = data;
        next = null;
    }
    
    Node ( int data, Node next)
    {
        this.data = data;
        this.next =  next;
    }
}
