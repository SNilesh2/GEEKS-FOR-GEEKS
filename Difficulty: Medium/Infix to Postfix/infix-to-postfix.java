//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        String res="";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                res=res+s.charAt(i);
            }
            else if(s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                while(st.peek()!='(')
                {
                    res=res + st.pop();
                }
                st.pop();
            }
            else
            {
                if(st.isEmpty())
                {
                    st.push(s.charAt(i));
                }
                else
                {
                    while(priority(s.charAt(i)) <= priority(st.peek()))
                    {
                        res=res+st.pop();
                        if(st.isEmpty())
                        {
                            break;
                        }
                    }
                    st.push(s.charAt(i));
                }
            }
        }
        while(!st.isEmpty())
        {
            res=res+st.pop();
        }
        return res;
    }
    public static int priority(char op)
    {
        if(op=='^')
        {
            return 3;
        }
        else if(op=='*' || op=='/')
        {
            return 2;
        }
        else if(op=='+' || op=='-')
        {
            return 1;
        }
        return -1;
    }
}