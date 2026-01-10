class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        return call(0,W,val,wt);
    }                         
    public int call(int i,int w,int[] val,int[] wt){
        if(i==val.length || w==0) return 0;
        if(wt[i]>w) return call(i+1,w,val,wt);
        int take=val[i]+call(i+1,w-wt[i],val,wt);
        int skip=call(i+1,w,val,wt);
        return Math.max(take,skip);
    }
}

------------------------------------------------------------

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp=new int[val.length][W+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return call(val.length-1,W,val,wt,dp);
    }                         
    public int call(int i,int w,int[] val,int[] wt,int[][] dp){
        if(i<0 || w==0) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        if(wt[i]>w) return dp[i][w]=call(i-1,w,val,wt,dp);
        int take=val[i]+call(i-1,w-wt[i],val,wt,dp);
        int skip=call(i-1,w,val,wt,dp);
        return dp[i][w]=Math.max(take,skip);
    }
}

-----------------------------------------------------------------

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(j==0) dp[i][j]=0;
                else if(j<wt[i-1]) dp[i][j]=dp[i-1][j];
                else{
                    int take=val[i-1]+dp[i-1][j-wt[i-1]];
                    int skip=dp[i-1][j];
                    dp[i][j]=Math.max(take,skip);
                }
            }
        }
        return dp[n][W];
    } 
}
