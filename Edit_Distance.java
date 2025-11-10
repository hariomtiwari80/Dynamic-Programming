class Solution {
    public int minDistance(String w1, String w2) {
        return find(w1,w2,0,0);
    }
    public int find(String s1,String s2,int i,int j){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(s1.charAt(i)==s2.charAt(j)){
            return find(s1,s2,i+1,j+1);
        }
        int insert=1+find(s1,s2,i,j+1);
        int delete=1+find(s1,s2,i+1,j);
        int replace=1+find(s1,s2,i+1,j+1);
        return Math.min(Math.min(insert,delete),replace);
    }
}

----------------------------------------------------------------

class Solution {
    public int minDistance(String w1, String w2) {
        int[][] dp=new int[w1.length()][w2.length()];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return find(w1,w2,0,0,dp);
    }
    public int find(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return find(s1,s2,i+1,j+1,dp);
        }
        int insert=1+find(s1,s2,i,j+1,dp);
        int delete=1+find(s1,s2,i+1,j,dp);
        int replace=1+find(s1,s2,i+1,j+1,dp);
        return dp[i][j]=Math.min(Math.min(insert,delete),replace);
    }
}

-------------------------------------------------------------------

class Solution {
    public int minDistance(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
            }
        }
        return dp[n][m];
    }
}
