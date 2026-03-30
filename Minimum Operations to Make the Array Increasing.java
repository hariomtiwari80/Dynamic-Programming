class Solution {
    public int minOperations(int[] arr) {
        int n=arr.length;
        if(n<=1) return 0;
        int need=arr[0]+1;
        int ans=0;
        for(int i=1;i<n;i++){
            if(arr[i]<need){
                ans+=need-arr[i];
                arr[i]=need;
                need++;
            }
            else need=arr[i]+1;
        }
        return ans;
    }
}
