class Solution {
    public String longestPalindrome(String s) {
        return find(s,0,s.length()-1);
    }
    public String find(String s,int i,int j){
        if(i==j) return s.substring(i,j+1);
        if(i<j && pali(i,j,s)) return s.substring(i,j+1);
        else{
            String s1=find(s,i+1,j);
            String s2=find(s,i,j-1);
            if(s1.length()>s2.length()) return s1;
            else return s2;
        } 
    }
    public boolean pali(int i,int j,String s){
        int l=i,h=j;
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}

---------------------------------------------------------------------

class Solution {
    public String longestPalindrome(String s) {
        String[][] dp=new String[s.length()][s.length()];
        return find(s,0,s.length()-1,dp);
    }
    public String find(String s,int i,int j,String[][] dp){
        if(i==j) return s.substring(i,j+1);
        if(dp[i][j]!=null) return dp[i][j];
        if(i<j && pali(i,j,s)) return s.substring(i,j+1);
        else{
            String s1=find(s,i+1,j,dp);
            String s2=find(s,i,j-1,dp);
            if(s1.length()>s2.length()) return dp[i][j]=s1;
            else return dp[i][j]=s2;
        } 
    }
    public boolean pali(int i,int j,String s){
        int l=i,h=j;
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}

------------------------------------------------------------------------------

