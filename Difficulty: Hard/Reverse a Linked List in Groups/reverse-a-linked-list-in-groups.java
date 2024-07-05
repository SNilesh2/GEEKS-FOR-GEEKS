//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node temp=node;
        Node prevNode=null;
        while(temp!=null)
        {
            Node kthNode=kthnode(temp,k);
            if(kthNode==null)
            {
                if(prevNode!=null)
                {
                    Node rev=reverse(temp);
                    prevNode.next=rev;
                }
                break;
            }
            Node nextNode=kthNode.next;
            kthNode.next=null;
            Node rev=reverse(temp);
            if(temp==node)
            {
                node=kthNode;
            }
            else
            {
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return node;
    }
    public static Node kthnode(Node head,int k)
    {
        k--;
        Node temp=head;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public static Node reverse(Node head)
    {
        Node temp=head;
        Node prev=null;
        while(temp!=null)
        {
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}

