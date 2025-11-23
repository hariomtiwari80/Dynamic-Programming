class Solution {
    public int maxSubArray(int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}

-------------------------------------------------

class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        int max=arr[0];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

--------------------------------------------------------

class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int max=arr[0],sum=arr[0];
        for(int i=1;i<n;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
}
