class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer>st=new Stack<>();
        int answer[]=new int[n];
        answer[n-1]=0;
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            int tp=temperatures[i];
            while(st.isEmpty()==false && temperatures[st.peek()]<=tp)
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                answer[i]=0;
            }
            else
            {
                answer[i]=st.peek()-i;
            }
            st.push(i);
        }
        return answer;
    }
}
