class pair // used for arraylist
{
    int destination;
    int cost;
    pair(int destination,int cost)
    {
        this.destination=destination;
        this.cost=cost;
    }
}
class tuple
{
    int stops;
    int node;
    int cost;
    tuple(int stops, int node, int cost)
    {
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
          adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++) // creating the adjacency list
        {
            int from=flights[i][0];
            int to=flights[i][1];
            int price=flights[i][2];
            adj.get(from).add(new pair(to,price));
        }
        int prices[]=new int[n];
        Arrays.fill(prices,(int)1e9);
        prices[src]=0;
        PriorityQueue<tuple>pq=new PriorityQueue<>((x,y) -> x.stops - y.stops);
        pq.add(new tuple(0,src,0));
        while(pq.isEmpty()==false)
        {
            tuple temp=pq.poll();
            int node=temp.node;
            int stops=temp.stops;
            int cost=temp.cost;
            if(node==dst)
            {
                continue;
            }
            if(stops>k)
            {
               continue;
            }
            for(int i=0;i<adj.get(node).size();i++)
            {
                pair neighbour=adj.get(node).get(i);
                int amount=neighbour.cost;
                int destination=neighbour.destination;
                if(amount+cost<prices[destination])
                {
                    prices[destination]=amount+cost;
                    pq.add(new tuple(stops+1,destination,prices[destination]));
                }
            }
        }

        if(prices[dst]==(int)1e9)
        {
            return -1;
        }
        return prices[dst];

    }
}
