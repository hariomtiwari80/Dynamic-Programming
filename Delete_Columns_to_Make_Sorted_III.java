class Solution {
    public int minDeletionSize(String[] arr) {
        int keep=solve(arr,-1,0);
        return arr[0].length()-keep;
    }
    public int solve(String[] arr,int pre,int i){
        if(i==arr[0].length()) return 0;
        int take=0;
        if(pre==-1 || valid(arr,pre,i)) take=1+solve(arr,i,i+1);
        int skip=solve(arr,pre,i+1);
        return Math.max(take,skip);
    }
    public boolean valid(String[] arr,int pre,int j){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].charAt(pre)>arr[i].charAt(j)) return false;
        }
        return true;
    }
}

-----------------------------------------------------------------------------

class Solution {
    public int minDeletionSize(String[] arr) {
        int[][] dp=new int[arr[0].length()+1][arr[0].length()];
        for(int[] a:dp) Arrays.fill(a,-1);
        int keep=solve(arr,-1,0,dp);
        return arr[0].length()-keep;
    }
    public int solve(String[] arr,int pre,int i,int[][] dp){
        if(i==arr[0].length()) return 0;
        if(dp[pre+1][i]!=-1) return dp[pre+1][i];
        int take=0;
        if(pre==-1 || valid(arr,pre,i)) take=1+solve(arr,i,i+1,dp);
        int skip=solve(arr,pre,i+1,dp);
        return dp[pre+1][i]=Math.max(take,skip);
    }
    public boolean valid(String[] arr,int pre,int j){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].charAt(pre)>arr[i].charAt(j)) return false;
        }
        return true;
    }
}

-------------------------------------------------------------------------------

class Solution {
    public int minDeletionSize(String[] arr) {
        int n =arr[0].length();
        if(n==1) return 0;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(check(arr,j,i)){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return n-max;
    }
    public boolean check(String[] arr,int pre,int j){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].charAt(pre)>arr[i].charAt(j)) return false;
        }
        return true;
    }
}
