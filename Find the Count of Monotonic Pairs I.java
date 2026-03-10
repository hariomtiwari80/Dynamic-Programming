class Solution {
    public int countOfPairs(int[] arr) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(arr,0,Integer.MAX_VALUE,0,map);
    }
    public int solve(int[] arr,int pre1,int pre2,int i,HashMap<String,Integer> map){
        if(i==arr.length) return 1;
        String s=i+","+pre1+","+pre2;
        if(map.containsKey(s)) return map.get(s);
        int ans=0;
        for(int j=pre1;j<=arr[i];j++){
            int arr1=j;
            int arr2=arr[i]-arr1;
            if(arr1>=pre1 && arr2<=pre2) ans+=solve(arr,arr1,arr2,i+1,map);
            ans%=1_000_000_007;
        }
        map.put(s,ans);
        return ans;
    }
}
