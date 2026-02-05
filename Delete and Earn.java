class Solution {
    public int deleteAndEarn(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int max=0;
        for(int x:arr) max=Math.max(max,x);
        int[] val=new int[max+1];
        for(int x:arr){
            val[x]+=x;
        }
        int[] dp=new int[max+1];
        dp[0]=val[0];
        dp[1]=Math.max(val[0],val[1]);
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],val[i]+dp[i-2]);
        }
        return dp[max];
    }
}
