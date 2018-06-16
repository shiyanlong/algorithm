class Solution {
    public int lengthOfLongestSubstring(String s) {
        int flag = 0;
        
        String max = "";
        String cur = "";
        for(int i = 0;i<s.length();){
            if(cur.indexOf(s.charAt(i))!=-1){
                if(cur.length() > max.length()){
                    max = cur;     
                }
                flag =i- (cur.length()-cur.indexOf(s.charAt(i)))+1 ;
                cur = s.substring(flag,i+1);
            }else{
                cur = s.substring(flag,i+1);
                
            }
            i++;  
        }
        return max.length()>cur.length() ? max.length() :cur.length();
    }
}