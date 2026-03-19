class Solution {
    public int minimumCoins(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            int l=i+1,h=Math.min(n,2*i+2);
            while(l<=h){
                min=Math.min(min,dp[l]);
                l++;
            }
            dp[i]=arr[i]+min;
        }
        return dp[0];
    }
}
