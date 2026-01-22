class Solution {
    public int maxDotProduct(int[] arr1, int[] arr2) {
        return find(arr1,arr2,0,0);
    }
    public int find(int[] arr1,int[] arr2,int i,int j){
        if(i==arr1.length || j==arr2.length) return Integer.MIN_VALUE;
        int take=arr1[i]*arr2[j];
        int next=find(arr1,arr2,i+1,j+1);
        if(next!=Integer.MIN_VALUE) take=Math.max(take,take+next);
        int skip1=find(arr1,arr2,i,j+1);
        int skip2=find(arr1,arr2,i+1,j);
        return Math.max(take,Math.max(skip1,skip2));
    }
}

---------------------------------------------------------------------------------

class Solution {
    public int maxDotProduct(int[] arr1, int[] arr2) {
        int[][] dp=new int[arr1.length][arr2.length];
        for(int[] a:dp) Arrays.fill(a,-1);
        return find(arr1,arr2,0,0,dp);
    }
    public int find(int[] arr1,int[] arr2,int i,int j,int[][] dp){
        if(i==arr1.length || j==arr2.length) return Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int take=arr1[i]*arr2[j];
        int next=find(arr1,arr2,i+1,j+1,dp);
        if(next!=Integer.MIN_VALUE) take=Math.max(take,take+next);
        int skip1=find(arr1,arr2,i,j+1,dp);
        int skip2=find(arr1,arr2,i+1,j,dp);
        return dp[i][j]=Math.max(take,Math.max(skip1,skip2));
    }
}
