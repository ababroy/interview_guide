package com.java.object;

/**
 * 
 * Interface VS Abstract Class
 * 
 * 1. Inside Interface every variable is always <b>public static final</b>, we can't <b>instance</b> variable
 * 
 * 2. Interface never talks about <b>state of object</b>
 * 
 * 3. Inside interface we can't declare <b>constructor</b>
 * 
 * 4. Inside interface we can't declare instance or static blocks
 * 
 * 5. Functional Interface with default method can refer Lambda Expression
 * 
 * 6. Inside interface we can't override object class method
 * 
 */
public class AbstractVsInterface
    implements FuntionalInterface, FI2
{

    public static void main ( String[] args )
    {
        AbstractVsInterface fi = new AbstractVsInterface();
        fi.defaultMethod();
        FuntionalInterface.staticMethod();
        fi.sam();
    }

    @Override
    public void sam ()
    {
        System.out.println( "I'm SAM " );
    }

    @Override
    public void defaultMethod ()
    {
        FI2.super.defaultMethod();
    }

}

@FunctionalInterface
interface FuntionalInterface
{
    /* SAM(Single Abstract Method) */
    void sam ();

    /* Default method - just to provide a dummy default implementation */
    default void defaultMethod ()
    {
        System.out.println( "Default implementation for Functinal Interface" );
    }

    /**
     * static method
     * 
     * - Just to define general utility method
     * 
     * - Interface static method can't be overridden
     * 
     * - Child class can have same signature method, can reduce scope of access modifier, can be non static - BECAUSE it's not the overridden method
     * 
     */

    static void staticMethod ()
    {
        System.out.println( "Static method for Functional Interface" );
    }
}

/**
 * Just to create multiple inheritance problem
 * 
 */
@FunctionalInterface
interface FI2
{
    void sam ();

    default void defaultMethod ()
    {
        System.out.println( "FI2 Default implementation for Functinal Interface" );
    }

    static void staticMethod ()
    {
        System.out.println( "FI2 Static method for Functional Interface" );
    }
}
