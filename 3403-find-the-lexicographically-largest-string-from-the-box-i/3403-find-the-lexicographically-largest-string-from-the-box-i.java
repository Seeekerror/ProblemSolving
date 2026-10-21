class Solution {
    public String answerString(String word, int num) {
        if (num == 1)
            return word;
        PriorityQueue<String> pq = new PriorityQueue<>();
        int n = word.length();
        int i = 0, j = 0;
        while (j < n) {
            if (j - i + 1 > n - num + 1) {
                i++;
            }
            int len = n - num + 1;
            String s = word.substring(j, Math.min(j + len, n));
            pq.add(s);
            j++;
        }
        return Collections.max(pq);
    }
}