package com.java.object.test;

import org.junit.Test;

import com.java.object.ImmutableObject;

public class ImmutableObjectTest
{
    @Test
    public void test ()
    {
        ImmutableObject im1 = new ImmutableObject(10);
        ImmutableObject im2 = im1.update( 100 );
        ImmutableObject im3 = im1.update(10);
        
        ImmutableObject im4 = new ImmutableObject(10);
        // Immutability check
        
        System.out.println( im1 == im2 );
        System.out.println( im1 == im3 ); // Immutable
        
        System.out.println( "Equality: "+ im1.equals( im4 ) );
        System.out.print( "Hashcode: "+im1.hashCode() +" "+ im4.hashCode() );
        System.out.println( " " + ( im1.hashCode() == im4.hashCode() ) );
        
    }
}
