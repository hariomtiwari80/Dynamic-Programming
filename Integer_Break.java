class Solution {
    public int integerBreak(int n) {
        return solve(n);
    }
    public int solve(int n){
        if(n==1) return 1;
        int max=0;
        for(int k=1;k<n;k++){
            int b1=k*(n-k);
            int b2=k*solve(n-k);
            max=Math.max(max,Math.max(b1,b2));
        }
        return max;
    }
}

-------------------------------------------------------

class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int[] dp){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int max=0;
        for(int k=1;k<n;k++){
            int b1=k*(n-k);
            int b2=k*solve(n-k,dp);
            max=Math.max(max,Math.max(b1,b2));
        }
        return dp[n]=max;
    }
}
