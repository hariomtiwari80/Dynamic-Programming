class Solution {
    public int m,n;
    public Long[][][] dp;
    public int maxProductPath(int[][] arr) {
        m=arr.length;
        n=arr[0].length;
        dp=new Long[m+1][n+1][2];
        long[] res=solve(arr,0,0);
        if(res[0]<0) return -1;
        return (int)(res[0]%1000000007);
    }
    public long[] solve(int[][] arr,int i,int j){
        if(i==m-1 && j==n-1) return new long[]{arr[i][j],arr[i][j]};
        if(dp[i][j][0]!=null && dp[i][j][1]!=null) return new long[]{dp[i][j][0],dp[i][j][1]};
        long max=Long.MIN_VALUE,min=Long.MAX_VALUE;
        if(i<m-1){
            long[] d=solve(arr,i+1,j);
            long a=arr[i][j]*d[0],b=arr[i][j]*d[1];
            max=Math.max(max,Math.max(a,b));
            min=Math.min(min,Math.min(a,b));
        }
        if(j<n-1){
            long[] r=solve(arr,i,j+1);
            long a=arr[i][j]*r[0],b=arr[i][j]*r[1];
            max=Math.max(max,Math.max(a,b));
            min=Math.min(min,Math.min(a,b));
        }
        dp[i][j][0]=max;
        dp[i][j][1]=min;
        return new long[]{max,min};
    }
}

--------------------------------------------------------------------------------------------------------------

