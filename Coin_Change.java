class Solution {
    public int coinChange(int[] arr, int amount) {
        int n=find(arr,amount);
        if(n!=Integer.MAX_VALUE) return n;
        return -1;
    }
    public int find(int[] arr,int amt){
        if(amt==0) return 0;
        if(amt<0) return Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int t=find(arr,amt-arr[i]);
            if(t!=Integer.MAX_VALUE){
                min=Math.min(min,1+t);
            }
        }
        return min;
    }
}

-------------------------------------------------------

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int n=call(coins,amount,dp);
        if(n==Integer.MAX_VALUE) return -1;
        return n;
    }
    public int call(int[] arr,int amt,int[] dp){
        if(amt==0) return 0;
        if(amt<0) return Integer.MAX_VALUE;
        if(dp[amt]!=-1) return dp[amt];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int take=call(arr,amt-arr[i],dp);
            if(take!=Integer.MAX_VALUE){
                min=Math.min(min,take+1);
            }
        }
        return dp[amt]=min;
    }
}

-------------------------------------------

class Solution {
    public int coinChange(int[] arr, int amt) {
        if(amt==0) return 0;
        Arrays.sort(arr);
        int[] dp=new int[amt+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=amt;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<arr.length;j++){
                if(i<arr[j]) break;
                int k=i-arr[j];
                if(dp[k]!=-1){
                    min=Math.min(min,dp[k]+1);
                }
            }
            if(min!=Integer.MAX_VALUE) dp[i]=min;
        }
        return dp[amt];
    }
}
