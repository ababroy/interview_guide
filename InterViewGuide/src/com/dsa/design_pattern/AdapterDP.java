package com.dsa.design_pattern;

/**
 * Link: Pilot Pen - https://www.youtube.com/watch?v=Y7DYhe6efQY&list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol&index=7 WebDriver - https://www.youtube.com/watch?v=FsS-jWCPtQI
 * 
 * 
 * @author AROY
 *
 */
public class AdapterDP
{
    public static void main ( String[] args )
    {
        // Client
        ITarget target = new Adapter( new Adaptee());
        target.request();
        
    }
}

interface ITarget
{
    public void request ();
}

class Adapter
    implements ITarget
{
    private Adaptee adaptee;

    Adapter ( Adaptee adaptee )
    {
        this.adaptee = adaptee;
    }

    public void request ()
    {
        this.adaptee.specificRequest();
    }
}

class Adaptee
{
    public void specificRequest ()
    {
        System.out.println( "Connected to Adaptee" );
    }
}
