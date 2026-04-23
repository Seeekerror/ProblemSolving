class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0; 
        int j = n-1;
        while(i < j){
            int num = numbers[i] + numbers[j];
            if(num == target) return new int[]{i+1,j+1};
            if(num > target) j--;
            if(num < target) i++;
        }
        return new int[]{-1,-1};
    }
}