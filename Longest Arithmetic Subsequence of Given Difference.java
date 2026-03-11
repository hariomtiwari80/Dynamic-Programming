class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if((arr[i]-arr[j])==diff){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

-----------------------------------------------------------------

class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(map.containsKey(num-diff)){
                map.put(num,map.get(num-diff)+1);
            }
            else map.put(num,1);
            ans=Math.max(ans,map.get(num));
        }
        return ans;
    }
}
