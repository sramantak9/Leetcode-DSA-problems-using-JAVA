class Solution {
    public int[] productExceptSelf(int[] nums) {
        // magic hai yeh problem bhaiyaa

        int n = nums.length;
        int answer[]=new int[n];
        int preProduct = 1;
        for(int i=0;i<n;i++)
        {
           answer[i] = preProduct;
           preProduct *= nums[i]; 
        }
        int suffixProduct = 1;
        for(int i=n-1;i>=0;i--)
        {
          answer[i] = suffixProduct*answer[i];
          suffixProduct*=nums[i];
        }

        return answer;
    }
}
