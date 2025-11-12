import java.util.*;

public class MST {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            if(!sc.hasNextInt()) break;
            int n=sc.nextInt();
            System.out.println(solve(n));
        }
    }
    static int solve(int n){
        int[] dp=new int[n+1];
        dp[1]=0;
        for(int j=2;j<=n;j++){
            int sub=dp[j-1];
            int two=Integer.MAX_VALUE;
            int three=Integer.MAX_VALUE;
            if(j%2==0) two=dp[j/2];
            if(j%3==0) three=dp[j/3];
            dp[j]=1+Math.min(Math.min(sub,two),three);
        }
        return dp[n];
    }
}
