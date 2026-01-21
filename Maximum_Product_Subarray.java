class Solution {
    public int maxProduct(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int max=arr[0],min=arr[0],ans=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(max*arr[i],arr[i]);
            min=Math.min(min*arr[i],arr[i]);
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
