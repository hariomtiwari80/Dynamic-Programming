class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1.length<=1) return 0;
        Arrays.sort(arr2);
        int ans=find(arr1,arr2,Integer.MIN_VALUE,0); 
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    public int find(int[] arr1,int[] arr2,int pre,int i){
        if(i==arr1.length) return 0;
        int case1=(int)1e9;
        int case2=(int)1e9;
        if(arr1[i]>pre) case1=find(arr1,arr2,arr1[i],i+1);
        int ub=binary(arr2,pre);
        if(ub<arr2.length){
            case2=1+find(arr1,arr2,arr2[ub],i+1);
        }
        return Math.min(case1,case2);
    }
    public int binary(int[] arr,int t){
        int n=arr.length;
        if(n==0) return 0;
        int l=0,h=n;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]<=t) l=m+1;
            else h=m; 
        }
        return l;
    }
}

-----------------------------------------------------

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1.length<=1) return 0;
        Arrays.sort(arr2);
        HashMap<String,Integer> map=new HashMap<>();
        int ans=find(arr1,arr2,Integer.MIN_VALUE,0,map); 
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    public int find(int[] arr1,int[] arr2,int pre,int i,HashMap<String,Integer> map){
        if(i==arr1.length) return 0;
        String s=i+","+pre;
        if(map.containsKey(s)) return map.get(s);
        int case1=(int)1e9;
        int case2=(int)1e9;
        if(arr1[i]>pre) case1=find(arr1,arr2,arr1[i],i+1,map);
        int ub=binary(arr2,pre);
        if(ub<arr2.length){
            case2=1+find(arr1,arr2,arr2[ub],i+1,map);
        }
        int last=Math.min(case1,case2);
        map.put(s,last);
        return last;
    }
    public int binary(int[] arr,int t){
        int n=arr.length;
        if(n==0) return 0;
        int l=0,h=n;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]<=t) l=m+1;
            else h=m; 
        }
        return l;
    }
}
