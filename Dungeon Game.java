class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        int[][] dp=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    if(arr[i][j]>=0) dp[i][j]=1;
                    else dp[i][j]=Math.abs(arr[i][j])+1;
                }
                else{
                    int r=Integer.MAX_VALUE;
                    int d=Integer.MAX_VALUE;
                    if(j<m-1){
                        r=dp[i][j+1]-arr[i][j];
                    }
                    if(i<n-1){
                        d=dp[i+1][j]-arr[i][j];
                    }
                    int res=Math.min(r,d);
                    if(res<=0) dp[i][j]=1;
                    else dp[i][j]=res;
                }
            }
        }
        return dp[0][0];
    }
}
