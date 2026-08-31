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
        while (node != null) {
            l.add(node.val);
            node = node.next;
        }
        List<Integer> ls = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 1; i < l.size() - 1; i++) {
            if (l.get(i - 1) < l.get(i) && l.get(i) > l.get(i + 1)) {
                ls.add(i);
                if (x > 0) { min = Math.min(min, ls.get(x) - ls.get(x - 1)); } x++;
            } else if (l.get(i - 1) > l.get(i) && l.get(i) < l.get(i + 1)) {
                ls.add(i);
                if (x > 0) {
                    min = Math.min(min, ls.get(x) - ls.get(x - 1));
                }
                x++;

            }
        }
        if (ls.size() < 2)
            return new int[] { -1, -1 };
        Collections.sort(ls);
        int max = ls.get(ls.size() - 1) - ls.get(0);
        return new int[] { min, max };
    }
}