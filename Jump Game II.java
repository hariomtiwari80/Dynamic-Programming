class Solution {
    public int jump(int[] arr) {
        Integer[] dp=new Integer[arr.length];
        return call(arr,0,dp);
    }
    public int call(int[] arr,int i,Integer[] dp){
        if(i>=arr.length-1) return 0;
        if(arr[i]==0) return Integer.MAX_VALUE/2;
        if(dp[i]!=null) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=arr[i];j++){
            int t=1+call(arr,i+j,dp);
            min=Math.min(min,t);
        }
        return dp[i]=min;
    }
}
