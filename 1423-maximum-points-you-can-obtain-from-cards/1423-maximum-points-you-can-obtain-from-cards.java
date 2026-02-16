class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < n - k; i++){
            sum += cardPoints[i];
        }
        minSum = Math.min(minSum,sum);
        System.out.println(minSum);
        int l = 0;
        int r = (n-k)-1;
        while(r < n-1){
            sum -= cardPoints[l];
            l++;
            
            r++;
            sum += cardPoints[r];

            minSum = Math.min(minSum,sum);
        }
        System.out.println(minSum);

        int total = 0;
        for(int i = 0; i < n; i++){
            total += cardPoints[i];
        }

        System.out.println(total);

        return total - minSum;
    }
}