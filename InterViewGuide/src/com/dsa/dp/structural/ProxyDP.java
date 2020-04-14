package com.dsa.design_pattern;

import com.java.utility.JavaUtility;

public class ProxyDP
{
    public static void main ( String[] args )
    {
        JavaUtility.startTimer();
        IBookParser parser = new BookParserProxy( "Book" );
        System.out.println( "Number of the pages : " + parser.getNumberOfPages() );
        System.out.println( JavaUtility.stopTimer());
        
        JavaUtility.startTimer();
        IBookParser parser2 = parser; //new BookParserProxy( "Book2" );
        System.out.println( "Number of the pages : " + parser2.getNumberOfPages() );
        System.out.println( JavaUtility.stopTimer());
    }
}

interface IBookParser
{
    public int getNumberOfPages ();
}

class BookParser
    implements IBookParser
{
    int noOfPages;

    BookParser ( String book )
    {
        // Expensive execution/task
        for ( int i = 0; i <= 1000000000; i++ )
        {
            noOfPages = i;
        }
        try
        {
            Thread.sleep( 3000 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfPages ()
    {
        return noOfPages;
    }
}

class BookParserProxy
    implements IBookParser
{
    private String book = null;

    private BookParser parser = null;

    BookParserProxy ( String Book )
    {
        this.book = Book;
    }

    @Override
    public int getNumberOfPages ()
    {
        if ( this.parser == null )
        {
            this.parser = new BookParser( this.book );
        }
        return this.parser.getNumberOfPages();
    }
}
