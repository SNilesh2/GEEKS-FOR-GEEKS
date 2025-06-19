class Pair
{
    int current;
    int parent;
    public Pair(int current,int parent)
    {
        this.current=current;
        this.parent=parent;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
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
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(detectcycle(i,-1,adj,visited)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycle(int s,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] visited)
    {
        visited[s]=true;
        for(int node : adj.get(s))
        {
            if(visited[node]==false)
            {
                if(detectcycle(node,s,adj,visited)==true)
                {
                    return true;
                }
            }
            else if(parent != node)
            {
                return true;
            }
        }
        return false;
    }
}









