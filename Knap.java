import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int W=sc.nextInt();
        int[] w=new int[n];
        int[] p=new int[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
            p[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][W+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        System.out.print(solve(p,w,W,0,dp));
    }
    public static int solve(int[] p,int[] w,int W,int i,int[][] dp){
        if(i==p.length || W==0) return 0;
        if(dp[i][W]!=-1) return dp[i][W];
        int skip=solve(p,w,W,i+1,dp);
        int take=0;
        if(w[i]<=W) take=p[i]+solve(p,w,W-w[i],i+1,dp);
        return dp[i][W]=Math.max(take,skip);
    }
}
