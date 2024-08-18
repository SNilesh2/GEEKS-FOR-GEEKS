//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair
{
    int row;
    int col;
    int step;
    public Pair(int _row,int _col,int _step)
    {
        this.row=_row;
        this.col=_col;
        this.step=_step;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
         int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) 
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int s=curr.step;
            res[r][c]=s;
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int adjrow=r+drow[i];
                int adjcol=c+dcol[i];
                if(adjrow>=0 && adjrow<m && adjcol>=0 && adjcol<n && vis[adjrow][adjcol]==0 )
                {
                    q.add(new Pair(adjrow,adjcol,s+1));
                    vis[adjrow][adjcol]=1;
                }
            }
        }
        return res;
    }
}