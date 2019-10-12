
function solve(fruit,weight,money){
    let sum=(weight*money)/1000;
    sum=sum.toFixed(2);
    let fixedWeight=weight/1000
    fixedWeight=fixedWeight.toFixed(2)

    console.log( `I need $${sum} to buy ${fixedWeight} kilograms ${fruit}.`)


}

solve('orange', 2500, 1.80);