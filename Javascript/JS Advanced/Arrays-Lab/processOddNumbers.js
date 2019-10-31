function solve(arr){

    arr=arr.filter((e,i)=>i%2===1).map((e)=>e*2).reverse()
    return arr.join("\n")
}


console.log(solve([3, 0, 10, 4, 7, 3]))