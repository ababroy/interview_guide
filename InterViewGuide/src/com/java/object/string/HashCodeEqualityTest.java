package com.java.object.string;

import org.junit.Test;

public class HashCodeEqualityTest
{
    @Test
    public void test ()
    {
        Indian i1 = new Indian( 1, "Abhijit", 32 );
        Indian i2 = new Indian( 1, "Roy", 32 );
        Indian i3 = new Indian( 2, "Som", 27 );

        System.out.println( "equality: " + ( i2.equals( i1 ) ) );
        System.out.println( "HashCode " + ( i1.hashCode() == i2.hashCode() ) );
        
    }
}
