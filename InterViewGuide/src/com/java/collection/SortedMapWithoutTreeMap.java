package com.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author AROY
 *
 */
public class SortedMapWithoutTreeMap
{
    public static void main ( String[] args )
    {
        Map< String, Integer > unsortedMap = new HashMap<>();
        unsortedMap.put( "Duck", 10 );
        unsortedMap.put( "Cat", 4 );
        unsortedMap.put( "Ass", 1 );
        unsortedMap.put( "Elephant", 78 );
        unsortedMap.put( "Bull", 3 );
        System.out.println( unsortedMap );
        setUnsortedMap( unsortedMap );
    }

    private static void setUnsortedMap ( Map< String, Integer > unsortedMap )
    {

        ArrayList< String > list = new ArrayList<>();
        list.addAll( unsortedMap.keySet() );
        printMap(unsortedMap);
        Collections.sort( list, new Comparator< String >()
        {

            @Override
            public int compare ( String o1, String o2 )
            {
                return o1.compareTo( o2 );
            }
        } );

        Map< String, Integer > sortedMap = new LinkedHashMap<>();
        for ( String key : list )
        {
            sortedMap.put( key, unsortedMap.get( key ) );
        }
        printMap(sortedMap);
    }

    private static void printMap ( Map< String, Integer > map )
    {
        Iterator< String > itr = map.keySet().iterator();// list.iterator();

        while ( itr.hasNext() )
        {
            System.out.print( itr.next() +" ");
        }
        System.out.println(  );
        System.out.println( "***************************" );
    }
}
