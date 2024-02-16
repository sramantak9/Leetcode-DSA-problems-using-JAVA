class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
		solve(n,"",ans,0,0);
		return ans;
    }
    public static void solve(int n, String s,List<String>ans,int open, int close)
	{
		if(open==n && close==n)
		{
			ans.add(s);
			return;
		}
		if(open<n)
		{
			s+="(";
			solve(n,s,ans,open+1,close);
			s=s.substring(0,s.length()-1);
		}
		if(open>close)
		{
			s+=")";
			solve(n,s,ans,open,close+1);
			s=s.substring(0,s.length()-1);
		}
	    
	}
}
