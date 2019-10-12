
function solve(x){
    let typeOfInput=typeof(x)
if(typeOfInput==="number"){
    console.log( (Math.pow(x,2)*Math.PI).toFixed(2));
}else{
   console.log(`We can not calculate the circle area, because we receive a ${typeOfInput}.`);
}

}

solve("pishka");