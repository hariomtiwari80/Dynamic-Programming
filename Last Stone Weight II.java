class Solution {
    public int lastStoneWeightII(int[] arr) {
        int sum=0;
        for(int x:arr) sum+=x;
        int tar=sum/2;
        Integer[][] dp=new Integer[arr.length][tar+1];
        int h=solve(arr,0,0,tar,dp);
        int l=sum-h;
        return l-h;
    }
    public int solve(int[] arr,int i,int curr,int tar,Integer[][] dp){
        if(curr>tar) return Integer.MIN_VALUE;
        if(i==arr.length) return curr;
        if(dp[i][curr]!=null) return dp[i][curr];
        int take=solve(arr,i+1,curr+arr[i],tar,dp);
        int skip=solve(arr,i+1,curr,tar,dp);
        return dp[i][curr]=Math.max(take,skip);
    }
}
