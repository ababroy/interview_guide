package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerUsingWaitNotify
{

    public static void main ( String[] args )
    {
        List< Integer > list = new ArrayList<>();

        Thread pThread = new Thread( new Producer( list ), "producer-thread" );
        pThread.start();

        Thread cThread = new Thread( new Consumer( list ), "consumer-thread" );
        cThread.start();
    }

}

class Producer
    implements Runnable
{
    private final List< Integer > list;

    final int MAX_SIZE = 10;

    int data = 1;

    Producer ( List< Integer > list )
    {
        this.list = list;
    }

    public void run ()
    {
        while ( true )
        {
            produce( data++ );
        }
    }

    private void produce ( int data )
    {
        synchronized ( list )
        {
            while ( list.size() == MAX_SIZE )
            {
                try
                {
                    System.out.println( "Store is full...let consumer to consume..." );
                    list.wait();
                }
                catch ( InterruptedException ie )
                {
                    ie.printStackTrace();
                }
            }
        }

        synchronized ( list )
        {
            System.out.println( Thread.currentThread().getName() + " = " + data );
            list.add( data );
            try
            {
                Thread.sleep( 1000 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            list.notify();
        }
    }
}

class Consumer
    implements Runnable
{
    List< Integer > list;

    Consumer ( List< Integer > list )
    {
        this.list = list;
    }

    public void run ()
    {
        while ( true )
        {
            consume();
        }
    }

    private void consume ()
    {
        synchronized ( list )
        {
            while ( list.isEmpty() )
            {
                System.out.println( "Store is empty...let producer to produce" );
                try
                {
                    list.wait();
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }

            }
        }

        synchronized ( list )
        {
            System.out.println( Thread.currentThread().getName() + " = " + list.remove( 0 ) );
            try
            {
                Thread.sleep( 1000 );
            }
            catch ( InterruptedException ie )
            {
                ie.printStackTrace();
            }
            list.notify();
        }
    }
}

// class Producer
// implements Runnable
// {
// Items items;
//
// Producer ( Items items )
// {
// this.items = items;
// }
//
// @Override
// public void run ()
// {
// while ( true )
// {
// try
// {
// items.producer();
// }
// catch ( InterruptedException e )
// {
// e.printStackTrace();
// }
// }
// }
// }
//
// class Consumer
// implements Runnable
// {
// Items items;
//
// Consumer ( Items items )
// {
// this.items = items;
// }
//
// public void run ()
// {
// while ( true )
// {
// try
// {
// items.consumer();
// }
// catch ( InterruptedException e )
// {
// e.printStackTrace();
// }
// }
// }
// }
//
// class Items
// {
// int maxItem;
//
// private int data = 1;
//
// Items ( int maxItem )
// {
// this.maxItem = maxItem;
// }
//
// Stack< Integer > items = new Stack<>();
//
// public void producer () throws InterruptedException
// {
// synchronized ( items )
// {
// while ( items.size() == maxItem )
// {
// System.out.println( "Store is full... wait for consumer to consume items" );
// items.wait();
// }
// }
//
// synchronized ( items )
// {
// System.out.println( Thread.currentThread().getName() + " = "+ items.push( data++ ) );
// Thread.sleep( 1000 );
// items.notify();
// }
// }
//
// public void consumer () throws InterruptedException
// {
// synchronized ( items )
// {
// while ( items.isEmpty() )
// {
// System.out.println( "Store is empty...Let Producer to produce item" );
// items.wait();
// }
// }
//
// synchronized ( items )
// {
// Thread.sleep( 500 );
// System.out.println( Thread.currentThread().getName() + " = "+items.pop() );
//
// items.notify();
// }
// }}
