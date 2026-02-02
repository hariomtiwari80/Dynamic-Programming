class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return find(price,special,needs,0);
    }
    public int find(List<Integer> price,List<List<Integer>> off, List<Integer> need,int i){
        if(full(need)){
            return 0;
        }
        if(i==off.size()){
            int sum=0;
            for(int id=0;id<price.size();id++){
                sum+=(need.get(id)*price.get(id));
            }
            return sum;
        }
        int skip=find(price,off,need,i+1);
        int take=Integer.MAX_VALUE;
        if(canTake(off.get(i),need)){
            take=off.get(i).get(price.size())+find(price,off,solve(need,off.get(i)),i); 
        }
        return Math.min(take,skip);
    }
    public List<Integer> solve(List<Integer> need,List<Integer> off){
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<need.size();i++){
            arr.add(need.get(i)-off.get(i));
        }
        return arr;
    }
    public boolean full(List<Integer> arr){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=0) return false;
        }
        return true;
    }
    public boolean canTake(List<Integer> arr,List<Integer> need){
        for(int i=0;i<need.size();i++){
            if(arr.get(i)>need.get(i)) return false;
        }
        return true;
    }
}

-----------------------------------------------------------------------------------------------

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<String,Integer> map=new HashMap<>();
        return find(price,special,needs,0,map);
    }
    public int find(List<Integer> price,List<List<Integer>> off, List<Integer> need,int i,HashMap<String,Integer> map){
        if(full(need)){
            return 0;
        }
        String s=i+","+need;
        if(map.containsKey(s)) return map.get(s);
        if(i==off.size()){
            int sum=0;
            for(int id=0;id<price.size();id++){
                sum+=(need.get(id)*price.get(id));
            }
            return sum;
        }
        int skip=find(price,off,need,i+1,map);
        int take=Integer.MAX_VALUE;
        if(canTake(off.get(i),need)){
            take=off.get(i).get(price.size())+find(price,off,solve(need,off.get(i)),i,map); 
        }
        map.put(s,Math.min(take,skip));
        return Math.min(take,skip);
    }
    public List<Integer> solve(List<Integer> need,List<Integer> off){
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<need.size();i++){
            arr.add(need.get(i)-off.get(i));
        }
        return arr;
    }
    public boolean full(List<Integer> arr){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=0) return false;
        }
        return true;
    }
    public boolean canTake(List<Integer> arr,List<Integer> need){
        for(int i=0;i<need.size();i++){
            if(arr.get(i)>need.get(i)) return false;
        }
        return true;
    }
}
