import java.util.*;
public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][4];
        for(int[] a:dp) Arrays.fill(a,-1);
        System.out.print(find(arr,0,-1,dp));
    }
    public static int find(int[][] arr,int i,int last,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][last+1]!=-1) return dp[i][last+1];
        int ans=0;
        for(int j=0;j<3;j++){
            if(j!=last) ans=Math.max(ans,arr[i][j]+find(arr,i+1,j,dp));
        }
        return dp[i][last+1]=ans;
    }
}
