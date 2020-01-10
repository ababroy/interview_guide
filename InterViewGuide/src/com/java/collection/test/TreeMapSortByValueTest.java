package com.java.collection.test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapSortByValueTest
{

    public static void main ( String[] args )
    {
        Map< String, Integer > map = new TreeMap<>();
        map.put( "A", 3 );
        map.put( "B", 1 );
        map.put( "C", 2 );

        System.out.println( "Before sort by Value: " + map );
        System.out.println( "After sort by value: " + sortByValue( map ) );

    }

    private static Set< Map.Entry< String, Integer > > sortByValue ( Map< String, Integer > map )
    {
        Set< Map.Entry< String, Integer > > set = new TreeSet<>( new Comparator()
        {
            public int compare ( Object o1, Object o2 )
            {
                Map.Entry< String, Integer > e1 = ( Map.Entry< String, Integer > ) o1;
                Map.Entry< String, Integer > e2 = ( Map.Entry< String, Integer > ) o2;

                int result = e1.getValue().compareTo( e2.getValue() );
                if ( result == 0 )
                {
                    return 1;
                }
                else
                {
                    return result;
                }
            }
        } );

        set.addAll( map.entrySet() );

        return set;
    }

}
