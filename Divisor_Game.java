class Solution {
    public boolean divisorGame(int n) {
        return find(n,0);
    }
    public boolean find(int n,int i){
        if(n<=1){
            if(i==0) return false;
            else return true;
        }
        boolean b;
        if(i==0) b=find(n-1,1);
        else b=find(n-1,0);
        return b;
    }
}

