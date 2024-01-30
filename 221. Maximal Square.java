class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int ans=recur(i,j,matrix,n,m,dp);
                    max=Math.max(max,ans);
                }
            }
        }
        return max*max;
    }

    public int recur(int i, int j,char matrix[][],int n, int m,int dp[][])
    {
       if(i<0 || i>=n || j<0 || j>=m)
       {
           return 0;
       }
       if(matrix[i][j]=='0')
       {
           return 0;
       }
       if(dp[i][j]!=-1)
       {
           return dp[i][j];
       }

       int diagonal=1+recur(i+1,j+1,matrix,n,m,dp);
       int right=1+recur(i,j+1,matrix,n,m,dp);
       int down=1+recur(i+1,j,matrix,n,m,dp);
       return dp[i][j]=Math.min(Math.min(diagonal,right),down);
   }
}
