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
    public ListNode removeNodes(ListNode head) {
        //if(head.next == null) return temp;
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode temp = prev;
        int max = temp.val;
        ListNode cur2 = temp;
        while(cur2 != null && cur2.next != null){
            if(cur2.next.val < max){
                cur2.next = cur2.next.next;
            }else{
                cur2 = cur2.next;
                max = cur2.val;
            }
        }
        ListNode prev1 = null;
        ListNode cur1 = temp;

        while(cur1 != null){
            ListNode next1 = cur1.next;
            cur1.next = prev1;
            prev1 = cur1;
            cur1 = next1;
        }
        return prev1;
    }
}