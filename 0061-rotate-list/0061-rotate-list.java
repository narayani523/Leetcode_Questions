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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null ) return head;
        ListNode tail=head;
        ListNode newtail=null;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;

        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        newtail=findnth(head,len,k);
        head=newtail.next;
        newtail.next=null;
        return head;
    }
    public ListNode findnth(ListNode temp,int len,int k){
        for(int i =0;i<len-k-1;i++){
            temp=temp.next;
        }
        return temp;
    }
}