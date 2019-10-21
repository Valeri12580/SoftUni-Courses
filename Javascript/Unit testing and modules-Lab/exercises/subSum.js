function sum(arr,start,end){
    if(!Array.isArray(arr)){
        return NaN
    }
  
    return arr.map(e=>Number(e)).slice(start<0?0:start,end?end+1:arr.length).reduce((acc,curr)=>acc+curr,0)
}



console.log(sum([1,"Valeri",1],0,3));

module.exports=sum