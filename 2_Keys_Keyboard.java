class Solution {
    public int minSteps(int n) {
        if(n<2) return 0;
        return 1+call(n,1,1);
    }
    public int call(int n,int curr,int clip){
        if(curr==n) return 0;
        if(curr>n) return 10000;
        int copypaste=2+call(n,curr+curr,curr);
        int paste=1+call(n,curr+clip,clip);
        return Math.min(copypaste,paste);
    }
}

----------------------------------------------------------

class Solution {
    public int minSteps(int n) {
        if(n<2) return 0;
        Integer[][] dp=new Integer[n+1][n+1];
        return 1+call(n,1,1,dp);
    }
    public int call(int n,int curr,int clip,Integer[][] dp){
        if(curr==n) return 0;
        if(curr>n) return 10000;
        if(dp[curr][clip]!=null) return dp[curr][clip];
        int copypaste=2+call(n,curr+curr,curr,dp);
        int paste=1+call(n,curr+clip,clip,dp);
        return dp[curr][clip]=Math.min(copypaste,paste);
    }
}
