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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode temp = head;
        ListNode cur = dummy;
        while(temp!= null){
            if(temp.next != null){
                cur.next = new ListNode(temp.next.val);
                cur = cur.next;
                cur.next = new ListNode(temp.val);
                temp = temp.next.next;
                cur = cur.next;
            } else {
                cur.next = temp;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}

// 1 -> 2 -> 3 -> 4

// dummy -> 2 -> 1