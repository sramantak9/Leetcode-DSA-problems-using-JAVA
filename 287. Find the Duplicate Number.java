class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int tp = Math.abs(nums[i]);
            if(nums[tp-1]<0)
            {
                return tp;
            }
            nums[tp-1]=(-1)*nums[tp-1];

        }

        return -1;
    }
}
