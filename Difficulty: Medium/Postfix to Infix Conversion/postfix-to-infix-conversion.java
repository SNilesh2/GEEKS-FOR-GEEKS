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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i)>='A' && exp.charAt(i)<='Z' || exp.charAt(i)>='a' && exp.charAt(i)<='z' || exp.charAt(i)>='0' && exp.charAt(i)<='9')
            {
                st.push(Character.toString(exp.charAt(i)));
            }
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                String converted='('+ s2 + exp.charAt(i) + s1 + ')';
                st.push(converted);
            }
        }
        return st.peek();
    }
}
