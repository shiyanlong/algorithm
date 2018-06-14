class Solution {
    public List<String> generateParenthesis(int n) {  
        List<String> list = new ArrayList<String>();
        generate("",list,n,n);
        return list;
    }
    
    public void generate(String str,List<String> list,int leftNum,int rightNum){
        if(leftNum > rightNum){
            return;
        }
        if(leftNum > 0){
            generate(str + "(",list,leftNum -1,rightNum);
        }
        if(rightNum > 0){
            generate(str +")",list,leftNum,rightNum -1);
        }
        if(leftNum == 0 && rightNum == 0){
            list.add(str);
        }
    }
    
}