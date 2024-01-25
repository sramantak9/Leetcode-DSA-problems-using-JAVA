class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        //int i=s1.length()-1;
        //int j=s2.length()-1;
        /*int dp[][]=new int[i+1][j+1];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return recur(s1,s2,i,j,dp);*/
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                     dp[i][j] =  1+ dp[i-1][j-1];
                }
                else
                {
                    int left=dp[i-1][j];
                    int right=dp[i][j-1];
                     dp[i][j] =  Math.max(left,right);
                }
            }
        }
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
    public int recur(String s1,String s2,int i, int j,int dp[][])
    {
        if(i<0 || j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j] =  1+recur(s1,s2,i-1,j-1,dp);
        }
        else
        {
            int left=recur(s1,s2,i-1,j,dp);
            int right=recur(s1,s2,i,j-1,dp);
            return dp[i][j] =  Math.max(left,right);
        }
    }
}
