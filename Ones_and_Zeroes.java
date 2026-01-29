class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return solve(strs,m,n,0);
    }
    public int solve(String[] s,int m,int n,int i){
        if(i==s.length) return 0;
        int zeroes=z(s[i]);
        int ones=o(s[i]);
        int take=0;
        if(zeroes<=m && ones<=n){
            take=1+solve(s,m-zeroes,n-ones,i+1);
        }
        int skip=solve(s,m,n,i+1);
        return Math.max(take,skip);
    }
    public int z(String s){
        int t=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') t++;
        }
        return t;
    }
    public int o(String s){
        int t=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') t++;
        }
        return t;
    }
}

-----------------------------------------------------------

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(strs,m,n,0,map);
    }
    public int solve(String[] s,int m,int n,int i,HashMap<String,Integer> map){
        if(i==s.length) return 0;
        String t=m+","+n+","+i;
        if(map.containsKey(t)) return map.get(t);
        int zeroes=z(s[i]);
        int ones=o(s[i]);
        int take=0;
        if(zeroes<=m && ones<=n){
            take=1+solve(s,m-zeroes,n-ones,i+1,map);
        }
        int skip=solve(s,m,n,i+1,map);
        map.put(t,Math.max(take,skip));
        return Math.max(take,skip);
    }
    public int z(String s){
        int t=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') t++;
        }
        return t;
    }
    public int o(String s){
        int t=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') t++;
        }
        return t;
    }
}
