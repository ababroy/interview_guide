package com.java.collection.test;

import java.util.List;

import com.java.collection.ArrayListNoDuplicateData;

public class ArrayListNoDuplicateTest
{
    public static void main ( String[] args )
    {
        List< Integer > list = new ArrayListNoDuplicateData<>(false);
        list.add( 1 );
        list.add( 2 );
        list.add( 1 );
        list.add( 3 );

        System.out.println( list );

    }

}
