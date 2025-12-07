class Solution {
    public int maxHeight(int[][] arr) {
        int n=arr.length;
        for(int[] a:arr){
            Arrays.sort(a);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]) return a[2]-b[2];
                else return a[1]-b[1];
            }
            else return a[0]-b[0];
        });
        int[] dp=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i]=arr[i][2];
            for(int j=i-1;j>=0;j--){
                if(arr[i][0]>=arr[j][0] && arr[i][1]>=arr[j][1] && arr[i][2]>=arr[j][2]){
                    if(dp[j]+arr[i][2]>dp[i]){
                        dp[i]=dp[j]+arr[i][2];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
