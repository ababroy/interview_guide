package com.java.oops.association.composition;

public class Engine
{
    private String engineName;

    private String enginePower;

    public String getEngineName ()
    {
        return engineName;
    }

    public void setEngineName ( String engineName )
    {
        this.engineName = engineName;
    }

    public String getEnginePower ()
    {
        return enginePower;
    }

    public void setEnginePower ( String enginePower )
    {
        this.enginePower = enginePower;
    }

    @Override
    public String toString ()
    {
        return "Engine [engineName=" + engineName + ", enginePower=" + enginePower + "]";
    }

}
