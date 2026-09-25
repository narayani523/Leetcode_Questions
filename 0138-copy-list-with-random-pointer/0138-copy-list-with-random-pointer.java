/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //step one
          Node temp=head;
          while(temp!=null){
            Node copy=new Node(temp.val);
            
            copy.next=temp.next;
            temp.next=copy;
            temp=temp.next.next;
          }

          //step 2
          temp =head;
          while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null) copy.random=temp.random.next;
           
            temp=temp.next.next;
          }

          //step3
          Node dnode=new Node(-1);
          Node res=dnode;

          temp=head;
          while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;

          }
          return dnode.next;
        
    }
}