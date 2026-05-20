class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int [] C = new int[A.length];
        int [] freq = new int[A.length+1];
        int c=0;
        for(int i=0;i<B.length;i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                c++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                c++;
            }
            C[i] = c;
        }
        return C;
    }
}