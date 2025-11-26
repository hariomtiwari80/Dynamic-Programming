class Solution {
    public int ans=0,max=0;
    public int findNumberOfLIS(int[] arr) {
        call(arr,-1,0,new ArrayList<>());
        return ans;
    }
    public void call(int[] arr,int pre,int i,List<Integer> l){
        if(i==arr.length){
            if(l.size()>max){
                max=l.size();
                ans=1;
            }
            else if(l.size()==max) ans++;
            return;
        }
        if(pre==-1 || arr[pre]<arr[i]){
            l.add(arr[i]);
            call(arr,i,i+1,l);
            l.remove(l.size()-1);
        }
        call(arr,pre,i+1,l);
    }
}

---------------------------------------------------------------------
