//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n=mat.length;
        int[][] visited=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                visited[i][j]=0;
            }
        }
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};
        ArrayList<String> res=new ArrayList<>();
        if(mat[0][0]==1) solve(0,0,mat,n,visited,res,di,dj,"");
        return res;
    }
    public static void solve(int i,int j,int[][] mat,int n,int[][] visited,ArrayList<String> res,int[] di,int[] dj,String move)
    {
        if(i==n-1 && j==n-1)
        {
            res.add(move);
            return;
        }
        String str="DLRU";
        for(int ind=0;ind<4;ind++)
        {
            int nexti=i+di[ind];
            int nextj=j+dj[ind];
            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && visited[nexti][nextj]==0 && mat[nexti][nextj]==1)
            {
                visited[i][j]=1;
                solve(nexti,nextj,mat,n,visited,res,di,dj,move+str.charAt(ind));
                visited[i][j]=0;
            }
        }
    }
}