class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int c = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            int h = n - i;
            if(citations[i] >= h) c++;
        }
        return c;
    }
}