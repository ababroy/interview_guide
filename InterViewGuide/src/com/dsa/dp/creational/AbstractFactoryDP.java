package com.dsa.dp.creational;

public class AbstractFactoryDP
{
    public static void main ( String[] args )
    {
        
    }
}

interface ScreenFactory
{
    void background();
    void text();
}
class DarkScreenFactory implements ScreenFactory
{
    public void background()
    {
        System.out.println( "BLACK background 4 Dark Screen" );
    }
    
    public void text()
    {
        System.out.println( "WHITE text 4 Dark Screen" );
    }
}
class LightScreenFactory implements ScreenFactory
{
    public void background()
    {
        System.out.println( "WHITE background 4 Light Screen" );
    }
    
    public void text()
    {
        System.out.println( "BLACK text 4 Light Screen" );
    }
}

