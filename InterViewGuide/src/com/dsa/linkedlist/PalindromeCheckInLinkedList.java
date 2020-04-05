package com.dsa.linkedlist;

import java.util.Stack;

public final class PalindromeCheckInLinkedList
{

    /**
     * Splitting LL into two and compare
     */
    public static boolean isPalindromeLL ( Node head )
    {
        boolean isPalindrome = false;
        if ( head != null )
        {
            if( head.next == null) return isPalindrome;
            Node firstLL = head;
            Node secondLL = null;
            Node current = head;
            Node fast = head;
            while (true)
            {
                fast = fast.next.next;
                if( fast == null )
                {
                    secondLL = current.next;
                    break;
                }
                if( fast.next == null)
                {
                    secondLL = current.next;
                    break;
                }
                current = current.next;
            }
            
            secondLL = reverseLL(secondLL);
            isPalindrome = compareLL( firstLL, secondLL);
            
            return isPalindrome;
        }
        else
        return isPalindrome;
    }

    private static boolean compareLL ( Node firstLL, Node secondLL )
    {
        if( firstLL != null && secondLL != null )
        {
            while( secondLL != null)
            {
                if(firstLL.data == secondLL.data)
                {
                    firstLL = firstLL.next;
                    secondLL = secondLL.next;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Node reverseLL ( Node head )
    {
        if(head != null)
        {
            Node prev = null;
            Node temp = head;
            Node current = head;
            
            while( current != null )
            {
               temp = current.next;
               current.next = prev;
               prev = current;
               current = temp;
            }
            
            return prev;
        }
        return null;
    }

    /**
     * Using Stack
     * 
     * @param head
     * @return
     */
    public static boolean isPalindrome ( Node head )
    {
        // Your code here
        Stack< Integer > stack = new Stack<>();
        if ( head != null )
        {
            Node current = head;
            Node prev = null;
            Node temp = head;
            int count = 0;
            while ( current != null )
            {
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count++;
            }

            int stop = 0;
            while ( stop < count / 2 )
            {
                stack.push( prev.data );
                prev = prev.next;
                stop++;
            }
            if ( count % 2 != 0 )
            {
                prev = prev.next;
                ; // basic check
            }
            while ( prev != null && !stack.isEmpty() )
            {
                int pop = stack.pop();
                if ( prev.data == pop )
                {
                    prev = prev.next;
                }
                else
                {
                    return false;
                }
            }

            return true;
        }
        else
            return false;
    }
}
