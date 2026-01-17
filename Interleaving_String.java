class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length()!=s3.length()) return false;
        return find(s1,s2,s3,0,0,0);
    }
    public boolean find(String s1, String s2, String s3,int i,int j,int k){
        if(i==s1.length() && j==s2.length() && k==s3.length()) return true;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k) && (j>=s2.length() || s2.charAt(j)!=s3.charAt(k))){
            return find(s1,s2,s3,i+1,j,k+1);
        }
        else if(j<s2.length() && (i>=s1.length() || s1.charAt(i)!=s3.charAt(k)) &&  s2.charAt(j)==s3.charAt(k)){
            return find(s1,s2,s3,i,j+1,k+1);
        }
        else if(i<s1.length() && j<s2.length() && s1.charAt(i)==s3.charAt(k)){
            return find(s1,s2,s3,i+1,j,k+1) || find(s1,s2,s3,i,j+1,k+1);
        }
        return false;
    }
}

------------------------------------------------------------------------------------------------------------------

class Solution {
    Boolean[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return find(s1, s2, s3, 0, 0, 0);
    }

    public boolean find(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
        if (dp[i][j][k] != null) return dp[i][j][k];

        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)
                && (j >= s2.length() || s2.charAt(j) != s3.charAt(k))) {
            ans = find(s1, s2, s3, i + 1, j, k + 1);
        }

        else if (j < s2.length()
                && (i >= s1.length() || s1.charAt(i) != s3.charAt(k))
                && s2.charAt(j) == s3.charAt(k)) {
            ans = find(s1, s2, s3, i, j + 1, k + 1);
        }

        else if (i < s1.length() && j < s2.length()
                && s1.charAt(i) == s3.charAt(k)) {
            ans = find(s1, s2, s3, i + 1, j, k + 1)
               || find(s1, s2, s3, i, j + 1, k + 1);
        }

        return dp[i][j][k] = ans;
    }
}
