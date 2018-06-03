var letterCasePermutation = function(S) {
    var arr = new Array();
    result(arr, S, 0);
    return arr;
};

var result = function(arr, s, i){
    var len = s.length;
    if(i >= len){
        arr.push(s);
        return;
    }
    if(s[i] >= "a" && s[i] <= "z"){
        let str1 = s[i].toUpperCase();
        s = s.slice(0, i) + str1 + s.slice(i+1, len);
        result(arr, s, i+1);
        let str2 = s[i].toLowerCase()
        s = s.slice(0, i) + str2 + s.slice(i+1, len);   
    }
    if(s[i] >= "A" && s[i] <= "Z"){
        let str1 = s[i].toLowerCase();
        s = s.slice(0, i) + str1 + s.slice(i+1, len);
        console.log(s[i]);
        result(arr, s, i+1);
        let str2 = s[i].toUpperCase();
        s = s.slice(0, i) + str2 + s.slice(i+1, len);
    }
    console.log(s[i]);
    console.log("aa");
    result(arr, s, i+1);

}