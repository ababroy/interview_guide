package com.java.basics;

public class CallByValuePrimitiveDemo
{
    public static void main ( String[] args )
    {
        CallByValuePrimitiveDemo demo = new CallByValuePrimitiveDemo();
        int x = 10; // primitive type
        
        demo.modify(x);
        
        System.out.println( "call by value: "+x );

    }

    void modify(int data)
    {
        data = 20;
        //System.out.println( "modify() value: "+data );
    }
}

/**
 * Inside stack memory area,  
 * 
 * int x =10 will store
 * 
 * int data = 10 stored
 * 
 * data = 20 // data changed by modify(x)
 * 
 * but if you print the value of x, still you will be getting same value 10 (due to  call by value)
*/