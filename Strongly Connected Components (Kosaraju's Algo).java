lass Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // sort the vertices according to finishing time using stack
        Stack<Integer>st=new Stack<>();
        int visited[]=new int[V];
       for(int i=0;i<V;i++)
       {
           if(visited[i]==0)
           {
               dfs(i,visited,adj,st);
           }
       }
       
       // sorting all the vertices according to finishing time ends above  here
       
       // reversing all the edges of the graph
       
       ArrayList<ArrayList<Integer>>adjR = new ArrayList<>();
       
       for(int i=0;i<V;i++)
       {
        adjR.add(new ArrayList<>());
       }
       
       for(int i=0;i<V;i++)
       {
           for(int j=0;j<adj.get(i).size();j++)
           {
               int tp = adj.get(i).get(j);
               adjR.get(tp).add(i);
           }
       }
       
       // All the graph edges has been reversed above here
       
       int count = 0; // holds the number of strongly connected components
       Arrays.fill(visited,0);
       
       while(st.isEmpty()==false)
       {
           int node = st.pop();
           if(visited[node]==0)
           {
               count++;
               dfs2(node,visited,adjR);
               
           }
       }
       
       return count;
       
       
    }
    public void dfs2(int node,int visited[],ArrayList<ArrayList<Integer>> adj)
    {
         visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            int tp = adj.get(node).get(i);
            if(visited[tp]==0)
            {
                dfs2(tp,visited,adj);
            }
        }
    }
    public void dfs (int node,int visited[], ArrayList<ArrayList<Integer>> adj,Stack<Integer>st)
    {
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            int tp = adj.get(node).get(i);
            if(visited[tp]==0)
            {
                dfs(tp,visited,adj,st);
            }
        }
        st.push(node);
    }
}
