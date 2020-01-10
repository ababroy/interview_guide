package com.java.object.test;

import com.java.object.CustmizedException;

public class CustomizedExceptionTest
{
    public static void main ( String[] args )
    {

        STT stt = new STT();
        try
        {
            stt.setVersion( 15 );
        }
        catch ( CustmizedException e )
        {
            e.printStackTrace();
        }

    }

}

class STT
{
    int version;

    public void setVersion ( int ver ) throws CustmizedException
    {
        if ( version <= 19 )
        {
            throw new CustmizedException( "STT version start with 19 and above" );
        }
        this.version = ver;

    }

    public String toString ()
    {
        return version + "";
    }
}
