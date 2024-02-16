
class info
{
    int max;
    int min;
    boolean isBst;
    int size;
    int ans;
    info(int max, int min, boolean isBst,int size,int ans)
    {
        this.max=max;
        this.min=min;
        this.isBst=isBst;
        this.size=size;
        this.ans=ans;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        info tp=solve(root);
        return tp.ans;
        
        
    }
    
     public static info solve(Node root)
    {
        if(root==null)
        {
            return new info(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0,0);
        }
        if(root.left==null && root.right==null)
        {
            return new info(root.data,root.data,true,1,1);
        }
        info left=solve(root.left);
        info right=solve(root.right);
        int size=left.size+right.size+1;
        int currmax=Math.max(Math.max(root.data,left.max),right.max);
        int currmin=Math.min(Math.min(root.data,left.min),right.min);
        int currans=Math.max(left.ans,right.ans);
        boolean currIsBst=false;
        if(left.isBst && right.isBst && (root.data>left.max && root.data<right.min))
        {
            currIsBst=true;
        }
        if(currIsBst)
        {
            currans=Math.max(Math.max(size,left.ans),right.ans);
        }

        return new info(currmax,currmin,currIsBst,size,currans);

    }
}
