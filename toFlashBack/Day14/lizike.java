class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        int len = s.length();
        List<String> list = new ArrayList<>();
        if(s.length() < 4){
            return list;
        }
        for(int i = 1; i < len - 2&& i < 4; i++){
            for(int j = i + 1; j < len - 1&& j < i + 4;j++){
                for(int z = j + 1; z < len&& z < j + 4; z++){
                    if(len - z > 4){
                        continue;
                    }
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,z);
                    String s4 = s.substring(z);
                    if(Integer.parseInt(s.substring(0,i)) > 255){continue;}
                    if(Integer.parseInt(s.substring(i,j)) > 255){continue;}
                    if(Integer.parseInt(s.substring(j,z)) > 255){continue;}
                    if(Integer.parseInt(s.substring(z)) > 255){continue;}
                    if(s1.length() > 1 && s1.indexOf("0") == 0 ){
                        continue;
                    }
                    if(s2.length() > 1 && s2.indexOf("0") == 0 ){
                        continue;
                    }
                    if(s3.length() > 1 && s3.indexOf("0") == 0 ){
                        continue;
                    }
                    if(s4.length() > 1 && s4.indexOf("0") == 0 ){
                        continue;
                    }
                    String ns = s1 + "." + s2 + "." + s3 + "." + s4;
                    list.add(ns);
                }
            }
        }
        return list;
    }
}