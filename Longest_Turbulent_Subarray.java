class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        if(n<=1) return n;
        int max1=1,max2=1,ans=1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                max1=max2+1;
                max2=1;
            }
            else if(arr[i]<arr[i-1]){
                max2=max1+1;
                max1=1;
            }
            else if(arr[i]==arr[i-1]){
                max1=1;
                max2=1;
            }
            ans=Math.max(ans,Math.max(max1,max2));
        }
        return ans;
    }
}
