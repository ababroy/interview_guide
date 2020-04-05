package com.java.object.string;

import org.junit.Test;

public class HashCodeEqualityTest
{
    @Test
    public void test ()
    {
        Person p1 = new Person( "abhijit", 30, 100 );
        Person p2 = new Person( "abhijit", 30, 101 );

        // To check the contrast whether two equivalent objects are having the same hashcode or not
        System.out.println( p1.equals( p2 ) );
        // here if I'm not override the hashCode method with same parameter as equals used, the contrast will break
        System.out.println( p1.hashCode() == p2.hashCode() );

    }
}

class Person
{
    private String name;

    private int age;

    private int id;

    public Person ( String name, int age, int id )
    {
        super();
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals ( Object obj )
    {
        if ( obj == null )
        {
            return false;
        }
        if ( obj instanceof Person )
        {
            Person p = ( Person ) obj;
            if ( name.equals( p.name ) && age == p.age )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode ()
    {
        return name.hashCode() + age;
    }

}
