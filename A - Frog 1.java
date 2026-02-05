import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        if(n==1){
            System.out.print(0);
            return;
        }
        if(n==2){
            System.out.print(Math.abs(arr[0]-arr[1]));
            return;
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.print(find(arr,0,dp));
    }
    public static int find(int[] arr,int i,int[] dp){
        if(i==arr.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int take1=Math.abs(arr[i]-arr[i+1])+find(arr,i+1,dp);
        int take2=Integer.MAX_VALUE;
        if(i+2<arr.length) take2=Math.abs(arr[i]-arr[i+2])+find(arr,i+2,dp);
        return dp[i]=Math.min(take1,take2);
    }
}
