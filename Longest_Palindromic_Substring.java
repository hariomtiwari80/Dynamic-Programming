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

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0;
        int len = 1;

        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (s.charAt(left) != s.charAt(right)) continue;

                if (isPalin(s, left, right)) {
                    if (right - left + 1 > len) {
                        len = right - left + 1;
                        start = left;
                    }
                }
            }
        }
        return s.substring(start, start + len);
    }

    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

--------------------------------------------------------------------------------------------

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxlen=1,start=0;
        for(int i=0;i<n;i++){
            int even=expand(s,i,i);
            int odd=expand(s,i,i+1);
            int max=Math.max(even,odd);
            if(max>maxlen){
                maxlen=max;
                start=i-(max-1)/2;
            }
        }
        return s.substring(start,start+maxlen);
    }
    public int expand(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
