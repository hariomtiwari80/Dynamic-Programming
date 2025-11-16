class Solution {
    public int change(int amount, int[] arr) {
        return call(arr,amount,0);
    }
    public int call(int[] arr,int amt,int i){
        if(amt<0 || i>=arr.length) return 0;
        if(amt==0){
            return 1;
        }
        int take=call(arr,amt-arr[i],i);
        int skip=call(arr,amt,i+1);
        return take+skip;
    }
}

----------------------------------------------------------

class Solution {
    public int change(int amount, int[] arr) {
        int[][] dp=new int[arr.length][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return call(arr,amount,0,dp);
    }
    public int call(int[] arr,int amt,int i,int[][] dp){
        if(amt<0 || i>=arr.length) return 0;
        if(amt==0){
            return 1;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        int take=call(arr,amt-arr[i],i,dp);
        int skip=call(arr,amt,i+1,dp);
        return dp[i][amt]=take+skip;
    }
}
