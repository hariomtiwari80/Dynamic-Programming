class Solution {
    public boolean isMatch(String s, String p) {
        return find(s,p,0,0);
    }
    public boolean find(String s,String p,int i,int j){
        if(j==p.length()) return i==s.length();
        if(i==s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
            b=true;
        }
        boolean ans;
        if(p.charAt(j)=='*'){
            boolean skip=find(s,p,i,j+1);
            boolean take=find(s,p,i+1,j);
            ans=take || skip;
        }
        else ans=b && find(s,p,i+1,j+1);
        return ans;
    }
}

---------------------------------------------------------------------------------------

class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String,Boolean> dp=new HashMap<>();
        return find(s,p,0,0,dp);
    }
    public boolean find(String s,String p,int i,int j,HashMap<String,Boolean> dp){
        if(j==p.length()) return i==s.length();
        if(i==s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        String t=i+","+j;
        if(dp.containsKey(t)) return dp.get(t);
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
            b=true;
        }
        boolean ans;
        if(p.charAt(j)=='*'){
            boolean skip=find(s,p,i,j+1,dp);
            boolean take=find(s,p,i+1,j,dp);
            ans=take || skip;
        }
        else ans=b && find(s,p,i+1,j+1,dp);
        dp.put(t,ans);
        return ans;
    }
}

----------------------------------------------------------------------------------

class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return find(s,p,0,0,dp);
    }
    public boolean find(String s,String p,int i,int j,Boolean[][] dp){
        if(j==p.length()) return i==s.length();
        if(i==s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
            b=true;
        }
        boolean ans;
        if(p.charAt(j)=='*'){
            boolean skip=find(s,p,i,j+1,dp);
            boolean take=find(s,p,i+1,j,dp);
            ans=take || skip;
        }
        else ans=b && find(s,p,i+1,j+1,dp);
        return dp[i][j]=ans;
    }
}

---------------------------------------------------------------------------------

