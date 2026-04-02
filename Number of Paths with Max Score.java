class Solution {
    int n,m;
    public int mod=1000000007; 
    public int[] pathsWithMaxScore(List<String> l) {
        n=l.size();
        m=l.get(0).length();
        int[][] dp=new int[n][m];
        int[][] way=new int[n][m];
        way[0][0]=1;
        int b=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=l.get(i).charAt(j);
                if(ch=='E' || ch=='X') continue;
                int max=Integer.MIN_VALUE,c=0;
                if(j>0 && l.get(i).charAt(j-1)!='X'){
                    if(dp[i][j-1]>max){
                        max=Math.max(max,dp[i][j-1]);
                        c=way[i][j-1];
                    }
                    else if(dp[i][j-1]==max){
                        c=(c+way[i][j-1])%mod;
                    }
                }
                if(j>0 && i>0 && l.get(i-1).charAt(j-1)!='X'){
                   if(dp[i-1][j-1]>max){
                        max=Math.max(max,dp[i-1][j-1]);
                        c=way[i-1][j-1];
                    }
                    else if(dp[i-1][j-1]==max){
                        c=(c+way[i-1][j-1])%mod;
                    }
                }
                if(i>0 && l.get(i-1).charAt(j)!='X'){
                    if(dp[i-1][j]>max){
                        max=Math.max(max,dp[i-1][j]);
                        c=way[i-1][j];
                    }
                    else if(dp[i-1][j]==max){
                        c=(c+way[i-1][j])%mod;
                    }
                }
                if(max==Integer.MIN_VALUE){
                    dp[i][j]=max;
                    way[i][j]=0;
                }
                else{
                    if(i==n-1 && j==m-1){
                        dp[i][j]=max;
                        way[i][j]=c;
                    }
                    else{
                        dp[i][j]=ch-'0'+max;
                        way[i][j]=c;
                    }
                }
            }
        }
        if(dp[n-1][m-1]==Integer.MIN_VALUE) return new int[]{0,0};
        return new int[]{dp[n-1][m-1],way[n-1][m-1]};
    }
}
