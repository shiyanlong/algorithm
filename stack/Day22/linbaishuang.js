/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    var result = new Array();
    var middle = new Array();
    var index = "";
    for(var i=0;i<=path.length;i++){
        if(path[i] === "/"){
            if(index !== "" && index !== null && typeof(index) !== "undefind" ){
                middle.push(index);
                index = "";
            }
        } else if(i === path.length && path[i-1] !== '/'){
            middle.push(index);
        }else {
            index += path[i];
        }
    }
    for(var j=0;j<middle.length;j++){
        if(middle[j] !== '.' && middle[j] !== '..'){
            result.push(middle[j]);
        } else if(middle[j] === '..'){
            result.pop();
        }
    }
    index = "";
    if(result.length === 0){
        return '/';
    } else {
        while(result.length !== 0){
            index =   '/' + result[result.length-1] + index;
            result.pop();
        }
        return index;
    }    
};