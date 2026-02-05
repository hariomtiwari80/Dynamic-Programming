import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
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
        System.out.print(find(arr,0,dp,k));
    }
    public static int find(int[] arr,int i,int[] dp,int k){
        if(i==arr.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(i+j<arr.length){
                min=Math.min(min,Math.abs(arr[i]-arr[i+j])+find(arr,i+j,dp,k));
            }
        }
        return dp[i]=min;
    }
}
