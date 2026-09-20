class Solution {
    public int reverseDegree(String s) {
        char[] ar = new char[26];
        int x = 0;
        for (char i = 'z'; i >= 'a'; i--) {
            ar[x++] = i;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (ar[s.charAt(i)-'a']-'a'+1) * (i+1);
        }
        return ans;
    }
}