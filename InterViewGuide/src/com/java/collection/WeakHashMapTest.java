package com.java.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

public class WeakHashMapTest
{
    @Test
    public void test ()
    {
        // Map< Employee, String > map = new HashMap<>();
        Map< Employee, String > map = new WeakHashMap<>();

        map.put( new Employee( 100, "Abhijit" ), "Java Developer" );
        map.put( new Employee( 200, "Shail" ), "C++ Developer" );
        map.put( new Employee( 300, "Faiz" ), "C# Developer" );

        System.out.println( "Before calling gc() on weak hash map size is " + map.size() );
        System.gc();
        System.out.println( "After calling gc() on weak hash map size is " + map.size() );
    }
}

class Employee
{
    int empId;

    String empName;

    public Employee ( int empId, String empName )
    {
        super();
        this.empId = empId;
        this.empName = empName;
    }

}
