class Solution {
    public int MOD = 1000000007;
    int[][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp=new int[group.length+1][n+1][minProfit+1];
        for(int i=0;i<=group.length;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=minProfit;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return call(n,minProfit,group,profit,0);
    }

    public int call(int n,int minpro,int[] group,int[] profit,int i){
        if(n<0) return 0;
        if(i==group.length){
            if(minpro<=0) return 1;
            return 0;
        }
        minpro=Math.max(minpro,0);
        if(dp[i][n][minpro]!=-1) return dp[i][n][minpro];
        int take=call(n-group[i],minpro-profit[i],group,profit,i+1);
        int skip=call(n,minpro,group,profit,i+1);
        dp[i][n][minpro]=(take+skip)%MOD;
        return dp[i][n][minpro];
    }
}
