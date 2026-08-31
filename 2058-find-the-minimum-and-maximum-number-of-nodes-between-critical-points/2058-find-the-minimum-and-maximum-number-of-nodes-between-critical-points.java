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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode node = head;
        ListNode prev = head;
        int idx=1;
        while (node.next != null) {
            if((node.val > prev.val && node.val > node.next.val) || (node.val < prev.val && node.val < node.next.val)){
                l.add(idx);
            }
            prev = node;
            node = node.next;
            idx++;
        }
        if (l.size() < 2)
            return new int[] { -1, -1 };
        Collections.sort(l);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<l.size();i++){
            min = Math.min(min,l.get(i)-l.get(i-1));
        }
        int max = l.get(l.size() - 1) - l.get(0);
        return new int[] { min, max };
    }
}