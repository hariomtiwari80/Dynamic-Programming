class Solution {
    int n,m;
    public int cherryPickup(int[][] arr) {
        n=arr.length;
        m=arr[0].length;
        HashMap<String,Integer> map=new HashMap<>();
        int ans=solve(arr,0,0,0,0,map);
        if(ans==Integer.MIN_VALUE) return 0;
        return ans;
    }
    public int solve(int[][] arr,int r1,int c1,int r2,int c2,HashMap<String,Integer> map){
        if(r1==n-1 && c1==m-1 && r2==n-1 && c2==m-1) return arr[n-1][m-1];
        if(r1<0 || r2<0 || r1>n-1 || r2>n-1 || c1<0 || c2<0 || c1>m-1 || c2>m-1 || arr[r1][c1]==-1 || arr[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        String s=r1+","+c1+","+r2+","+c2;
        if(map.containsKey(s)) return map.get(s);
        int cherry=0;
        if(r1==r2 && c1==c2) cherry+=arr[r1][c1];
        else cherry+=arr[r1][c1]+arr[r2][c2];
        int rr=solve(arr,r1,c1+1,r2,c2+1,map);
        int rd=solve(arr,r1,c1+1,r2+1,c2,map);
        int dr=solve(arr,r1+1,c1,r2,c2+1,map);
        int dd=solve(arr,r1+1,c1,r2+1,c2,map);
        int max=Math.max(Math.max(rr,rd),Math.max(dr,dd));
        if(max==Integer.MIN_VALUE){
            map.put(s,max);
            return max;
        }
        cherry+=max;
        map.put(s,cherry);
        return cherry;
    }
}
