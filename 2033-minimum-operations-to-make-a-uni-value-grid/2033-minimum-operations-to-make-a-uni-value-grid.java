class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                l.add(grid[i][j]);
            }
        }
        Collections.sort(l);
        int base = l.get(0);
        for(int i=0; i<l.size(); i++){
            if((l.get(i) - base) % x != 0) return -1;
        }
        int num = l.get(l.size()/2);
        int count=0;
        for(int i = 0; i<l.size(); i++){
            int val = l.get(i);
            if(val < num){
                count+=(num-val)/x;
            }else{
                count+=(val-num)/x;
            }
        }
        return count;
    }
}