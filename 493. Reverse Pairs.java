class Solution {
    public int reversePairs(int[] nums) {
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            arr.add(nums[i]);
        
        }
         int n=arr.size();
         return mergeSort(arr,0,n-1);

    }
     public int mergeSort(ArrayList<Integer>arr,int low, int high)
    {
        if(low>=high) // the answer for a single element is always zero
        {
            return 0;
        }
        int mid=(low+high)/2;
        int invP=mergeSort(arr,low,mid); // for left side call
         invP+=mergeSort(arr,mid+1,high); // for right side call
        invP+=merge(arr,low,mid,high);
        return invP;
        /* what this invP variable is dong that it is summing up the count from various 
        function calls to return to the main function.*/
    }
     public int merge(ArrayList<Integer>arr,int low, int mid, int high)
    {
        int cnt=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(j<=high && arr.get(i)>2*(long)arr.get(j))
            {
                j++;
            }
            cnt+=j-(mid+1);
        }

        ArrayList<Integer>l=new ArrayList<>();
        int i=low;
        j=mid+1;
        while(i<=mid && j<=high)
        {
            if(arr.get(i)<=arr.get(j))
            {
                l.add(arr.get(i));
                i++;
            }
            else
            {
                l.add(arr.get(j));
                j++;
            }
            
        }

        while(i<=mid)
        {
           l.add(arr.get(i));
           i++;
        }

        while(j<=high)
        {
            l.add(arr.get(j));
            j++;
        }
        i=0;
        for(int k=low;k<=high;k++)
        {
           arr.set(k,l.get(i++));
        }

        return cnt;
    }
}
