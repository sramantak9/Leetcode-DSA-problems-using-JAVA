class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i]=(int)1e8;
        }
        dist[S]=0;
        
        // relaxation of edges
        
        for(int i=0;i<=V;i++)
        {
            for(int j=0;j<edges.size();j++)
            {
                int u=edges.get(j).get(0);
                int v=edges.get(j).get(1);
                int wt=edges.get(j).get(2);
                
                if(dist[u]==(int)1e8)
                {
                    continue;
                }
                
                else
                {
                    if(dist[u]+wt<dist[v])
                    {
                        if(i==V)  // return for negative cycle
                        {
                            int arr[]=new int[1];
                            arr[0]=-1;
                            return arr;
                        }
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        
        return dist;
    }
}
