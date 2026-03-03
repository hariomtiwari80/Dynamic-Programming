class Solution {
    public List<String> getWordsInLongestSubsequence(String[] s, int[] arr) {
        int n=s.length;
        int[] dp=new int[n];
        int[] id=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(id,-1);
        int max=0;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]!=arr[j] && check(s[i],s[j])){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        id[i]=j;
                    }
                }
            }
            if(dp[max]<dp[i]) max=i;
        }
        List<String> ans=new ArrayList<>();
        while(max!=-1){
            ans.add(s[max]);
            max=id[max];
        }
        Collections.reverse(ans);
        return ans;
    }
    public boolean check(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int ham=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) ham++;
            if(ham>1) return false;
        }
        return ham==1;
    }
}
