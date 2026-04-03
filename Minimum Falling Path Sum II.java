class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=arr[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=0;k<n;k++){
                    if(k==j) continue;
                    min=Math.min(min,dp[i-1][k]);
                }
                dp[i][j]=arr[i][j]+min;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}
