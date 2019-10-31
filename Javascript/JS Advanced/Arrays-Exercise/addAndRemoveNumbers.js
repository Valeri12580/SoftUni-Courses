function solve(arr){
    let result=[]

    arr.forEach((e,i) => {
        e==="add"?result.push(i+1):result.pop()
    });

    return result.length===0?"Empty":result.join("\n")


}



console.log(solve(['remove', 
'remove', 
'remove']
))