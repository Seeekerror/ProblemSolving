class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> l = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            if (cmp != 0)
                return cmp;
            return a.getKey().compareTo(b.getKey());
        });
        pq.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            l.add(pq.poll().getKey());
        }
        return l;
    }
}