class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        int indegree[]=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            
            adj.get(u).add(v);
            indegree[v]++;
            
        }
        ArrayList<Integer>l=new ArrayList<>();
        ArrayDeque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                
                q.offerLast(i);
            }
        }
        while(q.isEmpty()==false)
        {
            int node=q.pollFirst();
           l.add(node);
            for(int i=0;i<adj.get(node).size();i++)
            {
                int tp=adj.get(node).get(i);
                indegree[tp]--;
                if(indegree[tp]==0)
                {
                    q.offerLast(tp);
                    
                }
            }
        }
        if(l.size()!=n)
        {
            return false;
        }
        
        return true;
    }
    }
