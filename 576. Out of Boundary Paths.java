class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][]=new long[m][n][maxMove+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<maxMove+1;k++)
                {
                    dp[i][j][k]=-1;
                    System.out.print(dp[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        return (int)recur (m,n,maxMove,startRow,startColumn,dp);

    }
    public long recur(int m, int n, int maxMove, int r, int c,long dp[][][])
    {
        if(r<0 || r>=m || c<0 || c>=n)
        {
            return 1;
        }
        if(maxMove==0)
        {
            return 0;
        }
        if(dp[r][c][maxMove]!=-1)
        {
            return dp[r][c][maxMove];
        }
        long up=recur(m,n,maxMove-1,r-1,c,dp);
        long down=recur(m,n,maxMove-1,r+1,c,dp);
        long left=recur(m,n,maxMove-1,r,c-1,dp);
        long right=recur(m,n,maxMove-1,r,c+1,dp);
        return dp[r][c][maxMove] =  ((up+down+right+left)%(1000000007L));
    }

}
