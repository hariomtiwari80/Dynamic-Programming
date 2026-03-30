class Solution {
    public int convertTime(String curr, String corr) {
        if(curr.equals(corr)) return 0;
        int currmin=Integer.parseInt(curr.substring(0,2))*60+Integer.parseInt(curr.substring(3,5));
        int corrmin=Integer.parseInt(corr.substring(0,2))*60+Integer.parseInt(corr.substring(3,5));
        int diff=corrmin - currmin;
        int ans=0;
        int[] steps={60,15,5,1};
        for (int step:steps) {
            ans+=diff/step;
            diff%=step;
        }
        return ans;
    }
}
