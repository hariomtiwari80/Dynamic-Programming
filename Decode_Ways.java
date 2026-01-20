class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        return solve(s,0);
    }
    public int solve(String s,int i){
        if(i==s.length()) return 1;
        int one=0,two=0;
        if(s.charAt(i)!='0') one=solve(s,i+1);
        if(i+1<s.length() && s.charAt(i)!='0' && Integer.parseInt(s.substring(i,i+2))<27) two=solve(s,i+2);
        return one+two; 
    }
}

------------------------------------------------------------------------------------------------------------------

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,dp);
    }
    public int solve(String s,int i,int[] dp){
        if(i==s.length()) return 1;
        if(dp[i]!=-1) return dp[i];
        int one=0,two=0;
        if(s.charAt(i)!='0') one=solve(s,i+1,dp);
        if(i+1<s.length() && s.charAt(i)!='0' && Integer.parseInt(s.substring(i,i+2))<27) two=solve(s,i+2,dp);
        return dp[i]=one+two; 
    }
}
