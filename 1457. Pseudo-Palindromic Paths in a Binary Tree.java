/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        //ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int cnt[]=new int[10];
        preorder(root,cnt);
        return ans;
    }
    public void preorder(TreeNode root,int cnt[])
    {
        if(root==null)
        {
            return;
        }
        cnt[root.val]++;
        if(root.left==null && root.right==null)
        {
           
            
            int odd=0;
            for(int i=1;i<10;i++)
            {
                if(cnt[i]%2!=0)
                {
                   odd++;
                }
            }
            if(odd==0 || odd==1)
            {
                ans++;
            }
        }
        preorder(root.left,cnt);
        preorder(root.right,cnt);
        cnt[root.val]--;
    }
}
