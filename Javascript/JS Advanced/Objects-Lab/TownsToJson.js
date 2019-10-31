function solve(input){
    let keys =input[0].split("|").filter(key=>key!=="");
    keys=keys.map(x=>x.trim())

   
    let result=[];
    let values=[];
    
    for (let index = 1; index < input.length; index++) {
       var row=input[index].split("|").filter(value=>value!=="");
       row=row.map(e=>e.trim());
       let valuesToBe=[];
       for (let j = 0; j < row.length; j++) {
           let value=Number(row[j])
         if(isNaN(value)){
             value=row[j]
         }else{
             value=Math.floor(value*100)/100
         }
           valuesToBe.push(value)
       }
      values.push(valuesToBe)
     
        
    }
    for (let i = 0; i < values.length; i++) {
        let obj={}
        for (let j = 0; j < keys.length; j++) {
         obj[keys[j]]=values[i][j]
            
        }
        
        

    
        result.push(obj)
        
    }
    result=JSON.stringify(result)
    console.log(result);
    
   
    
   




}


solve(['| Town | Latitude | Longitude |',

'| Sofia | 42.696552 | 23.32601 |',

'| Beijing | 39.913818 | 116.363625 |']);