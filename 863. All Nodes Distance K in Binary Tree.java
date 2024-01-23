/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode startnode, int k) {
        List<Integer>ans=new ArrayList<>();
        HashSet<Integer>visited=new HashSet<>();
        HashMap<Integer,TreeNode>nodeToParentMap=new HashMap<>();
        ArrayDeque<TreeNode>q=new ArrayDeque<>();
        q.offerLast(root);
        
        while(q.isEmpty()==false)
        {
            TreeNode curr=q.pollFirst();
           
            if(curr==root)
            {
                nodeToParentMap.put(curr.val,null);
            }
            if(curr.left!=null)
            {
                nodeToParentMap.put(curr.left.val,curr);
                q.offerLast(curr.left);
            }
            if(curr.right!=null)
            {
                nodeToParentMap.put(curr.right.val,curr);
                q.offerLast(curr.right);
            }

        }
        /*for(Map.Entry<Integer,TreeNode>e:nodeToParentMap.entrySet())
        {
            if(e.getValue()==null)
            {
                 System.out.println(e.getKey()+" "+null);
                 continue;
            }
            System.out.println(e.getKey()+" "+e.getValue().val);
        }*/
        

        q.offerLast(startnode);
        int count=0;
    
        while(q.isEmpty()==false)
        {
            boolean flag=false;
            int size=q.size();
            while(size!=0)
            {
            TreeNode curr=q.pollFirst();
            if(count==k)
            {
                ans.add(curr.val);
            }
            visited.add(curr.val);
            TreeNode curr_parent=nodeToParentMap.get(curr.val);
            if(curr_parent!=null && visited.contains(curr_parent.val)==false)
            {
                flag=true;
                q.offerLast(curr_parent);
                visited.add(curr_parent.val);
            }
            if(curr.left!=null && visited.contains(curr.left.val)==false)
            {
                flag=true;
                q.offerLast(curr.left);
                visited.add(curr.left.val);
            }
            if(curr.right!=null && visited.contains(curr.right.val)==false)
            {
                flag=true;
                q.offerLast(curr.right);
                visited.add(curr.right.val);
            }
            size--;
            }
            if(flag==true)
            {
                count++;
                
            }

        }
        return ans;
    }
}
