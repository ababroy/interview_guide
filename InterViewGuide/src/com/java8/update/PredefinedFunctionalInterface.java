package com.java8.update;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Input : pincode check-1: number is 6 digit or not?
 * 
 * check-2: first digit start with 5 or not
 * 
 * @author AROY
 *
 */
public class PredefinedFunctionalInterface
{
    public static void main ( String[] args )
    {
        String pinCode = "560035";

        predicateMethod( pinCode );

        functionMethod( pinCode );

        consumerMethod( pinCode );

        int integer = supplierMethod();

        System.out.println( "Supplier: " + integer );
    }

    /**
     * 
     * interface Function <T, R >
     * 
     * {
     * 
     * R apply(T t)
     * 
     * }
     * 
     * Function takes Any type of input and returns any type of output
     * 
     * @param pinCode
     */
    private static void functionMethod ( String pinCode )
    {
        Function< String, Integer > function = ( zipCode ) -> zipCode.length();
        System.out.println( "Function : Pincode length is :" + function.apply( pinCode ) );
    }

    /**
     * interface Predicate <T >
     * 
     * {
     * 
     * boolean test(T t)
     * 
     * }
     * 
     * Predicate takes Any type of input but return boolean output
     * 
     * @param pinCode
     */
    private static void predicateMethod ( String pinCode )
    {
        Predicate< String > predicate = ( zipCode ) -> pinCode.length() == 6;
        Predicate< String > predicate1 = ( zipCode ) -> pinCode.startsWith( "5" );

        Predicate< String > finalPredicate = predicate.or( predicate1 );

        boolean bool = finalPredicate.test( pinCode );

        if ( bool == true )
        {
            System.out.println( "Predicate: It's a Bangalore pin code" );
        }
        else
        {
            System.out.println( "Predicate: It's not a Bangalore pin code" );
        }

    }

    /**
     * interface Consumer <T >
     * 
     * {
     * 
     * void accept(T t)
     * 
     * }
     * 
     * Predicate takes Any type of input but return boolean output
     * 
     * @param pinCode
     */
    private static void consumerMethod ( String pinCode )
    {
        Consumer< String > consumer = ( zipCode ) -> System.out.println( "Consumer : " + zipCode );
        consumer.accept( pinCode );
    }

    /**
     * interface Supplier <R >
     * 
     * {
     * 
     * R get()
     * 
     * }
     * 
     * Predicate takes Any type of input but return boolean output
     * 
     * @param pinCode
     */
    private static int supplierMethod ()
    {
        Supplier< Integer > supplier = () -> ( int ) Math.random() *3 +1;

        return supplier.get();
    }
}
