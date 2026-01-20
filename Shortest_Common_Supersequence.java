class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String l=lcs(str1,str2,0,0);
        int i=0,j=0;
        String ans="";
        for(int k=0;k<l.length();k++){
            while(i<str1.length() && str1.charAt(i)!=l.charAt(k)){
                ans+=str1.charAt(i++);
            }
            while(j<str2.length() && str2.charAt(j)!=l.charAt(k)){
                ans+=str2.charAt(j++);
            }
            ans+=l.charAt(k);
            i++;
            j++;
        }
        while (i<str1.length()) ans+=(str1.charAt(i++));
        while (j<str2.length()) ans+=(str2.charAt(j++));
        return ans;

    }
    public String lcs(String s1,String s2,int i,int j){
        if(i==s1.length() || j==s2.length()) return "";
        String s="";
        if(s1.charAt(i)==s2.charAt(j)){
            s=s1.charAt(i)+lcs(s1,s2,i+1,j+1);
        }
        else{
            String take1=lcs(s1,s2,i+1,j);
            String take2=lcs(s1,s2,i,j+1);
            if(take1.length()>take2.length()) s=take1;
            else s=take2;
        }
        return s;

    }
}

---------------------------------------------------------------------------

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        HashMap<String,String> dp=new HashMap<>();
        String l=lcs(str1,str2,0,0,dp);
        int i=0,j=0;
        String ans="";
        for(int k=0;k<l.length();k++){
            while(i<str1.length() && str1.charAt(i)!=l.charAt(k)){
                ans+=str1.charAt(i++);
            }
            while(j<str2.length() && str2.charAt(j)!=l.charAt(k)){
                ans+=str2.charAt(j++);
            }
            ans+=l.charAt(k);
            i++;
            j++;
        }
        while (i<str1.length()) ans+=(str1.charAt(i++));
        while (j<str2.length()) ans+=(str2.charAt(j++));
        return ans;

    }
    public String lcs(String s1,String s2,int i,int j,HashMap<String,String> dp){
        if(i==s1.length() || j==s2.length()) return "";
        String t=i+","+j;
        if(dp.containsKey(t)) return dp.get(t);
        String s="";
        if(s1.charAt(i)==s2.charAt(j)){
            s=s1.charAt(i)+lcs(s1,s2,i+1,j+1,dp);
        }
        else{
            String take1=lcs(s1,s2,i+1,j,dp);
            String take2=lcs(s1,s2,i,j+1,dp);
            if(take1.length()>take2.length()) s=take1;
            else s=take2;
        }
        dp.put(t,s);
        return s;

    }
}
