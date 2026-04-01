class Solution {
    public int[] findBall(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        int[] ans=new int[m];
        Arrays.fill(ans,-1);
        for(int j=0;j<m;j++){
            int c=j;
            for(int i=0;i<n;i++){
                if(arr[i][c]==1){
                    if(c==m-1 || arr[i][c+1]==-1){
                        c=-1;
                        break;
                    }
                    c++;
                }
                else{
                    if(c==0 || arr[i][c-1]==1){
                        c=-1;
                        break;
                    }
                    c--;
                }
            }
            ans[j]=c;
        }
        return ans;
    }
}
