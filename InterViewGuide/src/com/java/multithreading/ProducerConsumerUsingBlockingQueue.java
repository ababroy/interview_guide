package com.java.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue
{
    public static void main ( String[] args )
    {
        BlockingQueue< Integer > queue = new ArrayBlockingQueue<>( 10 );

        Thread pThread = new Thread( new Producers( queue ) );
        pThread.start();

        Thread cThread = new Thread( new Consumers( queue ) );
        cThread.start();
    }

}

class Producers
    implements Runnable
{
    private BlockingQueue< Integer > queue;

    private int data;

    public Producers ( BlockingQueue< Integer > queue )
    {
        super();
        this.queue = queue;
    }

    public void run ()
    {
        while ( true )
        {
            try
            {
                produce( data++ );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }

    public void produce ( int data ) throws InterruptedException
    {
        System.out.println( "Producer stored item:" + data );
        queue.put( data );
        Thread.sleep( 500 );
    }
}

class Consumers
    implements Runnable
{
    private BlockingQueue< Integer > queue;

    public Consumers ( BlockingQueue< Integer > queue )
    {
        super();
        this.queue = queue;
    }

    public void run ()
    {
        while ( true )
        {
            try
            {
                consume();
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }

    private void consume () throws InterruptedException
    {
        System.out.println( "Consumer consumed item: " + queue.take() );
        Thread.sleep( 1000 );
    }
}
