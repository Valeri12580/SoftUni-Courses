function solve(n,k){

    let result=[1]
    let indexOfCut=1;
    for (let i = 0; i < n-1; i++) {
        if(indexOfCut<k){
            let sum = result.slice(result.length-indexOfCut).reduce((acumulator,value)=>acumulator+value)
        result.push(sum)
        indexOfCut++
        }else{
            let sum = result.slice(result.length-k).reduce((acumulator,value)=>acumulator+value)
            result.push(sum)
        }
       
        
    }
    return result

    

   
  


}


console.log(solve(6, 3))