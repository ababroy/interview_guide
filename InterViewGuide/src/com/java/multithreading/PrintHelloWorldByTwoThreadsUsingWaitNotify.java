package com.java.multithreading;

public class PrintHelloWorldByTwoThreadsUsingWaitNotify
{

    public static void main ( String[] args )
    {
        PrintJob job = new PrintJob( 1, 10 );

        Thread t1 = new Thread(new PrintHello( job ), "hello-thread");
        t1.start();

        Thread t2 = new Thread( new PrintWorld( job ), "world-thread" );
        t2.start();

    }

}

class PrintHello
    implements Runnable
{
    private PrintJob job;

    PrintHello ( PrintJob job )
    {
        this.job = job;
    }

    public void run ()
    {
        job.printHello();
    }
}

class PrintWorld
    implements Runnable
{
    PrintJob job;

    PrintWorld ( PrintJob job )
    {
        this.job = job;
    }

    public void run ()
    {
        job.printWorld();
    }
}

class PrintJob
{
    int start;

    int max;

    private final Object lock = new Object();

    PrintJob ( int start, int max )
    {
        this.start = start;
        this.max = max;
    }

    void printHello ()
    {
        synchronized ( lock )
        {
            while ( start <= max )
            {
                if ( start % 2 != 0 )
                {
                    System.out.println( Thread.currentThread().getName() +" Hello " );
                    start++;
                    lock.notify();
                }
                else
                {
                    try
                    {
                        lock.wait();
                    }
                    catch ( InterruptedException ie )
                    {
                        ie.printStackTrace();
                    }
                }
            }
        }
    }

    void printWorld ()
    {
        synchronized ( lock )
        {
            while ( start <= max )
            {
                if ( start % 2 == 0 )
                {
                    System.out.println( Thread.currentThread().getName() +" World " );
                    start++;
                    lock.notify();
                }
                else
                {
                    try
                    {
                        lock.wait();
                    }
                    catch ( InterruptedException e )
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
