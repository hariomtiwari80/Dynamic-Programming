import java.util.*;

public class Ladder_With_K_Steps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(call(n,k));
    }
    public static int call(int n,int k){
        if(n==0) return 1;
        if(n<0) return 0;
        int take=0;
        for(int i=1;i<=k;i++){
            take+=call(n-i,k);
        }
        return take;
    }
}

----------------------------------------------

import java.util.*;

public class Ladder_With_K_Steps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(call(n,k,dp));
    }
    public static int call(int n,int k,int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int take=0;
        for(int i=1;i<=k;i++){
            take+=call(n-i,k,dp);
        }
        return dp[n]=take;
    }
}

-------------------------------------------------

import java.util.*;

public class Ladder_With_K_Steps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int take=0;
            for(int j=i-1;j>=i-k;j--){
                if(j<0) break;
                take+=dp[j];
            }
            dp[i]=take;
        }
        System.out.println(dp[n]);
    }
}
