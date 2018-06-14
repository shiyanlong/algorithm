class Solution {
    public String simplifyPath(String path) {  
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        String str = "";
        for(int i = 0;i < strs.length;i++){
            if(".".equals(strs[i]) || "".equals(strs[i])){
                continue;
            }else if("..".equals(strs[i])){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                }
            else{
                stack.push(strs[i]);
            }
        }
        while(!stack.isEmpty()){
            str = "/" + stack.pop() + str;
        }
        if(str.length() ==0){
            return "/";
        }
        return str;
        }
    }  
