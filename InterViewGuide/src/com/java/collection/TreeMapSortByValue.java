package com.java.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapSortByValue
{

    static SortedSet entriesSortedByValues ( Map map )
    {
        SortedSet sortedEntries = new TreeSet( new Comparator()
        {
            @Override
            public int compare ( Object o1, Object o2 )
            {
                Map.Entry< String, Integer > e1 = ( Map.Entry< String, Integer > ) o1;
                Map.Entry< String, Integer > e2 = ( Map.Entry< String, Integer > ) o2;

                Integer val1 = e1.getValue();
                Integer val2 = e2.getValue();
                 int result = val1.compareTo( val2 );
                 return result != 0 ? result : 1;
                //return val1.compareTo( val2 );
            }
        } );
        sortedEntries.addAll( map.entrySet() );
        return sortedEntries;
    }

    static Map< Integer, String > map;

    public static void main ( String[] args )
    {
        Map< String, Integer > map = new TreeMap< String, Integer >();
        map.put( "A", 3 );
        map.put( "B", 2 );
        map.put( "C", 3 );

        System.out.println( map );
        // prints "{A=3, B=2, C=1}"
        System.out.println( entriesSortedByValues( map ) );
        // prints "[C=1, B=2, A=3]"
    }

}

/**
 * static < K, V extends Comparable< ? super V > > SortedSet< Map.Entry< K, V > > entriesSortedByValues ( Map< K, V > map ) { SortedSet< Map.Entry< K, V > > sortedEntries = new
 * TreeSet< Map.Entry< K, V > >( new Comparator< Map.Entry< K, V > >() {
 * 
 * @Override public int compare ( Map.Entry< K, V > e1, Map.Entry< K, V > e2 ) { int res = e1.getValue().compareTo( e2.getValue() ); return res != 0 ? res : 1; } } );
 *           sortedEntries.addAll( map.entrySet() ); return sortedEntries; }
 */
