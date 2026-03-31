class Solution {
    public int m,n;
    public Integer[][] dp;
    public int minimumOperations(int[][] arr) {
        m=arr.length;
        n=arr[0].length;
        dp=new Integer[n][15];
        return solve(arr,0,-1);
    }
    public int solve(int[][] arr,int i,int pre){
        if(i==n) return 0;
        if(dp[i][pre+1]!=null) return dp[i][pre+1];
        int min=Integer.MAX_VALUE;
        for(int j=0;j<=9;j++){
            if(j==pre) continue;
            int c=0;
            for(int k=0;k<m;k++){
                if(arr[k][i]!=j) c++;
            }
            min=Math.min(min,c+solve(arr,i+1,j));
        }
        return dp[i][pre+1]=min;
    }
}
