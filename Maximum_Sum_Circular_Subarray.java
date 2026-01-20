class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        if(n<=0) return 0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,kadane(arr));
            rotate(arr);
        }
        return ans;
    }
    public int kadane(int[] arr){
        int sum=arr[0],max=arr[0];
        for(int i=1;i<arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
    public void rotate(int[] arr){
        int n=arr.length;
        int t=arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=t;
    }
}

-------------------------------------------------------------

class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        if(n<=0) return 0;
        int max=Maxkadane(arr);
        int min=Minkadane(arr);
        int sum=find(arr);
        int cir=sum-min;
        if(max<0) return max;
        return Math.max(cir,max);
    }
    public int Maxkadane(int[] arr){
        int sum=arr[0],max=arr[0];
        for(int i=1;i<arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
    public int find(int[] arr){
        int sum=arr[0];
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public int Minkadane(int[] arr){
        int sum=arr[0],min=arr[0];
        for(int i=1;i<arr.length;i++){
            sum=Math.min(sum+arr[i],arr[i]);
            min=Math.min(min,sum);
        }
        return min;
    }
}
