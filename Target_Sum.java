class Solution {
    public int ans=0;
    public int findTargetSumWays(int[] arr,int tar) {
        return call(arr,tar,0,0);
    }
    public int call(int[] arr,int tar,int sum,int i){
        if(i==arr.length){
            if(sum==tar) return 1;
            else return 0;
        }
        int t1=call(arr,tar,sum+arr[i],i+1);
        int t2=call(arr,tar,sum-arr[i],i+1);
        return t1+t2;
    }
}

------------------------------------------------------------

class Solution {
    public int ans=0;
    public int findTargetSumWays(int[] arr,int tar) {
        HashMap<String,Integer> dp=new HashMap<>();
        return call(arr,tar,0,dp);
    }
    public int call(int[] arr,int tar,int i,HashMap<String,Integer> dp){
        if(i==arr.length){
            if(tar==0) return 1;
            else return 0;
        }
        String s=i+","+tar;
        if(dp.containsKey(s)) return dp.get(s);
        int t1=call(arr,tar+arr[i],i+1,dp);
        int t2=call(arr,tar-arr[i],i+1,dp);
        dp.put(s,t1+t2);
        return t1+t2;
    }
}
