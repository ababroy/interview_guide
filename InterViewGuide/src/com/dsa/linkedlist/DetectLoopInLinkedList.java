package com.dsa.linkedlist;

public class DetectLoopInLinkedList
{
    
    public static void removeTheLoop(Node head)
    {
        //Your code here
        if(head != null)
        {
            Node start = head;
            Node detectedNode = detectLoop(head);
            Node preDetectedNode = null;
            if( detectedNode != null)
            {
                while( start != detectedNode)
                {
                    preDetectedNode = detectedNode;
                    start=start.next;
                    detectedNode = detectedNode.next;
                    if(start == detectedNode)
                    {
                        preDetectedNode.next = null;
                    }
                }
            }
        }
    }
    
    public static Node detectLoop(Node head)
    {
        Node slow = head, fast = head;
        while( slow!= null && fast!=null&&fast.next!=null)
        {
            fast = fast.next.next;
            slow=slow.next;
            if( fast == slow)
            {
                return fast;
            }
        }
        return null;
    }
    
//    public static int detectLoop ( Node head )
//    {
//        // Add code here
//        if ( head != null )
//        {
//            if ( head.next == null )
//                return -1;
//            Node start = head;
//            Node slow = head, fast = head;
//            while ( slow != null && fast != null && fast.next != null )
//            {
//                slow = slow.next;
//                fast = fast.next.next;
//                if ( slow == fast )
//                {
//                    return startLoopNode(start, slow);
//                }
//            }
//            return 0;
//        }
//        return 0;
//
//    }
//    
//    public static int startLoopNode(Node start, Node loopNode )
//    {
//        Node orig = start;
//        while( start != loopNode)
//        {
//            start = start.next;
//            loopNode = loopNode.next;
//            if( start.data == loopNode.data)
//            {
//                loopNode.next = null; // remove loop
//                detectLoop(orig);
//                return loopNode.data;
//            }
//        }
//        return 0;
//    }
}
