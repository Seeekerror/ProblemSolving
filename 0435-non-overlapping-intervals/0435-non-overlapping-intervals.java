class Solution {
    public int eraseOverlapIntervals(int[][] inter) {
        int c=0;
        Arrays.sort(inter, (a, b) -> Integer.compare(a[1], b[1]));
        int [] x = inter[0];
        for(int i=1;i<inter.length;i++){
            if(inter[i][0] < x[1]){
                c++;
            }else{
                x = inter[i];
            }
        }
        return c;
    }
}