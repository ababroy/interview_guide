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
        
        // Immutability check
        
        System.out.println( im1 == im2 );
        System.out.println( im1 == im3 ); // Immutable
        
        
    }
}
