function solve(arr){
    let firstSum=0;
    let secondSum=0;
    let firstIndex=0;
    let secondIndex=arr[0].length-1
    for (const array of arr) {
        firstSum+=array[firstIndex++]
        secondSum+=array[secondIndex--]
        
    }
    console.log(firstSum,secondSum);
    
    
    


    
}


solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]])