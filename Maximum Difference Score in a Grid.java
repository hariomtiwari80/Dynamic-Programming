class Solution {
    public int maxScore(List<List<Integer>> arr) {
        int m=arr.size(),n=arr.get(0).size();
        int[][] max=new int[m][n];
        for(int[] a:max) Arrays.fill(a,Integer.MIN_VALUE);
        int ans=Integer.MIN_VALUE;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i<m-1){
                    ans=Math.max(ans,max[i+1][j]-arr.get(i).get(j));
                }
                if(j<n-1){
                    ans=Math.max(ans,max[i][j+1]-arr.get(i).get(j));
                }
                max[i][j]=arr.get(i).get(j);
                if(i<m-1){
                    max[i][j]=Math.max(max[i][j],max[i+1][j]);
                }
                if(j<n-1){
                    max[i][j]=Math.max(max[i][j],max[i][j+1]);
                }
            }
        }
        return ans;
    }
}
