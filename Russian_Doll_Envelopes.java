class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        return find(arr,-1,0);
    }
    public int find(int[][] arr,int pre,int i){
        if(i==arr.length) return 0;
        int take=0;
        if(pre==-1 || (arr[pre][0]<arr[i][0] && arr[pre][1]<arr[i][1])){
            take=1+find(arr,i,i+1);
        }
        int skip=find(arr,pre,i+1);
        return Math.max(take,skip);
    }
}

-----------------------------------------------------------------------------------------

class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int n=arr.length;
        int[][] dp=new int[n+1][n];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return find(arr,-1,0,dp);
    }
    public int find(int[][] arr,int pre,int i,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[pre+1][i]!=-1) return dp[pre+1][i];
        int take=0;
        if(pre==-1 || (arr[pre][0]<arr[i][0] && arr[pre][1]<arr[i][1])){
            take=1+find(arr,i,i+1,dp);
        }
        int skip=find(arr,pre,i+1,dp);
        return dp[pre+1][i]=Math.max(take,skip);
    }
}

------------------------------------------------------------------------------------------------

class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

---------------------------------------------------------------------------------------------------

class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b) -> {
            if (a[0]==b[0]) 
                return b[1]-a[1];
            return a[0]-b[0];
        });
        int n=arr.length;
        int[] dp=new int[n];
        int size=0;
        for(int i=0;i<n;i++){
            int idx=binary(dp,size,arr[i][1]);
            dp[idx]=arr[i][1];
            if(idx==size) size++;
        }
        return size;
    }
    public int binary(int[] dp,int size,int n){
        int l=0,h=size;
        while(l<h){
            int m=l+(h-l)/2;
            if(dp[m]<n) l=m+1;
            else h=m;
        }
        return l;
    }
}
