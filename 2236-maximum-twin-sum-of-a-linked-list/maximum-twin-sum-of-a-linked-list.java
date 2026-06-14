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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        int n = list.size();
        for(int i = 0;i<(n/2);i++){
            max = Math.max(max, list.get(i)+list.get(n-1-i));
        }
        return max;
    }
}