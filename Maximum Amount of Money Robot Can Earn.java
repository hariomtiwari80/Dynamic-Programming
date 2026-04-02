class Solution {
    public int n,m;
    Integer[][][] dp;
    public int maximumAmount(int[][] arr) {
        n=arr.length;
        m=arr[0].length;
        dp=new Integer[n+1][m+1][3];
        return solve(arr,0,0,0);
    }
    public int solve(int[][] arr,int i,int j,int neu){
        if(i>n-1 || j>m-1) return Integer.MIN_VALUE;
        if(dp[i][j][neu]!=null) return dp[i][j][neu];
        if(i==n-1 && j==m-1){
            if(arr[i][j]<0 && neu<2) return 0;
            else return arr[i][j]; 
        }
        int t=Integer.MIN_VALUE;
        if(arr[i][j]<0){
            if(i<n-1) t=Math.max(t,arr[i][j]+solve(arr,i+1,j,neu));
            if(j<m-1) t=Math.max(t,arr[i][j]+solve(arr,i,j+1,neu));
            if(neu<2){
                if(i<n-1) t=Math.max(t,solve(arr,i+1,j,neu+1));
                if(j<m-1) t=Math.max(t,solve(arr,i,j+1,neu+1));
            }
        }
        else{
            if(i<n-1) t=Math.max(t,arr[i][j]+solve(arr,i+1,j,neu));
            if(j<m-1) t=Math.max(t,arr[i][j]+solve(arr,i,j+1,neu));
        }
        return dp[i][j][neu]=t;
    }
}
