function solve(arr){
    arr=arr.sort((e1,e2)=>{
        let comp=e1.length-e2.length;
        if(comp===0){
            comp=e1.toLowerCase().localeCompare(e2.toLowerCase())
        }
        return comp
    })
    console.log(arr.join("\n"));
    


}

solve(['alpha', 
'beta', 
'gamma'])