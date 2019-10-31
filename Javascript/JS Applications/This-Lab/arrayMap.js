function arrayMap(array,fn){
    
        return array.reduce((acc,curr)=>{
            return [...acc,fn(curr)]
        },[])
    

    



}

console.log(arrayMap([1,2,3],(e)=>e*2));
