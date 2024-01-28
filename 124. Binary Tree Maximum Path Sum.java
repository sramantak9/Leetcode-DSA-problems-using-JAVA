class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }
    public int postorder(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left = Math.max(0, postorder(root.left));  // Ensure left is non-negative.
        int right = Math.max(0, postorder(root.right));  // Ensure right is non-negative.

        int total = root.val + left + right;
        int pathSum = root.val + Math.max(left, right);

        max = Math.max(max, Math.max(total, pathSum));
        
        return pathSum;
        
    }
}
