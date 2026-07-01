class Solution {
    public int maxDistance(String moves) {
        int y=0;
        int x=0;
        int space=0;
        for(int i = 0;i < moves.length();i++){
            if(moves.charAt(i) == 'U'){
                x++;
            }
            else if(moves.charAt(i) == 'L'){
                y--;
            }
            else if(moves.charAt(i) == 'D'){
                x--;
            }
            else if(moves.charAt(i) == 'R'){
                y++;
            }
            else{
                space++;
            }
        }
        int ans1 = Math.abs(x);
        int ans2 = Math.abs(y);
        return ans1+ans2+space;
    }
}