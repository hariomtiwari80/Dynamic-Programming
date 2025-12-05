class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] lis=new int[n];
        Arrays.fill(lis,1);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(lis[j]+1>lis[i]){
                        lis[i]=lis[j]+1;
                    }
                }
            }
        }   
        int[] lds=new int[n];
        Arrays.fill(lds,1);
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    if(lds[j]+1>lds[i]){
                        lds[i]=lds[j]+1;
                    }
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            if(lis[i]>1 && lds[i]>1){
                ans=Math.min(ans,n-(lis[i]+lds[i]-1));
            }
        }
        return ans;
    }
}
