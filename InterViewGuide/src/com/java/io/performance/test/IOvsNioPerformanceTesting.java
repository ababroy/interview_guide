package com.java.io.performance.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOvsNioPerformanceTesting
{
    File readFile;

    File writeFile;

    IOvsNioPerformanceTesting ( File readFile, File writeFile )
    {
        this.readFile = readFile;
        this.writeFile = writeFile;
    }

    private long startTime;

    public static void main ( String[] args )
    {
        File rFile = new File("C:\\Users\\AROY\\eclipse-workspace\\JavaIO\\sources\\DummyText.txt");
        File wFile = new File("C:\\Users\\AROY\\eclipse-workspace\\JavaIO\\sources\\Write.txt");
        IOvsNioPerformanceTesting obj = new IOvsNioPerformanceTesting(rFile, wFile);
        
         System.out.println( "copyViaStreamBasedApi: too long");//+obj.copyViaStreamBasedApi());
         System.out.println( "copyViaReaderWriter: too long"); //+obj.copyViaReaderWriter());
         System.out.println( "copyViaBufferedReaderPrintWriter: "+obj.copyViaBufferedReaderPrintWriter());
         System.out.println( "copyViaBufferedReaderPrintWriterUsingCharBuffer: "+obj.copyViaBufferedReaderPrintWriterUsingCharBuffer());
         System.out.println( "copyViaBufferedReaderPrintStreamUsingByteBuffer: "+obj.copyViaBufferedReaderPrintStreamUsingByteBuffer());
        
        System.out.println( "copyViaFileChannelUsingDirectByteBuffer: "+obj.copyViaFileChannelUsingDirectByteBuffer());
        System.out.println( "copyViaFileChannelUsingIndirectByteBuffer: "+obj.copyViaFileChannelUsingIndirectByteBuffer());
        System.out.println( "copyViaTransferChannelToChannelWithoutBuffer: "+obj.copyViaTransferChannelToChannelWithoutBuffer());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // NIO
    /**
     * Using Indirect Buffer via NIO (FIS, FOS, FileChannel, ByteBuffer)
     * 
     */
    public long copyViaFileChannelUsingIndirectByteBuffer()
    {
        startTimer();
        
        try(
            FileInputStream fis = new FileInputStream( readFile );
            FileOutputStream fos = new FileOutputStream( writeFile );
            )
        {
            FileChannel readChannel = fis.getChannel();
            FileChannel writeChannel = fos.getChannel();
            int c = 0;
            ByteBuffer byteBuffer = ByteBuffer.allocate( 8192 ); // indirect allocate same as BufferedReader default (2 * 4096 char) = 8192 bytes
            
            while ( ( c = readChannel.read( byteBuffer ) ) != -1 )
            {
                byteBuffer.flip(); // prepare for writing ito the buffer
                writeChannel.write( byteBuffer );
                byteBuffer.clear(); // empty the buffer
            }
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        return stopTimer();
    }
    
    /**
     * Using direct Buffer via NIO (FIS, FOS, FileChannel, ByteBuffer)
     * 
     */
    public long copyViaFileChannelUsingDirectByteBuffer()
    {
        
        startTimer();
        try(
            FileInputStream fis = new FileInputStream( readFile );
            FileOutputStream fos = new FileOutputStream( writeFile )
            )
        {
            FileChannel readChannel = fis.getChannel();
            FileChannel writeChannel = fos.getChannel();
            
            int c = 0;
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect( 8192 ); // Direct Byte Buffer allocationHi
            while( (c = readChannel.read(byteBuffer)) != -1)
            {
                byteBuffer.flip(); // prepare for writing into the ByteBuffer
                writeChannel.write( byteBuffer );
                byteBuffer.clear(); // Empty the buffer
            }
            
        }
        catch (IOException e) {
        }
        
        return stopTimer();
    }
    
    /**
     * NIO - Transfer channel to channel without buffers
     * 
     */
    
    public long copyViaTransferChannelToChannelWithoutBuffer()
    {
        startTimer();
        
        try(
            FileInputStream fis = new FileInputStream( readFile );
            FileOutputStream fos = new FileOutputStream( writeFile );
            )
        {
            FileChannel readChannel = fis.getChannel();
            FileChannel writeChannel = fos.getChannel();

            readChannel.transferTo( 0, readChannel.size(), writeChannel );
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        return stopTimer();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IO
    /**
     * Using Byte/stream based API - BufferedInputStream/PrintStream API 
     * 
     * Read via customized byte[] buffer 
     */
    
    public long copyViaBufferedReaderPrintStreamUsingByteBuffer()
    {
        startTimer();
        
        try(
            BufferedInputStream bis = new BufferedInputStream( new FileInputStream( readFile ) );
            PrintStream ps = new PrintStream( new BufferedOutputStream( new FileOutputStream( writeFile ) ) );
            // PrintStream ps = new PrintStream(writeFile);
            )
        {
            byte[] byteBuffer = new byte[ 8192 ];

            while ( bis.read( byteBuffer, 0, byteBuffer.length ) != -1 )
            {
                ps.write( byteBuffer, 0, byteBuffer.length );
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        return stopTimer();
    }
    
    /**
     * Using String(line) based API - BufferedReader/ PrintWriter API (String) but using character buffer
     * 
     */
    public long copyViaBufferedReaderPrintWriterUsingCharBuffer()
    {
        startTimer();
        
        try(
            BufferedReader br = new BufferedReader( new FileReader( readFile ) );
            PrintWriter pw = new PrintWriter( new BufferedWriter(new FileWriter(writeFile)) );
//            PrintWriter pw = new PrintWriter( writeFile );
            )
        {
            char[] chBuffer = new char[4096]; // means 1 char = 2 bytes, 4096*2 = 8192 bytes (which is default size of BufferReader)
            while( br.read( chBuffer, 0, chBuffer.length ) != -1)
            {
                pw.write( chBuffer, 0, chBuffer.length );
            }   
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return stopTimer();
    }
    
    /**
     * Using String(line) based API - BufferedReader/ PrintWriter API (String)
     * 
     */
    public long copyViaBufferedReaderPrintWriter()
    {
        startTimer();
        
        try(
            BufferedReader br = new BufferedReader( new FileReader( readFile ) );
            PrintWriter pw = new PrintWriter( new BufferedWriter(new FileWriter(writeFile)) );
            //PrintWriter pw = new PrintWriter( writeFile );
            )
        {
           String line = null;
            while ( ( line = br.readLine() ) != null )
            {
                pw.println( line );
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return stopTimer();
    }
    
    /**
     * Using Character based API - Reader/Writer API (char by char )
     * 
     */
    public long copyViaReaderWriter()
    {
        startTimer();
        
        try(
                FileReader fr = new FileReader(readFile);
                FileWriter fw = new FileWriter(writeFile);
            )
        {
            int c = 0;
            while( ( c = fr.read()) != -1)
            {
                fw.write( c );
            }
        }
        catch ( IOException ex )
        {
            ex.printStackTrace();
        }
        
        return stopTimer();
    }
    

    /**
     * Using Byte(Stream) based API - FileInputStream/FileOutputStream (byte by byte streaming)
     * 
     * @return
     */
    public long copyViaStreamBasedApi ()
    {
        startTimer();

        try ( 
                FileInputStream fis = new FileInputStream( readFile );
                FileOutputStream fos = new FileOutputStream( writeFile)
            )
        {
            int c = 0;
            while ( ( c = fis.read() ) != -1 )
            {
                fos.write( c );
            }
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        return stopTimer();
    }

    public void startTimer ()
    {
        startTime = System.currentTimeMillis();
    }

    public long stopTimer ()
    {
        long time = System.currentTimeMillis() - startTime;
        startTime = 0L;
        return time;

    }

}
