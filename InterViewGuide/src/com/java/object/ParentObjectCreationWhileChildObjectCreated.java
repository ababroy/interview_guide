package com.java.object;

public class ParentObjectCreationWhileChildObjectCreated
{
    public static void main ( String[] args )
    {
        Child child = new Child( "Abhijit" );
        System.out.println( "Child HashCode: " + child.hashCode() );
    }
}

class Parent
{
    Parent ()
    {
        System.out.println( "No arg parect constructor" );
    }

    Parent ( String str )
    {
        System.out.println( "Inside Parent Constructor: " + this.hashCode() );
    }
}

class Child
    extends Parent
{

    public Child ( String str )
    {
        System.out.println( "Inside Child Constructor: " + this.hashCode() );
    }
}
