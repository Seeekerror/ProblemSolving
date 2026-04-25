class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(s.length == 0) return 0;
        int i = 0 , j = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}