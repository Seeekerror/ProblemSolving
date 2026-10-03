class Solution {
    public int largestAltitude(int[] gain) {
        int [] prefix = new int[gain.length+1];
        prefix[0] = 0;
        int j = 1;
        for(int i = 0; i < gain.length; i++){
            prefix[j] = gain[i]+prefix[j-1];
            j++;
        }
        int ans = 0;
        for(int i = 0; i < prefix.length; i++){
            ans = Math.max(ans,prefix[i]);
        }
        return ans;
    }
}