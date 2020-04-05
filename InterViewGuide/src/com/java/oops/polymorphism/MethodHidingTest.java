package com.java.oops.polymorphism;

/**
 * Link: https://www.youtube.com/watch?v=LW_2HYQx3q8
 * 
 * @author AROY
 *
 */
public class MethodHidingTest
{
    public static void main ( String[] args )
    {
        Parent p = new Parent();
        Child c = new Child();
        
        Parent parent = new Child();
        parent.method(); // Parent method ==> bcz it's a method hiding not overriding

        
    }
    
    
}

class Parent
{
   static void method ()
    {
        System.out.println( "Parent Method" );

    }
}

class Child extends Parent
{
   static void method ()
    {
        System.out.println( "Child Method" );
    }
}