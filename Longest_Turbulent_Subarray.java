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
--------------------------------------------------------------
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        if(n<=1) return n;
        int ans=1;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                boolean b=true;
                int k=i;
                while(k<n-1){
                    if(arr[k]==arr[k+1]) break;
                    if(b && arr[k]<arr[k+1]) break;
                    if(!b && arr[k]>arr[k+1]) break;
                    b=!b;
                    k++;
                }
                ans=Math.max(ans,k-i+1);
            }
            else if(arr[i]<arr[i+1]){
                boolean b=true;
                int k=i;
                while(k<n-1){
                    if(arr[k]==arr[k+1]) break;
                    if(b && arr[k]>arr[k+1]) break;
                    if(!b && arr[k]<arr[k+1]) break;
                    b=!b;
                    k++;
                }
                ans=Math.max(ans,k-i+1);
            }
        }
        return ans;
    }
}
