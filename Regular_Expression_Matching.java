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

