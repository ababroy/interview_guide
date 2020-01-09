package com.java.object;

/**
 * make class as final
 * 
 * make all variable as private and final
 * 
 * create a constructor to initialize the variables since all are final
 * 
 * No setter method only getter method
 * 
 * @author royabhix
 *
 */
public final class ImmutableObject
{
    private final int id;

    public ImmutableObject ( int id )
    {
        super();
        this.id = id;
    }

    public int getId ()
    {
        return id;
    }

    public ImmutableObject update ( int id )
    {
        if ( this.id == id )
        {
            return this;
        }
        else
        {
            return new ImmutableObject( id );
        }
    }
}
