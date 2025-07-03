// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis = new int[m][n];
        HashSet<ArrayList<String>> st= new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String> list =new ArrayList<>();
                    dfs(i,j,grid,vis,list,i,j);
                    st.add(list);
                }
            }
        }
        return st.size();
    }
    public static void dfs(int row,int col,int[][] grid,int[][] vis,ArrayList<String> list,int row0,int col0)
    {
        vis[row][col]=1;
        list.add(toString(row-row0,col-col0));
        //System.out.println(list);
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};
        
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<4;i++)
        {
            int newrow = row + drow[i];
            int newcol = col + dcol[i];
            
            if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && vis[newrow][newcol]==0 && grid[newrow][newcol]==1)
            {
                dfs(newrow,newcol,grid,vis,list,row0,col0);
            }
        }
    }
    public static String toString(int r,int c)
    {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
