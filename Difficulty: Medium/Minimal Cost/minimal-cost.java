//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int N, int K) {
        // code here
        int[] dp=new int[N];
        Arrays.fill(dp,-1);
        return fun(N,arr,dp,K);
    }
    public static int fun(int n,int[] arr,int[] dp,int k)
    {
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            int minjumps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    int jumps=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    minjumps=Math.min(minjumps,jumps);
                }
            }
            dp[i]=minjumps;
        }
        return dp[n-1];
    }
}
