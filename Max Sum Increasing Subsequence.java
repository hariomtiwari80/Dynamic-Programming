class Solution {
    public int maxSumIS(int arr[]) {
        int n=arr.length;
        int[] dp=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(dp[j]+arr[i]>dp[i]){
                        dp[i]=dp[j]+arr[i];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
