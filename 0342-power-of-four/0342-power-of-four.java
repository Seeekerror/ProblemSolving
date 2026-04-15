class Solution {
    public boolean isPowerOfFour(int n) {
        while(n > 0){
            if(n == 1 || n == 4) return true;
            if(n < 4 || n % 4 != 0) return false;
            n/=4;
        }
        return false;
    }
}