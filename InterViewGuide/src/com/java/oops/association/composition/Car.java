package com.java.oops.association.composition;

public class Car
{
    private String carName;

    private Engine engine;

    public Car ( )
    {
        engine = new Engine();
    }
    
    
    public String getCarName ()
    {
        return carName;
    }


    public void setCarName ( String carName )
    {
        this.carName = carName;
    }

    public Engine getEngine ()
    {
        return engine;
    }


    @Override
    public String toString ()
    {
        return "Car [carName=" + carName + ", engine=" + engine + "]";
    }
    
    

}
