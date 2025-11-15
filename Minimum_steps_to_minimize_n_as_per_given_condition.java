class Solution {

    public int minSteps(int N) {
        return call(N);
    }
    public int call(int n){
        if(n==1) return 0;
        int minus=1+call(n-1);
        int two=Integer.MAX_VALUE,three=Integer.MAX_VALUE;
        if(n%2==0){
            two=1+call(n/2);
        }
        if(n%3==0){
            three=1+call(n/3);
        }
        return Math.min(Math.min(minus,two),three);
    }
}


--------------------------------------------------------------------

  class Solution {

    public int minSteps(int N) {
        int[] dp=new int[N+1];
        Arrays.fill(dp,-1);
        return call(N,dp);
    }
    public int call(int n,int[] dp){
        if(n==1) return 0;
        if(dp[n]!=-1) return dp[n];
        int minus=1+call(n-1,dp);
        int two=Integer.MAX_VALUE,three=Integer.MAX_VALUE;
        if(n%2==0){
            two=1+call(n/2,dp);
        }
        if(n%3==0){
            three=1+call(n/3,dp);
        }
        return dp[n]=Math.min(Math.min(minus,two),three);
    }
}
