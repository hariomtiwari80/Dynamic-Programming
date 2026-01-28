class Solution {
    public int countTexts(String s) {
        long[] dp=new long[s.length()+1];
        Arrays.fill(dp,-1);
        return (int)solve(s,0,dp);
    }
    public long solve(String s,int i,long[] dp){
        if(i==s.length()) return 1;
        if(dp[i]!=-1) return dp[i];
        long one=solve(s,i+1,dp)%1_000_000_007;
        long two=0,three=0,four=0;
        if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) two=solve(s,i+2,dp)%1_000_000_007;
        if(i+2<s.length() && s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2)) three=solve(s,i+3,dp)%1_000_000_007;
        if((s.charAt(i)=='7' || s.charAt(i)=='9') && i+3<s.length() && s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2) && s.charAt(i+2)==s.charAt(i+3)) four=solve(s,i+4,dp)%1_000_000_007;
        return dp[i]=(one+two+three+four)%1_000_000_007;
    }
}
