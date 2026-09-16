class Solution {

    // Merge two sorted linked lists
    public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    // Find middle of linked list
    public ListNode findMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // LeetCode expects this method name
    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode middle = findMiddle(head);

        // Split the list
        ListNode right = middle.next;
        middle.next = null;

        ListNode left = head;

        // Sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge both sorted halves
        return mergeTwoSortedLinkedLists(left, right);
    }
}