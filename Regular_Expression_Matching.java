class Solution {
    public boolean isMatch(String s, String p) {
        return call(s,p,0,0);
    }
    public boolean call(String s,String p,int i,int j){
        if (j==p.length()) {
            return i==s.length();
        }
    
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
            b=true;
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean skip=call(s,p,i,j+2);
            boolean take=false;
            if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
                take=call(s,p,i+1,j);
            }
            return take || skip;
        }
        return b && call(s,p,i+1,j+1);
    }
}

-----------------------------------------------------------------------------------------

class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String,Boolean> dp=new HashMap<>();
        return solve(s,p,0,0,dp);
    }
    public boolean solve(String s,String p,int i,int j,HashMap<String,Boolean> dp){
        if(j==p.length()){
            return i==s.length();
        }
        String t=i+","+j;
        if(dp.containsKey(t)) return dp.get(t);
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) b=true;
        boolean ans;
        if(j<p.length()-1 && p.charAt(j+1)=='*'){
            boolean skip=solve(s,p,i,j+2,dp);
            boolean take=false;
            if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
                take=solve(s,p,i+1,j,dp);
            }
            ans=take || skip;
        }
        else ans = b && solve(s,p,i+1,j+1,dp);
        dp.put(t,ans);
        return ans;
    }
}
