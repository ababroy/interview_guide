package com.java.object;

public class CustmizedException
    extends Exception
{
    private static final long serialVersionUID = 1L;

    public CustmizedException ()
    {
        super( "Default customized exception" );
    }

    public CustmizedException ( String msg )
    {
        super( msg );
    }
}
