class Solution {
    public int minimumEffort(int[][] tasks) {
        int low=1;
        int high=(int)1e9;
        int ans=0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(check(tasks,mid)){
                ans = mid;
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean check(int [][] tasks, int mid){
        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );
        for(int [] task : tasks){
            int act = task[0];
            int min = task[1];
            if(mid < min){
                return false;
            }
            mid -= act;
        }
        return true;
    }
}