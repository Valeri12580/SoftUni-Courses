function solve(arr){
    let steps=arr.pop()%arr.length
    for (let i = 0; i < steps; i++) {
        arr.unshift(arr.pop())
        
    }
    return arr.join(" ")


}

console.log(
    solve(['Banana', 
    'Orange', 
    'Coconut', 
    'Apple', 
    '15']))