//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> ls=new ArrayList<>();
        long i=1;
        long res=1;
        fact(n,ls,i,res);
        return ls;
    }
    public static void fact(long n,ArrayList<Long> ls,long i,long res)
    {
        res=res*i;
        if(res>n)
        {
            return;
        }
        else
        {
            ls.add(res);
        }
        fact(n,ls,i+1,res);
    }
}