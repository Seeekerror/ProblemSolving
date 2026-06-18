class Solution {
    public double angleClock(int hour, int minutes) {
        double hrmin = 60.0/minutes;
        double hormin = (5.0/hrmin)+(hour*5);
        double ans = Math.abs(minutes-hormin)*6;
        return Math.min(ans,360-ans);
    }
}