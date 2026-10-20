class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for(int i = 0; i < strs[0].length(); i++){
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){
                if(strs[j-1].charAt(i) > strs[j].charAt(i)){
                    flag = false;
                }
            }
            if(!flag){
                ans++;
            }
        }
        return ans;
    }
}