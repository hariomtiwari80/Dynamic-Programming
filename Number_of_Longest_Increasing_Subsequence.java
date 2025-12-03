class Solution {
    public int ans=0,max=0;
    public int findNumberOfLIS(int[] arr) {
        call(arr,-1,0,new ArrayList<>());
        return ans;
    }
    public void call(int[] arr,int pre,int i,List<Integer> l){
        if(i==arr.length){
            if(l.size()>max){
                max=l.size();
                ans=1;
            }
            else if(l.size()==max) ans++;
            return;
        }
        if(pre==-1 || arr[pre]<arr[i]){
            l.add(arr[i]);
            call(arr,i,i+1,l);
            l.remove(l.size()-1);
        }
        call(arr,pre,i+1,l);
    }
}

---------------------------------------------------------------------


    class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        if(n==1) return 1;
        int[] dp=new int[n];
        int[] rep=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(rep,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        rep[i]=rep[j];
                    }
                    else if(dp[j]+1==dp[i]){
                        rep[i]+=rep[j];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) ans+=rep[i];
        }
        return ans;
    }
}
