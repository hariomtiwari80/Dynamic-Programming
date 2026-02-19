class Solution {
    public boolean canJump(int[] arr) {
        Boolean[] dp=new Boolean[arr.length];
        return find(arr,0,dp);
    }
    public boolean find(int[] arr,int i,Boolean[] dp){
        if(i==arr.length-1) return true;
        if(i>=arr.length) return false;
        if(dp[i]!=null) return dp[i];
        boolean b=false;
        for(int j=1;j<=arr[i];j++){
            boolean t=find(arr,i+j,dp);
            b|=t;
        }
        return dp[i]=b;
    }
}

-------------------------------------------------------------------

