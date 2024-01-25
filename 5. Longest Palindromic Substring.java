class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)
        {
            return s;
        }
        String ans="";
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            int left=i-1;
            int right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                
                int temp=(right-left)+1;
                if(temp>max)
                {
                    max=temp;
                    ans=s.substring(left,right+1);
                }
                left--;
                right++;

            }

        }
        for(int i=0;i<s.length();i++)
        {
            int right=i+1;
            int left=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                int temp=(right-left)+1;
                if(temp>max)
                {
                    max=temp;
                    ans=s.substring(left,right+1);
                }
                left=left-1;
                right=right+1;
            }
        }
        if(ans=="")
        {
            ans+=s.charAt(0);
            return ans;
        }
        return ans;
    }
}
