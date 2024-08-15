//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair
{
    int first;
    int second;
    Pair(int _first,int _second)
    {
        this.first=_first;
        this.second=_second;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
                if(iscycle(i,adj,vis)==true) return true;
            }
        }
        return false;
    }
    public static boolean iscycle(int src,ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src]=true;
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int adjacentnode:adj.get(node))
            {
                if(vis[adjacentnode]==false)
                {
                    q.add(new Pair(adjacentnode,node));
                    vis[adjacentnode]=true;
                }
                else if(parent!=adjacentnode && vis[adjacentnode]==true) return true;
            }
        }
        return false;
    }
}