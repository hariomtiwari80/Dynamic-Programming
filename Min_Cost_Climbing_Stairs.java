class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int first=call(arr,0);
        int second=call(arr,1);
        return Math.min(first,second);
    }
    public int call(int[] arr,int i){
        if(i>=arr.length) return 0;
        return arr[i]+Math.min(call(arr,i+1),call(arr,i+2));
    }
}

----------------------------------------------------------------

class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int n=arr.length;
        int[] dp=new int[arr.length];
        dp[0]=arr[0];dp[1]=arr[1];
        for(int i=2;i<arr.length;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+arr[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
