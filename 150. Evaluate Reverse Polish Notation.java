class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        int ans=0;
        for(int i=0;i<tokens.length;i++)
        {
            String tp=tokens[i];
            char ch=' ';
            if(tp.length()==1)
            {
                ch=tp.charAt(0);
            }
            else if(tp.length()>1)
            {
                 ch=tp.charAt(1);
            }
            
            if(Character.isDigit(ch))
            {
                st.push(Integer.parseInt(tp));
            }
            else
            {
                int calc=0;
                int a=st.pop();
                int b=st.pop();
                
                if(tp.equals("+"))
                {
                    
                     calc=a+b;
                }
                else if(tp.equals("-"))
                {
                    
                     calc=b-a;
                }
                else if(tp.equals("*"))
                {
                     calc=a*b;
                }
                else if(tp.equals("/"))
                {
                     calc=b/a;
                }
                
               st.push(calc);
            }
        }
        
        ans=st.pop();
        return ans;
    }
}
