class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int[] dp=new int[n+1];
        dp[1]=10;
        for(int i=2;i<=n;i++){
            int t=9;
            int c=9;
            for(int j=1;j<i;j++){
                t*=c;
                c--;
            }
            dp[i]=dp[i-1]+t;
        }
        return dp[n];
    }
}
