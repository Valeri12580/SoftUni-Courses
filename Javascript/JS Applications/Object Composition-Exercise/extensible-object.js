function solve(){
    return {
        extend:function(obj){
            Object.entries(obj).forEach(([key,value])=>{
                if(typeof value ==="function"){
                    Object.getPrototypeOf(this)[key]=value;
                }else{
                    this[key]=value
                }

            })
        }
    }


}

let obj=solve();
obj.extend({
    extensionMethod: function () {console.log("da");
    },
    extensionProperty: 'someString'
  })
  console.log(obj);
 console.log( Object.getPrototypeOf(obj));
 
  
