class Solution {
    public int maxOperations(int[] arr) {
        int n=arr.length;
        if(n<2) return 0;
        int f=1+find(arr,2,n-1,arr[0]+arr[1]);
        int l=1+find(arr,0,n-3,arr[n-1]+arr[n-2]);
        int fl=1+find(arr,1,n-2,arr[0]+arr[n-1]);
        return Math.max(f,Math.max(l,fl));
    }
    public int find(int[] arr,int i,int j,int temp){
        if(j-i+1<2) return 0;
        int f=0,l=0,fl=0;
        if(arr[i]+arr[i+1]==temp) f=1+find(arr,i+2,j,temp);
        if(arr[j]+arr[j-1]==temp) l=1+find(arr,i,j-2,temp);
        if(arr[i]+arr[j]==temp) fl=1+find(arr,i+1,j-1,temp);
        return Math.max(f,Math.max(l,fl));
    }
}

---------------------------------------------------------------

class Solution {
    public HashMap<String,Integer> dp;
    public int maxOperations(int[] arr) {
        int n=arr.length;
        if(n<2) return 0;
        dp=new HashMap<>();
        int f=1+find(arr,2,n-1,arr[0]+arr[1]);
        int l=1+find(arr,0,n-3,arr[n-1]+arr[n-2]);
        int fl=1+find(arr,1,n-2,arr[0]+arr[n-1]);
        return Math.max(f,Math.max(l,fl));
    }
    public int find(int[] arr,int i,int j,int temp){
        if(j-i+1<2) return 0;
        String s=i+","+j+","+temp;
        if(dp.containsKey(s)) return dp.get(s);
        int f=0,l=0,fl=0;
        if(arr[i]+arr[i+1]==temp) f=1+find(arr,i+2,j,temp);
        if(arr[j]+arr[j-1]==temp) l=1+find(arr,i,j-2,temp);
        if(arr[i]+arr[j]==temp) fl=1+find(arr,i+1,j-1,temp);
        int ans=Math.max(f,Math.max(l,fl));
        dp.put(s,ans);
        return ans;
    }
}
