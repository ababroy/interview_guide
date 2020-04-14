package com.dsa.design_pattern;

public class DecoratorDP
{
    public static void main ( String[] args )
    {
        TennisCourt tCourt = new SoftTennisCourt();
        tCourt = new TennisRacket( tCourt );
        tCourt = new TennisBall( tCourt );
        tCourt = new TennisCoach( tCourt );

        System.out.println( "Total Cost: " + tCourt.cost() );

    }
}

interface TennisCourt
{
    double cost ();
}

class HardTennisCourt
    implements TennisCourt
{
    @Override
    public double cost ()
    {
        return 200;
    }
}

class SoftTennisCourt
    implements TennisCourt
{
    @Override
    public double cost ()
    {
        return 300;
    }

}

abstract class TennisCourtDecorator
    implements TennisCourt
{
    public void info ()
    {
        System.out.println( "Welcome to the Roy Tennis Court!" );
    }

}

class TennisRacket
    extends TennisCourtDecorator
{
    TennisCourt tc;

    TennisRacket ( TennisCourt tc )
    {
        this.tc = tc;
    }

    @Override
    public double cost ()
    {
        return 80 + tc.cost();
    }

}

class TennisBall
    extends TennisCourtDecorator
{
    TennisCourt tc;

    TennisBall ( TennisCourt tc )
    {
        this.tc = tc;
    }

    @Override
    public double cost ()
    {
        return 50 + tc.cost();
    }

}

class TennisCoach
    extends TennisCourtDecorator
{
    TennisCourt tc;

    TennisCoach ( TennisCourt tc )
    {
        this.tc = tc;
    }

    @Override
    public double cost ()
    {
        return 150 + tc.cost();
    }

}
