class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] dfsvisited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i] == false)
            {
                if(detectcycle(i,adj,visited,dfsvisited)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycle(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] dfsvisited)
    {
        visited[s]=true;
        dfsvisited[s]=true;
        for(int node : adj.get(s))
        {
            if(visited[node]==false)
            {
                if(detectcycle(node,adj,visited,dfsvisited)==true)
                {
                    return true ;
                }
            }
            else if(dfsvisited[node] == true)
            {
                return true;
            }
        }
        dfsvisited[s]=false;
        return false;
    }
}