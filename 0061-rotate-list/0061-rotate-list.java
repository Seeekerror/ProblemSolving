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
        ListNode cur = head;
        if(head==null) return null;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        cur.next = head;
        size = size - k%size;
        cur = head;
        while(size-->1){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}