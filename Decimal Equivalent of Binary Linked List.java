class Solution
{
   long DecimalValue(Node head)
   {
 	 long sum=0;
 	  head=reverse(head);
 	 int tp=0;
 	 Node ptr=head;
 	 long MOD=(long)1000000007L;
 	 long power=1;
 	 while(ptr!=null)
 	 {
 	    
 	    sum+=(ptr.data *(long)(power % MOD)) % MOD;
 	    power=(long)((power*2)%(long)1000000007L);
 	    ptr=ptr.next;
 	    tp++;
 	 }
 	 return sum%1000000007L;
   }
   Node reverse(Node head)
   {
       Node prev=null;
       Node curr=head;
       Node fast=null;
       while(curr!=null)
       {
           fast=curr.next;
           curr.next=prev;
           prev=curr;
           curr=fast;
       }
       return prev;
   }
   
   long pow(int tp)
   {
       long ans=1;
       for(int i=1;i<=tp;i++)
       {
           ans=(long)((ans*2)%(long)1000000007L);
       }
       return ans;
   }
}
