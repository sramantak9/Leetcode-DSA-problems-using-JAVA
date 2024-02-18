/**********************************************************
	Following is the Binary Tree Node class.

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
		this.data = data;
	    }
	}
	
***********************************************************/

public class Solution {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        BinaryTreeNode<Integer>ans=solve(root,node1,node2,node3);
		return ans;
    }
	public static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root,int n1,int n2, int n3)
	{
		if(root==null)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> leftcall  = solve(root.left,n1,n2,n3);
		BinaryTreeNode<Integer> rightcall = solve(root.right,n1,n2,n3);

		if(root.data==n1 || root.data==n2 || root.data==n3)
			{
				return root;
			}

		else if(leftcall!=null && rightcall!=null)
		{
			return root;
		}
		
		
        return (leftcall!=null)?leftcall:rightcall;
		
		

	}
}
