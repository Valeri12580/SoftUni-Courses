function solve(arr){
    let element=+arr.pop();

   arr= arr.filter((e,i)=>i%element===0)
   return arr.join("\n")
}



console.log(solve(['5', 
'20', 
'31', 
'4', 
'20', 
'2']));