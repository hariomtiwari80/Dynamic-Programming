class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        int[][] dp=new int[n][2];
        dp[0][0]=arr[0];
        dp[0][1]=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>dp[i-1][0]+arr[i]) dp[i][0]=arr[i];
            else dp[i][0]=dp[i-1][0]+arr[i];
            dp[i][1]=Math.max(dp[i-1][1],dp[i][0]);
        }
        return dp[n-1][1];
    }
}
