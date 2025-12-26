class Solution {
    public int max=1;
    public int longestPalindromeSubseq(String s) {
        call(s,0,"");
        return max;
    }
    public void call(String s,int i,String t){
        if(i==s.length()){
            if(pali(t) && t.length()>max) max=t.length();
            return;
        }
        call(s,i+1,t+s.charAt(i));
        call(s,i+1,t);
    }
    public boolean pali(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

-----------------------------------------------------------------------

class Solution {
    public int longestPalindromeSubseq(String s) {
        return call(s,0,s.length()-1);
    }
    public int call(String s,int i,int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j)) return 2+call(s,i+1,j-1);
        else{
            return Math.max(call(s,i+1,j),call(s,i,j-1));
        }
    }
}

----------------------------------------------------------------------------

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return call(s,0,s.length()-1,dp);
    }
    public int call(String s,int i,int j,int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return 2+call(s,i+1,j-1,dp);
        else{
            return dp[i][j]=Math.max(call(s,i+1,j,dp),call(s,i,j-1,dp));
        }
    }
}

-----------------------------------------------------------------------------------

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        int max=1;
        for(int j=1;j<n;j++){
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=2+dp[i+1][j-1];
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
