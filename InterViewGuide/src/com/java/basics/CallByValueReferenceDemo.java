package com.java.basics;

/**
 * r0 object reference will stored in to stack area and refer to Object Rectangle() // initially r0.length =10
 * 
 * r1 object reference stored into stack area and refer to the same Object Rectangle
 * 
 * r1.length = 20 // data changed by modify(x) => here r0.length would be the 20 as both are pointing to the same heap object Rectangle()
 * 
 */
public class CallByValueReferenceDemo
{
    public static void main ( String[] args )
    {
        CallByValueReferenceDemo demo = new CallByValueReferenceDemo();

        Rectangle r0 = new Rectangle();
        r0.length = 10; // Object::reference type
        demo.modify( r0 );

        System.out.println( "call by reference : " + r0.length );

    }

    void modify ( Rectangle r1 )
    {
        r1.length = 20; // If we change here the whole area it will be impacted meas o/p 20 in all areas
        // System.out.println( "Inside modify() length: " + r1.length );
    }
}

class Rectangle
{
    int length;

    public Rectangle ()
    {
    }
}
