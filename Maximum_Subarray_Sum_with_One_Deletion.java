class Solution {
    public int maximumSum(int[] arr) {
        int max=arr[0],onedel=arr[0],nodel=arr[0];
        for(int i=1;i<arr.length;i++){
            onedel=Math.max(onedel+arr[i],nodel);
            nodel=Math.max(arr[i],nodel+arr[i]);
            max=Math.max(max,Math.max(onedel,nodel));
        }
        return max;
    }
}
