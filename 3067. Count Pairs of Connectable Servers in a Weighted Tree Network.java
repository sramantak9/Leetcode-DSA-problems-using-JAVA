class pair
{
    int node;
    int wt;
    pair(int node, int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n=edges.length+1;
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n-1;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int weight=edges[i][2];
            adj.get(u).add(new pair(v,weight));
            adj.get(v).add(new pair(u,weight));
        }
        
        int fans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int currVal=0;
            ArrayList<Integer>l=new ArrayList<>();
            
            for(int j=0;j<adj.get(i).size();j++)
            {   
                int visited[]=new int[n];
                pair tp=adj.get(i).get(j);
                int node=tp.node;
                int wt=tp.wt;
                visited[i] = 1;
                int ret = dfs(node,wt,visited,adj,signalSpeed);
                System.out.println(ret);
                l.add(ret);
            }
            
            int sum=0;
            
            for(int e:l)
            {
                sum+=e;
            }
            
            for(int el: l)
            {
                currVal+=((sum-el)*el);
            }
            
            fans[i]=currVal/2;
        }
       
        return fans;
    }
    
    public int dfs(int root,int wtSum,int visited[],ArrayList<ArrayList<pair>>adj,int ss)
    {
        visited[root]=1;
        int goodCount=0;
        if(wtSum%ss==0)
        {
            goodCount++;
        }
        for(int i=0;i<adj.get(root).size();i++)
        {
            pair tp=adj.get(root).get(i);
            int node=tp.node;
            int wt=tp.wt;
            if(visited[node]==0)
            {
                wtSum=wtSum+=wt;
                goodCount+=dfs(node,wtSum,visited,adj,ss);
                wtSum=wtSum-wt;
            }
        }
        
        return goodCount;
    }
}
