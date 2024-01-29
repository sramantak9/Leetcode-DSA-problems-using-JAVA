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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return 0;
        }
        HashMap<Long,Integer>m=new HashMap<>();// concept of using hashmap
        m.put((long)0,1);
         recur(root,m,0,targetSum);
         return ans;

    }
    public void recur(TreeNode root,HashMap<Long,Integer>m,long pre_sum,int k)
    {
        if(root==null)
        {
            return;
        }
        pre_sum+=root.val;
        if(m.containsKey(pre_sum-k))
        {
            ans+=m.get(pre_sum-k);
        }
        
        m.put(pre_sum,m.getOrDefault(pre_sum,0)+1);
        recur(root.left,m,pre_sum,k);
        recur(root.right,m,pre_sum,k);
        int tp=m.get(pre_sum);
        m.put(pre_sum,tp-1);

    }
}
