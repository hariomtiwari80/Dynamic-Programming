class Solution {
    public int n,m;
    public Integer[][][] dp;
    public int cherryPickup(int[][] arr) {
        n=arr.length;
        m=arr[0].length;
        dp=new Integer[n+1][m+1][m+1];
        return solve(arr,0,0,m-1);
    }
    public int solve(int[][] arr,int r,int c1,int c2){
        if(r>n-1 || c1>m-1 || c2>m-1 || c1<0 || c2<0) return Integer.MIN_VALUE;
        if(r==n-1){
            if(c1==c2) return arr[r][c1];
            else return arr[r][c1]+arr[r][c2];
        }
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];
        int cherry=0;
        if(c1==c2) cherry=arr[r][c1];
        else cherry=arr[r][c1]+arr[r][c2];
        int max=Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                max=Math.max(max,solve(arr,r+1,c1+i,c2+j));
            }
        }
        if(max==Integer.MIN_VALUE) {
            return dp[r][c1][c2]=Integer.MIN_VALUE;
        }
        cherry+=max;
        return dp[r][c1][c2]=cherry;
    }
}
