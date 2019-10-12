

function solve(input){
    let obj={};
    for (let index = 0; index < input.length-1; index+=2) {
        let name=input[index];
        let income=+input[index+1];
        if(obj.hasOwnProperty(name)){
            obj[name]=obj[name]+income
            continue;
        }
        obj[name]=income
        
    }

    console.log(JSON.stringify(obj));
    




}


solve(['Sofia','20','Varna','3','Sofia','5','Varna','4'])