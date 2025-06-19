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
                if(detectcycle(i,adj,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycle(int start,ArrayList<ArrayList<Integer>> adj,boolean[] visited )
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,-1));
        visited[start] = true;
        while(!q.isEmpty())
        {
            int current = q.peek().current; 
            int parent = q.peek().parent;
            q.poll();
            for(int node : adj.get(current))
            {
                if(visited[node]==false)
                {
                    visited[node]=true;
                    q.add(new Pair(node,current));
                }
                else if(parent != node)
                {
                    return true;
                }
            }
        }
        return false;
    }
}









