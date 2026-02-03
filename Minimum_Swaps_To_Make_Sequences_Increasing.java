class Solution {
    public int minSwap(int[] arr1, int[] arr2) {
        int n=arr1.length;
        if(n<2) return 0;
        int[][] dp=new int[n+1][2];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int c1=find(arr1,arr2,1,0,dp);
        int c2=1+find(arr1,arr2,1,1,dp);
        return Math.min(c1,c2);
    }
    public int find(int[] arr1,int[] arr2,int i,int b,int[][] dp){
        if(i==arr1.length) return 0;
        if(dp[i][b]!=-1) return dp[i][b];
        int swap=Integer.MAX_VALUE;
        int noswap=Integer.MAX_VALUE;
        int pre1=0,pre2=0;
        if(b==1){
            pre1=arr2[i-1];
            pre2=arr1[i-1];
        }
        else{
            pre1=arr1[i-1];
            pre2=arr2[i-1];
        }
        if(arr1[i]>pre2 && arr2[i]>pre1) swap=1+find(arr1,arr2,i+1,1,dp);
        if(arr1[i]>pre1 && arr2[i]>pre2) noswap=find(arr1,arr2,i+1,0,dp);
        return dp[i][b]=Math.min(swap,noswap);
    }
}
