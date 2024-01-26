class Solution {
    public int knightDialer(int n) {
        if(n==1)return 10;
        HashSet<String>set=new HashSet<>();
        int dialpad[][]=new int[4][3];
        int iter=1;
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                dialpad[i][j]=iter++;
            }
        }
        dialpad[3][1]=0;
       // dialpad creation completed above
       long dp[][][]=new long[4][3][n+1];
       for(int i=0;i<=3;i++)
       {
           for(int j=0;j<=2;j++)
           {
               for(int k=0;k<=n;k++)
               {
                   dp[i][j][k]=-1;
               }
           }
       }
       long ans=0;
       for(int i=0;i<=3;i++)
       {
           for(int j=0;j<=2;j++)
           {
               if((i==3 && j==0) || (i==3 && j==2))
               {
                   continue;
               }
               else
               {
                   
                  ans=(ans+recur(i,j,dialpad,set,n,"",dp))%(1000000007L);
               }
           }
       }
       return (int) ans;

    }
    public long recur( int r, int c,int dialpad[][],HashSet<String>set,int total, String s,long dp[][][])
    {
        if((r==3 && c==0) || (r==3 && c==2))
        {
            return 0;
        }
        if(r<0 || r>3 || c<0 || c>2)
        {
            return 0;
        }
        if(total==0)
        {
            if(set.contains(s)==false)
            {
                set.add(s);
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[r][c][total]!=-1)
        {
            return dp[r][c][total];
        }
        s+=dialpad[r][c];
        long ans=0;
        int row[]={-2,-2,2,2,-1,1,-1,1};
        int col[]={1,-1,1,-1,2,2,-2,-2};
        for(int i=0;i<8;i++)
        {
            int nr=r+row[i];
            int nc=c+col[i];
            ans=(ans+recur(nr,nc,dialpad,set,total-1,s,dp))%(1000000007L);
            
        }
         s = s.substring(0, s.length() - 1);
        return dp[r][c][total] =  ans;

    }
}
