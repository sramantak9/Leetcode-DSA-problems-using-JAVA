class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[]=new int[n];
        visited[0]=1;
        boolean checkcycle = dfs(0,-1,visited,adj);
        
        if(checkcycle==false)
        {
            return false;
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                return false;
            }
            
        }
        return true;
    }
    public boolean dfs(int node, int parent,int visited[],ArrayList<ArrayList<Integer>>adj)
    {
        for(int i=0;i<adj.get(node).size();i++)
        {
            int tp=adj.get(node).get(i);
            if(visited[tp]==0)
            {
                visited[tp]=1;
                boolean ans = dfs(tp,node,visited,adj);
                if(ans==false)
                {
                    return false;
                }
                
            }
            else if(visited[tp]==1 && tp!=parent)
            {
                return false;
            }
            
        }
        return true;
    }
}
