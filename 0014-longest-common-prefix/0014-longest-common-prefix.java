class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String s = strs[0];
        for(int i=1;i<strs.length;i++){
            String st = strs[i];
            int j = 0;
            String str = s;
            while(j < str.length() && j < st.length()){
                if(str.charAt(j) != st.charAt(j)){
                    break;
                }
                j++;
            }
            s = st.substring(0, j);
        }
        return s;
    }
}