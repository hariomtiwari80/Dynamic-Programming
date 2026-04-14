class Solution {
    public int maximalSquare(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        int max=-1;
        for(int i=0;i<m;i++){
            dp[0][i]=arr[0][i]-'0';
            max=Math.max(max,dp[0][i]);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='1'){
                    int u=-1,l=-1,ul=-1;
                    if(i>0) u=dp[i-1][j];
                    if(j>0){
                        l=dp[i][j-1];
                        ul=dp[i-1][j-1];
                    }
                    if(u==-1 || l==-1 || ul==-1){
                        dp[i][j]=1;
                    }
                    else dp[i][j]=Math.min(u,Math.min(l,ul))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;

    }
}
