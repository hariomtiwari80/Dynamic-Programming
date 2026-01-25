class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=find(i);
        }
        return ans;
    }
    public int find(int n){
        String s=Integer.toBinaryString(n);
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') c++;
        }
        return c;
    }
}

----------------------------------------------------------

