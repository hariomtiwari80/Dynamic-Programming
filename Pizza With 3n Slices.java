class Solution {
    public int maxSizeSlices(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int pick=n/3;
        return Math.max(find(arr,0,n-2,pick),find(arr,1,n-1,pick));
    }
    public int find(int[] arr,int i,int j,int pick){
        if(pick==0 || i>j) return 0;
        int skip=find(arr,i+1,j,pick); 
        int take=arr[i]+find(arr,i+2,j,pick-1);
        return Math.max(take,skip);
    }
}

----------------------------------------------------------------------------

class Solution {
    public int maxSizeSlices(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int pick=n/3;
        int[][] dp1=new int[arr.length][pick+1];
        int[][] dp2=new int[arr.length][pick+1];
        for(int[] a:dp1) Arrays.fill(a,-1);
        for(int[] a:dp2) Arrays.fill(a,-1);
        return Math.max(find(arr,0,n-2,pick,dp1),find(arr,1,n-1,pick,dp2));
    }
    public int find(int[] arr,int i,int j,int pick,int[][] dp){
        if(pick==0 || i>j) return 0;
        if(dp[i][pick]!=-1) return dp[i][pick];
        int skip=find(arr,i+1,j,pick,dp); 
        int take=arr[i]+find(arr,i+2,j,pick-1,dp);
        return dp[i][pick]=Math.max(take,skip);
    }
}
