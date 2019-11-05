(function solve(){

    String.prototype.isEmpty=function(){
        if(this.length===0){
            return true
        }
        return false
    }

    String.prototype.ensureStart=function(str){
        let arrString=this.split(" ")
        str=str.trim()
        if(arrString[0]!==str){
              arrString.unshift(str)
              return arrString.join(" ")
            
        }else{
           return  arrString.join(" ")
        }
    }
    String.prototype.ensureEnd=function(str){
        str=str.trim()
        let arrString=this.split(" ")
        if(arrString[arrString.length-1]!==str){
              arrString.push(str)
              return arrString.join(" ")
            
        }else{
           return  arrString.join(" ")
        }
    }

    String.format=function(text,...params){
        
        
        params.forEach((e)=>text=text.replace(/\{\d\}/,e))
        
        return text
      
     
        
           
            
        
    }
    String.prototype.truncate=function(n){
        if(n <= 3){
            return ".".repeat(n);
        }
      if(this.toString().length <= n){
          return this.toString();
      } else {
          let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");
          if(lastIndex != -1){
              return this.toString().substr(0, lastIndex) + "...";
          } else {
              return this.toString().substr(0, n-3) + "...";
          }
      }
    }



}())

let str = 'my string';
str = str.ensureStart("my")
console.log(str);
str = str.ensureStart('hello');
console.log(str);

str = String.format('The {0} {1} fox','quick', 'brown');
console.log(str);
str = String.format('jumps {0} {1}',
  'dog');
  console.log(str);
  




