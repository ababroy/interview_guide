package com.java.object.string;

/**
 * 
 * @author AROY
 *
 */
public class Indian
{
    long aadharNo;

    String strName;

    int strAge;

    public Indian ( long aadharNo, String strName, int strAge )
    {
        super();
        this.aadharNo = aadharNo;
        this.strName = strName;
        this.strAge = strAge;
    }

    @Override
    public boolean equals ( Object obj )
    {
        Indian ind = ( Indian ) obj;
        if ( ind == null )
        {
            return false;
        }
        else if ( this.aadharNo == ind.aadharNo )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    @Override
    public int hashCode()
    {
        return ( int ) aadharNo;
    }
}
