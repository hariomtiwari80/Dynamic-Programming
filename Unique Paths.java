class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(0,0,m,n,dp);
    }
    public int solve(int i,int j,int m,int n,int[][] dp){
        if(i==m-1 || j==n-1) return 1;
        if(i<0 || j<0 || i>m-1 || j>n-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int r=solve(i,j+1,m,n,dp);
        int d=solve(i+1,j,m,n,dp);
        return dp[i][j]=r+d;
    }
}

----------------------------------------------------------------

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 || j==n-1) dp[i][j]=1;
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                } 
            }
        }
        return dp[0][0];
    }
}
