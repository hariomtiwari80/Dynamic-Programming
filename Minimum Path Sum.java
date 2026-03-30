class Solution {
    public int minPathSum(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(arr,0,0,m,n,dp);
    }
    public int solve(int[][] arr,int i,int j,int m,int n,int[][] dp){
        if(i==m-1 && j==n-1) return arr[m-1][n-1];
        if(dp[i][j]!=-1) return dp[i][j];
        int r=Integer.MAX_VALUE,d=Integer.MAX_VALUE;
        if(j<n-1) r=arr[i][j]+solve(arr,i,j+1,m,n,dp);
        if(i<m-1) d=arr[i][j]+solve(arr,i+1,j,m,n,dp);
        return dp[i][j]=Math.min(r,d);
    }
}
