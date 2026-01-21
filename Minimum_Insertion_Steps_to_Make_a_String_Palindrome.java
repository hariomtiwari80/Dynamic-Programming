class Solution {
    public int minInsertions(String s) {
        if(s.length()==1) return 0;
        return find(s,0,s.length()-1);
    }
    public int find(String s,int i,int j){
        if(i>=j) return 0;
        if(s.charAt(i)==s.charAt(j)) return find(s,i+1,j-1);
        else{
            int l=1+find(s,i,j-1);
            int r=1+find(s,i+1,j);
            return Math.min(l,r);
        }
    }
}
----------------------------------------------------------------

class Solution {
    public int minInsertions(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        if(s.length()==1) return 0;
        return find(s,0,s.length()-1,dp);
    }
    public int find(String s,int i,int j,int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return find(s,i+1,j-1,dp);
        else{
            int l=1+find(s,i,j-1,dp);
            int r=1+find(s,i+1,j,dp);
            return dp[i][j]=Math.min(l,r);
        }
    }
}
