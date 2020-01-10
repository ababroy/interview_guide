package com.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListNoDuplicateData< E >
    extends ArrayList< E >
{
    private static final long serialVersionUID = -6602929541897334546L;

    boolean isDuplicateAllowed = false;

    public ArrayListNoDuplicateData ( boolean isDuplicateAllowed )
    {
        this.isDuplicateAllowed = isDuplicateAllowed;
    }

    Set< E > set = new HashSet<>();

    public boolean add ( E obj )
    {
        if ( this.isDuplicateAllowed == false && set.add( obj ) == false )
        {
            throw new IllegalArgumentException( "\nHey! you are trying to insert duplicate data which is not allowed in my ArrayList!" );
        }
        else if ( isDuplicateAllowed == true && set.add( obj ) == false )
        {
            super.add( obj );
        }
        return isDuplicateAllowed;
    }
}
