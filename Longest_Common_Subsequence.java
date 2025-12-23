class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        return call(s1,s2,0,0);
    }
    public int call(String s1,String s2,int i,int j){
        if(i==s1.length() || j==s2.length()) return 0;
        if(s1.charAt(i)==s2.charAt(j)) return 1+call(s1,s2,i+1,j+1);
        else return Math.max(call(s1,s2,i+1,j),call(s1,s2,i,j+1));
    }
}

----------------------------------------------------------------------

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return call(s1,s2,0,0,dp);
    }
    public int call(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length() || j==s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 1+call(s1,s2,i+1,j+1,dp);
        else return dp[i][j]=Math.max(call(s1,s2,i+1,j,dp),call(s1,s2,i,j+1,dp));
    }
}

------------------------------------------------------------------------------------------

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
