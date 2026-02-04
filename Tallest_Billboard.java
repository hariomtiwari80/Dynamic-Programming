class Solution {
    public int tallestBillboard(int[] arr) {
        if(arr.length==1) return 0;
        return call(arr,0,0)/2;
    }
    public int call(int[] arr,int i,int diff){
        if(i==arr.length){
            if(diff==0) return 0;
            return Integer.MIN_VALUE;
        }
        int skip=call(arr,i+1,diff);
        int c1=arr[i]+call(arr,i+1,diff+arr[i]);
        int c2=arr[i]+call(arr,i+1,diff-arr[i]);
        return Math.max(skip,Math.max(c1,c2));
    }
}

------------------------------------------------------------

class Solution {
    public int tallestBillboard(int[] arr) {
        if(arr.length==1) return 0;
        HashMap<String,Integer> map=new HashMap<>();
        return call(arr,0,0,map)/2;
    }
    public int call(int[] arr,int i,int diff,HashMap<String,Integer> map){
        if(i==arr.length){
            if(diff==0) return 0;
            return Integer.MIN_VALUE;
        }
        String s=i+","+diff;
        if(map.containsKey(s)) return map.get(s);
        int skip=call(arr,i+1,diff,map);
        int c1=arr[i]+call(arr,i+1,diff+arr[i],map);
        int c2=arr[i]+call(arr,i+1,diff-arr[i],map);
        int ans=Math.max(skip,Math.max(c1,c2));
        map.put(s,ans);
        return ans;
    }
}
