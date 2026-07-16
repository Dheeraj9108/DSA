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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while(cur != null){
            if(prev != null && cur.val == prev.val){
                prev.next = next;
                cur.next = null;
            } else {
                prev = cur;
            }
            cur = next;
            if(next != null) next = next.next;
        }

        return head;
    }
}