class Solution {
    public int maxMoves(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        int[][] dp=new int[n][m];
        int ans=0;
        for(int j=m-2;j>=0;j--){
            for(int i=n-1;i>=0;i--){
                int max=0;
                if(i>0 && arr[i][j]<arr[i-1][j+1]){
                    max=Math.max(max,1+dp[i-1][j+1]);
                }
                if(i<n-1 && arr[i][j]<arr[i+1][j+1]){
                    max=Math.max(max,1+dp[i+1][j+1]);
                }
                if(arr[i][j]<arr[i][j+1]) max=Math.max(max,1+dp[i][j+1]);
                dp[i][j]=max;
            }
        }
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dp[i][0]);
        }
        return ans;
    }
}
