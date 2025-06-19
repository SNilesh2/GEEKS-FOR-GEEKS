class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited=new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                dfs(i,adj,visited,st);
            }
        }
        
        ArrayList<Integer> res= new ArrayList<>();
        while(!st.isEmpty())
        {
            res.add(st.pop());
        }
        
        return res;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited,Stack<Integer> st)
    {
        visited[node]=true;
        for(int neighbour : adj.get(node))
        {
            if(visited[neighbour]==false)
            {
                dfs(neighbour,adj,visited,st);
            }
        }
        st.push(node);
        return;
    }
}






















