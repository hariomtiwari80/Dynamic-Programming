class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(arr,0,0,dp);
    }
    public int solve(int[][] arr,int i,int j,int[][] dp){
        int m=arr.length,n=arr[0].length;
        if(i<0 || j<0 || i>m-1 || j>n-1) return 0;
        if(arr[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int r=solve(arr,i,j+1,dp);
        int d=solve(arr,i+1,j,dp);
        return dp[i][j]=r+d;
    }
}
