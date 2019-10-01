function solve(arr){
    arr=arr.map(e=>Number(e))
   

    return arr[0]+arr[arr.length-1]

}


console.log(solve(['5', '10']));