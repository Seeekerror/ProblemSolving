class Solution {
    public int sumOfPrimesInRange(int n) {
        int r=0;
        int num=n;
        while(num > 0){
            int res = num%10;
            r = 10 * r + res;
            num/=10;
        }
        int x = Math.min(r,n);
        int y = Math.max(r,n);

        int sum=0;
        for(int i=x; i<=y;i++){
            if(isPrime(i)){
                sum+=i;
            }
        }
        return sum;
    }
    boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2;i*i<=num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}