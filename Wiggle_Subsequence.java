class Solution {
    public int wiggleMaxLength(int[] arr) {
        if(arr.length==1) return 1;
        int pos=find(arr,0,1,true);
        int neg=find(arr,0,1,false);
        return 1+Math.max(pos,neg);
    }
    public int find(int[] arr,int pre,int i,boolean pos){
        if(i==arr.length) return 0;
        int take=0;
        if(pos && arr[i]>arr[i-1]) take=1+find(arr,i,i+1,!pos);
        else if(!pos && arr[i]<arr[i-1]) take=1+find(arr,i,i+1,!pos);
        int skip=find(arr,pre,i+1,pos);
        return Math.max(take,skip);
    }
}

---------------------------------------------------------------------------

class Solution {
    public int wiggleMaxLength(int[] arr) {
        if(arr.length==1) return 1;
        HashMap<String,Integer> map=new HashMap<>();
        int pos=find(arr,0,1,true,map);
        int neg=find(arr,0,1,false,map);
        return 1+Math.max(pos,neg);
    }
    public int find(int[] arr,int pre,int i,boolean pos,HashMap<String,Integer> map){
        if(i==arr.length) return 0;
        String s=i+","+pre+","+pos;
        if(map.containsKey(s)) return map.get(s);
        int take=0;
        if(pos && arr[i]>arr[i-1]) take=1+find(arr,i,i+1,!pos,map);
        else if(!pos && arr[i]<arr[i-1]) take=1+find(arr,i,i+1,!pos,map);
        int skip=find(arr,pre,i+1,pos,map);
        map.put(s,Math.max(take,skip));
        return Math.max(take,skip);
    }
}
