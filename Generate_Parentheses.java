class Solution {
    public List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(n,0,0,"");
        return ans;
    }
    public void solve(int n,int i,int j,String temp){
        if(i==n && j==n){
            ans.add(temp);
            return;
        }
        if(i<n) solve(n,i+1,j,temp+'(');
        if(j<n && j<i) solve(n,i,j+1,temp+')');
    }
}

--------------------------------------------------

