class Solution {
    public int[][] merge(int[][] inter) {
        Arrays.sort(inter , (a , b) -> Integer.compare(a[0],b[0]));
        List<int[]> l = new ArrayList<>();
        l.add(inter[0]);
        for(int i=1;i<inter.length;i++){
            int [] x = l.get(l.size()-1);
            if(inter[i][0] <= x[1]){
                x[1] = Math.max(inter[i][1],x[1]);
            }else{
                l.add(inter[i]);
            }
        }
        int [][] ar = new int[l.size()][2];
        for(int i=0;i<l.size();i++){
            int [] val = l.get(i);
            ar[i][0] = val[0];
            ar[i][1] = val[1];
        }
        return ar;
    }
}