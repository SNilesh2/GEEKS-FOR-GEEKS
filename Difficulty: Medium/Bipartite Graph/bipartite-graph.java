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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color=new int[adj.size()];
        Arrays.fill(color,-1);
        for(int i=0;i<adj.size();i++)
        {
            if(color[i]==-1)
            {
                if(check(adj,color,i)==false) return false;
            }
        }
        return true;
    }
    public static boolean check(ArrayList<ArrayList<Integer>>adj,int[] color,int start)
    {
        Queue<Integer> q=new LinkedList<>();
        color[start]=0;
        q.add(start);
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int it:adj.get(node))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node])
                {
                    return false;
                }
            }
        }
        return true;
    }
}