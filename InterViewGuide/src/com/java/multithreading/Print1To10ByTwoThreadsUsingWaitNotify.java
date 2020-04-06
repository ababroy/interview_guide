package com.java.multithreading;

public class Print1To10ByTwoThreadsUsingWaitNotify
{
    public static void main ( String[] args )
    {
        Task task = new Task( 1, 10 );

        Thread t1 = new Thread( new PrintEven( task ), "Even-Thread" );
        t1.start();
        Thread t2 = new Thread( new PrintOdd( task ), "Odd-Thread" );
        t2.start();
    }
}

class Task
{
    int start;

    int max;

    private final Object lock = new Object();

    Task ( int start, int max )
    {
        this.start = start;
        this.max = max;
    }

    void printEven ()
    {
        synchronized ( lock )
        {
            while ( start <= max )
            {
                if ( start % 2 == 0 )
                {
                    System.out.println( Thread.currentThread().getName() + " = " + start );
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

    void printOdd ()
    {
        synchronized ( lock )
        {
            while ( start <= max )
            {
                if ( start % 2 != 0 )
                {
                    System.out.println( Thread.currentThread().getName() + " = " + start );
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

}

class PrintOdd
    implements Runnable
{
    Task task;

    PrintOdd ( Task task )
    {
        this.task = task;
    }

    public void run ()
    {
        task.printOdd();
    }
}

class PrintEven
    implements Runnable
{
    Task task;

    PrintEven ( Task task )
    {
        this.task = task;
    }

    public void run ()
    {
        task.printEven();
    }
}
