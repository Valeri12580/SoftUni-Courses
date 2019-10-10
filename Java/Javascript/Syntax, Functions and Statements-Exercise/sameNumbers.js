function solve(number) {
    number = String(number).split("");
    let firstChar = number[0];
    let isEquals=true;
    number.forEach(e=>{
        if(e!==firstChar){
            isEquals=false;
        }
    })
    let sum=number.reduce((a,b)=>Number(a)+Number(b))
    console.log(isEquals)
    console.log(sum);


}


solve(222)