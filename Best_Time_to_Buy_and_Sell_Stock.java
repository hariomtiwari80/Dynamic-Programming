class Solution {
    public int maxProfit(int[] arr) {
        int p=0,n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                p=Math.max(p,arr[j]-arr[i]);
            }
        }
        return p;
    }
}

-----------------------------------------------

