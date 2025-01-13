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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--)
        {
            if(pre_exp.charAt(i)>='A' && pre_exp.charAt(i)<='Z' || pre_exp.charAt(i)>='a' && pre_exp.charAt(i)<='z' || pre_exp.charAt(i)>='0' && pre_exp.charAt(i)<='9')
            {
                st.push(Character.toString(pre_exp.charAt(i)));
            }
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                String converted=s1+s2+pre_exp.charAt(i);
                st.push(converted);
            }
        }
        return st.peek();
    }
}
