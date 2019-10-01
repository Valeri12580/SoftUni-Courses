function solve(arr){
    let results=[]
    for (const iterator of arr) {
        iterator>=0?results.push(iterator):results.unshift(iterator)

       
    }
    return results.join("\n")

}



console.log(solve([3, -2, 0, -1]));
