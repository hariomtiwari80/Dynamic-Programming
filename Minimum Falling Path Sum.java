class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=arr[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int ul=Integer.MAX_VALUE,ur=Integer.MAX_VALUE,u=Integer.MAX_VALUE;
                if(i>0){
                    u=dp[i-1][j];
                    if(j>0) ul=dp[i-1][j-1];
                    if(j<n-1) ur=dp[i-1][j+1];
                }
                dp[i][j]=arr[i][j]+Math.min(u,Math.min(ul,ur));
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}
