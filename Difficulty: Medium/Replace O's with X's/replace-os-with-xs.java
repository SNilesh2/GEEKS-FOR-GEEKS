//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        return solution(a);
    }
    public static char[][] solution(char[][] board)
    {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || i==m-1 || j==0 || j==n-1) && vis[i][j]==0 && board[i][j]=='O')
                {
                    dfs(i,j,board,vis,drow,dcol);
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
        return board;
    }
     public static void dfs(int r,int c,char[][] board,int[][] vis,int[] drow,int[] dcol)
    {
        vis[r][c]=1;
        for(int i=0;i<4;i++)
        {
            int adjrow=r+drow[i];
            int adjcol=c+dcol[i];
            if(adjrow>=0 && adjrow<board.length && adjcol>=0 && adjcol<board[0].length && board[adjrow][adjcol]=='O' && vis[adjrow][adjcol]==0)
            {
                dfs(adjrow,adjcol,board,vis,drow,dcol);
            }
        }
    }
}