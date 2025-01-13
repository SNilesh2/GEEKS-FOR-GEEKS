//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=0;i<post_exp.length();i++)
        {
            if(post_exp.charAt(i)>='A' && post_exp.charAt(i)<='Z' || post_exp.charAt(i)>='a' && post_exp.charAt(i)<='z' || post_exp.charAt(i)>='0' && post_exp.charAt(i)<='9')
            {
                st.push(Character.toString(post_exp.charAt(i)));
            }
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                String converted=post_exp.charAt(i) + s2 + s1 ;
                st.push(converted);
            }
        }
        return st.peek();
    }
}
