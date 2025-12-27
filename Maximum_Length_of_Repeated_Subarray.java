class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int l=i,h=j,c=0;
                while(l<nums1.length && h<nums2.length && nums1[l]==nums2[h]){
                    c++;
                    l++;
                    h++;
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}

-------------------------------------------------------------------------------------------

class Solution {
    public int findLength(int[] a, int[] b) {
        int n=a.length,m=b.length;
        int[][] dp=new int[n+1][m+1];
        int max=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(a[i]==b[j]){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else dp[i][j]=0;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
