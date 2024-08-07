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
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int[][][] dp=new int[n][m][m];
        for(int[][] matrix:dp)
        {
            for(int[] row:matrix)
            {
                Arrays.fill(row,Integer.MIN_VALUE);
            }
        }
        return fun(0,0,m-1,grid,m,n,dp);
    }
    public static int fun(int i,int j1,int j2,int[][] grid,int m,int n,int[][][] dp)
    {
        if(j1<0 || j1>=m || j2<0 || j2>=m) return Integer.MIN_VALUE;
        if(i==n-1)
        {
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=Integer.MIN_VALUE) return dp[i][j1][j2];
        int maxi=0;
        int res=Integer.MIN_VALUE;
        for(int k=-1;k<2;k++)
        {
            for(int l=-1;l<2;l++)
            {
                if(j1==j2) maxi=grid[i][j1]+fun(i+1,j1+k,j2+l,grid,m,n,dp);
                else  maxi=grid[i][j1]+grid[i][j2]+fun(i+1,j1+k,j2+l,grid,m,n,dp);
                res=Math.max(res,maxi);
            }
        }
        return dp[i][j1][j2]=res;
    }
}