import java.util.*;

class Solution {

    public List<String> allLCS(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        HashSet<String> set = new HashSet<>();
        backtrack(s1, s2, 0, 0, dp, "", set);

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    void backtrack(String s1,String s2,int i,int j,int[][] dp,String cur,Set<String> set){

        if(i==s1.length() || j==s2.length()){
            if(cur.length()==dp[0][0]) set.add(cur);
            return;
        }

        if(s1.charAt(i)==s2.charAt(j)){
            backtrack(s1,s2,i+1,j+1,dp,cur+s1.charAt(i),set);
        }
        else{
            if(dp[i+1][j] >= dp[i][j+1])
                backtrack(s1,s2,i+1,j,dp,cur,set);

            if(dp[i][j+1] >= dp[i+1][j])
                backtrack(s1,s2,i,j+1,dp,cur,set);
        }
    }
}
