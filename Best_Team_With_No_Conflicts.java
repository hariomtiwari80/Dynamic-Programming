class Solution {
    class pair{
        int s,a;
        pair(int a,int s){
            this.s=s;
            this.a=a;
        }
    }
    public int bestTeamScore(int[] score, int[] age) {
        int n=score.length;
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            p[i]=new pair(age[i],score[i]);
        }
        Arrays.sort(p,(a,b)->{
            if(a.a==b.a) return a.s-b.s;
            else return a.a-b.a;
        });
        int max=p[0].s;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=p[i].s;
        }
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if((p[i].s>=p[j].s)){
                    if(dp[i]<dp[j]+p[i].s){
                        dp[i]=dp[j]+p[i].s;
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
