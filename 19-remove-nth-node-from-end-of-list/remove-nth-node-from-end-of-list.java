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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = reverse(head);
        if (n == 1) {
            newHead = newHead.next;
        } else {
            ListNode temp = newHead;
            ListNode prev = newHead;
            n--;
            while (n != 0) {
                prev = temp;
                temp = temp.next;
                n--;
            }
            if (temp == null)
                prev.next = null;
            else
                prev.next = temp.next;
        }
        return reverse(newHead);
    }

    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode prev = null;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        return prev;
    }
}