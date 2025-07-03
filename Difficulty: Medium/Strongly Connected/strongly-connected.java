class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        int[] visited = new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,adj,visited,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adjT.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++)
        {
            visited[i]=0;
            for(Integer it : adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }
        int scc=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(visited[node]==0)
            {
                scc++;
                dfs1(node,adjT,visited);
            }
        }
        return scc;
    }
    public static void dfs1(int node,ArrayList<ArrayList<Integer>> adjT,int[] visited)
    {
        visited[node]=1;
        for(Integer it : adjT.get(node))
        {
            if(visited[it]==0)
            {
                dfs1(it,adjT,visited);
            }
        }
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> st)
    {
        visited[node]=1;
        for(Integer it : adj.get(node))
        {
            if(visited[it]==0)
            {
                dfs(it,adj,visited,st);
            }
        }
        st.push(node);
    }
}