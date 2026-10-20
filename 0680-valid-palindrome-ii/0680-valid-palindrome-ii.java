class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        int k = 1;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else if(k == 1){
                k--;
                return check(s, i + 1, j) || check(s, i, j - 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
    boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}