function solve(arr){

    let result= arr.reduce((acc,currentValue)=>{
        if(currentValue>=Math.max(...acc)){
            acc.push(currentValue)
           
        }
        return acc
       

    },[])
    return result.join("\n")


}


console.log(solve([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]));