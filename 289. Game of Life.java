class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int live=0;
                int row[]={-1,1,0,0,-1,-1,1,1};
                int col[]={0,0,-1,1,-1,1,-1,1};
                for(int k=0;k<8;k++)
                {
                    int r=i+row[k];
                    int c=j+col[k];
                    if(r>=0 && r<n && c>=0 && c<m)
                    {
                        if(board[r][c]==1)
                        {
                            live++;
                        }
                    }
                }
                if(live<2 && board[i][j]==1)
                {
                    ans[i][j]=0;
                }
                else if((live==2 || live==3) && (board[i][j]==1))
                {
                   ans[i][j]=1;
                }
                else if(live>3 && board[i][j]==1)
                {
                    ans[i][j]=0;
                }
                else if(live==3 && board[i][j]==0)
                {
                    ans[i][j]=1;
                }

            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                board[i][j]=ans[i][j];
            }
        }
    }
}
