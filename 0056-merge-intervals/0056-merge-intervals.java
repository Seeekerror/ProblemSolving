class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> l = new ArrayList<>();
        l.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int [] last = l.get(l.size()-1);
            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(last[1],intervals[i][1]);
            }else{
                l.add(intervals[i]);
            }
        }
        return l.toArray(new int[l.size()][]);
    }
}