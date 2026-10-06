class Solution {
    public int minRotations(String s) {
        int ans = Math.min(s.charAt(0)-'0',10-(s.charAt(0)-'0'));
        for(int i = 1; i < s.length(); i++){
            int d = Math.abs((s.charAt(i)-'0') - (s.charAt(i-1)-'0'));
            ans += Math.min(d,10-d);
        }
        return ans;
    }
}