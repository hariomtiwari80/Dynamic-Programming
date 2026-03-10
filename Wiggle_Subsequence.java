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

-------------------------------------------------------------------------------------

class Solution {
    public int wiggleMaxLength(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[2][n];
        for(int[] a:dp) Arrays.fill(a,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if((arr[i]-arr[j])<0){
                    dp[1][i]=Math.max(dp[1][i],1+dp[0][j]);
                    ans=Math.max(ans,dp[1][i]);
                }
                else if((arr[i]-arr[j]>0)){
                    dp[0][i]=Math.max(dp[0][i],1+dp[1][j]);
                    ans=Math.max(ans,dp[0][i]);
                }
            }
        } 
        return ans;
    }
}
