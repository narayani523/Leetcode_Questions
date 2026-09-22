/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode knode=null;
        ListNode nextnode= null;
        ListNode prevnode=null;
        while(temp!=null){
            knode=findnode(temp,k);
            if(knode==null){
                if(prevnode!=null){
                    prevnode.next=temp;
                }
                break;
            }
            //preserving nextnode
            nextnode=knode.next;
            knode.next = null;
            reverse(temp);
            if(temp==head){
                head=knode;
                prevnode=temp;
                temp=nextnode;
            }
            else{
                prevnode.next=knode;
                prevnode=temp;//presering last node of prev ll
                temp=nextnode;
            }
            
        }
        return head;
    }
    public ListNode findnode(ListNode temp,int k){
        ListNode kth=temp;
        for(int i=1;i<k;i++){
            if(kth==null) return null;
            kth=kth.next;
        }
        return kth;
    }
    
    public ListNode reverse(ListNode temp) {
    ListNode prev = null;
    ListNode t = temp;
    while (t != null) {
        ListNode front = t.next;  
        t.next = prev;            
        prev = t;                 
        t = front;                
    }
    return prev;
    }

}