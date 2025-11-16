import java.util.Scanner;

public class Maximum_profit_from_sale_of_wines {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(call(arr,0,n-1));
    }
    public static int call(int[] arr,int i,int j){
        if(i>j) return 0;
        int y=arr.length-(j-i);
        int l=arr[i]*y+call(arr,i+1,j);
        int r=arr[j]*y+call(arr,i,j-1);
        return Math.max(l,r);
    }
}

-----------------------------------------------------

import java.util.*;

public class Maximum_profit_from_sale_of_wines {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][n+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        System.out.println(call(arr,0,n-1,dp));
    }
    public static int call(int[] arr,int i,int j,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int y=arr.length-(j-i);
        int l=arr[i]*y+call(arr,i+1,j,dp);
        int r=arr[j]*y+call(arr,i,j-1,dp);
        return dp[i][j]=Math.max(l,r);
    }
}

-----------------------------------------------------

import java.util.*;

public class Maximum_profit_from_sale_of_wines {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(call(arr));
    }
    public static int call(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=n*arr[i];
        }
        for(int len=1;len<n;len++){
            for(int i=0;i<n-len;i++){
                int j=i+len;
                int y=n-(j-i);
                int l=y*arr[i]+dp[i+1][j];
                int r=y*arr[j]+dp[i][j-1];
                dp[i][j]=Math.max(l,r);
            }
        }
        return dp[0][n-1];
    }
}
