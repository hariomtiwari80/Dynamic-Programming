class Solution {
    public int maximumLength(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[2][n];
        for(int[] a:dp) Arrays.fill(a,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int mod=(arr[i]+arr[j])%2;
                dp[mod][i]=Math.max(dp[mod][i],dp[mod][j]+1);
                ans=Math.max(ans,dp[mod][i]);
            }
        }
        return ans;
    }
}

--------------------------------------------------------------------

class Solution {
    public int maximumLength(int[] arr) {
        int n=arr.length;
        int even=0,odd=0;
        for(int x:arr){
            if(x%2==0) even++;
            else odd++;
        }
        int ev=0,od=0;
        for(int x:arr){
            if(x%2==0) ev=Math.max(ev,od+1);
            else od=Math.max(od,ev+1);
        }
        return Math.max(Math.max(even,odd),Math.max(ev,od));
    }
}
