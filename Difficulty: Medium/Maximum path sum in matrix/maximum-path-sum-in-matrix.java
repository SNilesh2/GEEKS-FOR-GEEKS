//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
         int n=Matrix.length;
        int res=Integer.MIN_VALUE;
        int[][] dp=new int[n][n];
        for(int[] row:dp)
        {
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        for(int j=0;j<n;j++)
        {
            int maxi=fun(n-1,j,Matrix,n,dp);
            res=Math.max(res,maxi);
        }
        return res;
    }
    public static int fun(int i,int j,int[][] matrix,int n,int[][] dp)
    {
        if(j<0 || j>n-1) return Integer.MIN_VALUE;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int up=fun(i-1,j,matrix,n,dp);
        int rightdiag=fun(i-1,j-1,matrix,n,dp);
        int leftdiag=fun(i-1,j+1,matrix,n,dp);
        return dp[i][j]=matrix[i][j]+Math.max(up,Math.max(rightdiag,leftdiag));
    }
}