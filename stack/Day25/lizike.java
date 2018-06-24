class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        String str = "";
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while(k >0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            str = stack.pop() + str;
        }
        for(int i=0;i<=str.length();i++){
            if(i == str.length()){
                return "0";
            }
            if(str.charAt(i) != '0'){
                str = str.substring(i,str.length());
                break;
            }
        }
        return str.length()>0 ?str:"0";
    }
}