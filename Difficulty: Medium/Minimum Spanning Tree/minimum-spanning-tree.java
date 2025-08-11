class Pair
{
    int weight;
    int node;
    Pair(int node,int weight)
    {
        this.weight=weight;
        this.node=node;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.weight-y.weight);
        pq.add(new Pair(0,0));
        int[] vis=new int[V];
        int sum=0;
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node=p.node;
            int weight=p.weight;
            if(vis[node]!=0)
            {
                continue;
            }
            vis[node]=1;
            sum+=weight;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int neighbour = adj.get(node).get(i).node;
                int dist=adj.get(node).get(i).weight;
                if(vis[neighbour]==0)
                {
                    pq.add(new Pair(neighbour,dist));
                }
            }
        }
        return sum;
    }
}
