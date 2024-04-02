class Solution {
    public static int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(root,arr);
        return mergeSort(arr,0,n-1);
    }
    
    public static int mergeSort(ArrayList<Integer>arr,int s,int e)
    {
      if(s>=e)
      {
          return 0;
      }
      int mid = (s+e)/2;
      int left = mergeSort(arr,s,mid);
      int right = mergeSort(arr,mid+1,e);
      int fromMerge = merge(arr,s,mid,e);
      return left+right+fromMerge;
    }
    
    public static int merge(ArrayList<Integer>arr,int s, int mid,int e)
    {
        int ans = 0;
        int i = s;
        int j = mid+1;
        ArrayList<Integer>l = new ArrayList<>();
        while(i<=mid && j<=e)
        {
            if(arr.get(j)<arr.get(i))
            {
                ans+=(mid - i + 1);
                l.add(arr.get(j));
                j++;
            }
            else
            {
                l.add(arr.get(i));
                i++;
                
            }
        }
        
        while(i<=mid)
        {
            l.add(arr.get(i));
            i++;
        }
        
        while(j<=e)
        {
            l.add(arr.get(j));
            j++;
        }
        
        i = 0;
        j = s;
        while(j<=e)
        {
            arr.set(j,l.get(i));
            i++;
            j++;
        }
        
        return ans;
    }
    
    public static void inorder(Node root,ArrayList<Integer>arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}
