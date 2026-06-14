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
        ListNode temp = head;
        int size=0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        ListNode prev=null;
        ListNode cur = head;
        for(int i=0;i<size/2;i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        int ans=0;
        while(prev != null){
            ans = Math.max(ans , prev.val + cur.val);
            prev = prev.next;
            cur = cur.next;
        }
        return ans;
    }
}