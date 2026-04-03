class Solution {
    public Integer[][][] dp;
    public int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int r, int c) {
        dp=new Integer[m+1][n+1][maxMove+1];
        return solve(m,n,maxMove,r,c);
    }
    public int solve(int m,int n,int max,int i,int j){
        if(i<0 || j<0 || i>m-1 || j>n-1) return 1;
        if(max==0) return 0;
        if(dp[i][j][max]!=null) return dp[i][j][max];
        int t=0;
        t=(t+solve(m,n,max-1,i-1,j))%mod;
        t=(t+solve(m,n,max-1,i+1,j))%mod;
        t=(t+solve(m,n,max-1,i,j-1))%mod;
        t=(t+solve(m,n,max-1,i,j+1))%mod;
        return dp[i][j][max]=t;
    }
}
