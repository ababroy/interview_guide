package com.java.object;

public class NewInstance 
{
    public static void main ( String[] args ) throws InstantiationException, IllegalAccessException
    {
        try
        {
            /**
             * newInstance()
             * To use newInstance() runtime class must have the no-arg constructor
             */
//            Object obj = Class.forName( args[0] ).newInstance();
//            
//            System.out.println( "Newly created runtime class name is : "+obj.getClass().getSimpleName() );
            
            
            /**
             * isInstance()
             */
            OperatorAssignment oa = new OperatorAssignment();
            
            System.out.println( Class.forName(args[0]).isInstance( oa ) );
        }
        catch ( ClassNotFoundException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
