class Solution {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        Integer[][] dp=new Integer[arr.length][arr.length+1]; 
        return find(arr,0,1,dp);
    }
    public int find(int[] arr,int i,int size,Integer[][] dp){
        if(i==arr.length) return 0; 
        if(dp[i][size]!=null) return dp[i][size];
        int skip=find(arr,i+1,size,dp);
        int take=arr[i]*size+find(arr,i+1,size+1,dp);
        return dp[i][size]=Math.max(take,skip);
    }
}
