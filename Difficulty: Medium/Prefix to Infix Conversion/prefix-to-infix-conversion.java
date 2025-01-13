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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder(pre_exp);
        String reversed=sb.reverse().toString();
        for(int i=0;i<reversed.length();i++)
        {
            if(reversed.charAt(i)>='A' && reversed.charAt(i)<='Z' || reversed.charAt(i)>='a' && reversed.charAt(i)<='z' || reversed.charAt(i)>='0' && reversed.charAt(i)<='9')
            {
                st.push(Character.toString(reversed.charAt(i)));
            }
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                String converted='(' + s1 + reversed.charAt(i) + s2 + ')';
                st.push(converted);
            }
        }
        return st.peek();
    }
}
