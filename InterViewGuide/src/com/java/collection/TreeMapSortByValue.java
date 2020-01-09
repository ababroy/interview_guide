package com.java.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapSortByValue
{
    static Map< Integer, String > map = new TreeMap<>( new MyComparator() );

    public static void main ( String[] args )
    {
        map.put( 1, "c" );
        map.put( 3, "z" );
        map.put( 5, "a" );
        map.put( 2, "f" );
        map.put( 4, "b" );

        System.out.println( map );
        Iterator< Entry< Integer, String > > itr = map.entrySet().iterator();

        while ( itr.hasNext() )
        {
            System.out.println( itr.next() );
        }
    }

}

class MyComparator
    implements Comparator< Object >
{
    public int compare ( Object o1, Object o2 )
    {
        String i1 = o1.toString();
        String i2 = o2.toString();

        Map< Integer, String > m1 = new HashMap<>();
        if ( m1.containsKey( o1 ) )
        {
            String val1 = m1.get( o1 );
            String val2 = m1.get( o2 );

            return val1.compareTo( val2 );
        }
        else
        {
            return - i2.compareTo( i1 );
        }

    }
}
