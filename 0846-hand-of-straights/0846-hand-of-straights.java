class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : hand) {
            pq.add(x);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        while (!pq.isEmpty()) {
            if(map.get(pq.peek()) == 0){
                pq.poll();
                continue;
            }
            for(int j = 0; j < groupSize; j++){
                int num = pq.peek() + j;
                if(!map.containsKey(num) || map.get(num) <= 0){
                    return false;
                }
                map.put(num,map.getOrDefault(num,0)-1);
            }
        }
        return true;
    }
}