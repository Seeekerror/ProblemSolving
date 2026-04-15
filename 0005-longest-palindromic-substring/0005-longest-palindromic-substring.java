class Solution {
    int max = 0;
    int start = 0 , end = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalin(s,i,j)){
                    if((j - i + 1) > max){
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        System.out.println(max);
        return s.substring(start,end+1);
        
    }

    Boolean isPalin(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}