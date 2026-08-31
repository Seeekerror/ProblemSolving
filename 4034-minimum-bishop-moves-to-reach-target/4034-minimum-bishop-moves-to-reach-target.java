class Solution {
    public int minBishopMoves(int[] src, int[] tar) {

        // Different colored squares
        if ((src[0] + src[1]) % 2 != (tar[0] + tar[1]) % 2) {
            return -1;
        }

        // Same diagonal
        if (src[0] + src[1] == tar[0] + tar[1] ||
            src[0] - src[1] == tar[0] - tar[1]) {
            return 1;
        }

        // Same color, but different diagonal
        return 2;
    }
}