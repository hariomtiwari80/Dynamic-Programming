class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mine) {
        int[][] arr=new int[n][n];
        for(int[] a:arr) Arrays.fill(a,1);
        for(int i=0;i<mine.length;i++){
            arr[mine[i][0]][mine[i][1]]=0;
        }
        int[][] l=new int[n][n];
        int[][] r=new int[n][n];
        int[][] u=new int[n][n];
        int[][] d=new int[n][n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    c++;
                    l[i][j]=c;
                }
                else c=0;
            }
        }
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=n-1;j>=0;j--){
                if(arr[i][j]==1){
                    c++;
                    r[i][j]=c;
                }
                else c=0;
            }
        }
        for(int j=0;j<n;j++){
            int c=0;
            for(int i=0;i<n;i++){
                if(arr[i][j]==1){
                    c++;
                    u[i][j]=c;
                }
                else c=0;
            }
        }
        for(int j=0;j<n;j++){
            int c=0;
            for(int i=n-1;i>=0;i--){
                if(arr[i][j]==1){
                    c++;
                    d[i][j]=c;
                }
                else c=0;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    int c=Math.min(l[i][j],Math.min(r[i][j],Math.min(u[i][j],d[i][j])));
                    ans=Math.max(ans,c);
                }
            }
        }
        return ans;
    }
}
