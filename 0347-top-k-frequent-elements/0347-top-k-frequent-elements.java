class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(int key : map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        int [] arr = new int[k];
        for(int i=0;i<k;i++){
            int [] x = pq.poll();
            arr[i] = x[0];
        }
        return arr;
    }
}