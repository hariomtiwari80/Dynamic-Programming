class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        if(n<2) return false;
        return find(arr,0,0,0);
    }
    public boolean find(int[] arr,int i,int s1,int s2){
        if(i==arr.length){
            if(s1==s2) return true;
            else return false;
        }
        boolean c1=find(arr,i+1,s1+arr[i],s2);
        boolean c2=find(arr,i+1,s1,s2+arr[i]);
        return c1 || c2;
    }
}

------------------------------------------------------------------

class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        if(n<2) return false;
        int sum=0;
        for(int x:arr){
            sum+=x;
        }
        if(sum%2!=0) return false;
        Boolean[][] dp=new Boolean[n+1][sum];
        return find(arr,0,0,sum/2,dp);
    }
    public boolean find(int[] arr,int i,int sum,int tar,Boolean[][] dp){
        if(i==arr.length){
            if(sum==tar) return true;
            return false;
        }
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean take=find(arr,i+1,sum+arr[i],tar,dp);
        boolean skip=find(arr,i+1,sum,tar,dp);
        return dp[i][sum]=(take || skip);
    }
}
