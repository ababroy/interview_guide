package com.java.oops.association.composition;

public class CompositionTest
{
    @SuppressWarnings ( "unused" )
    public static void main ( String[] args )
    {
        Car car = new Car();

        car.setCarName( "Ford EcoSport" );
        car.getEngine().setEngineName( "Ford" );
        car.getEngine().setEnginePower( "200 BHP" );
        System.out.println( car );
        System.out.println( car.getEngine());
        car = null;
        System.out.println( car );
        if(car != null)
        {
            System.out.println( car.getEngine());
        }
        else
        {
            System.out.println( "Engine does not exist" );
        }
    }
}
